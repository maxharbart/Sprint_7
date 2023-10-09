import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(Parameterized.class)
public class OrderTest {
    private OrderClient orderClient;
    private Order order;
    private int track;
    private int statusCode;

    @Before
    public void setUp() {
        orderClient = new OrderClient();
    }

    @After
    public void cleanUp() {
        ValidatableResponse responseDelete = orderClient.cancel(track);
        int actualStatusCode = responseDelete.extract().statusCode();
        assertEquals(SC_OK,actualStatusCode);
    }

    public OrderTest(Order order, int statusCode) {
        this.order = order;
        this.statusCode = statusCode;
    }

    @Parameterized.Parameters(name = "Тестовые данные: заказ: {0}; ожидаемый ответ сервера: {1}")
    public static Object[][] getTestData() {
        return new Object[][] {
                {OrderGenerator.getDefault(),SC_OK},
                {OrderGenerator.getColor(List.of("GREY")) , SC_OK},
                {OrderGenerator.getColor(List.of("BLACK")), SC_OK},
                {OrderGenerator.getColor(List.of("")), SC_OK}
        };
    }

    @Test
    @DisplayName("Create order")
    @Description("Test for post request to /api/v1/order")
    public void orderCreatedPositive() {
        ValidatableResponse responseCreate = orderClient.create(order);
        int actualStatusCode = responseCreate.extract().statusCode();
        assertEquals(SC_CREATED,actualStatusCode);
        track = responseCreate.extract().path("track");
        assertNotNull(track);
    }
}
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class OrderListTest {
    private OrderClient orderClient;
    private Order order;
    private int track;

    @Before
    public void setUp() {
        orderClient = new OrderClient();
        order = OrderGenerator.getDefault();
    }

    @After
    public void cleanUp() {
        ValidatableResponse responseDelete = orderClient.cancel(track);
        int actualStatusCode = responseDelete.extract().statusCode();
        assertEquals(SC_OK,actualStatusCode);
    }

    @Test
    @DisplayName("Get orders")
    @Description("Test for post request to /api/v1/orders")
    public void getOrderList() {
        ValidatableResponse responseCreate = orderClient.create(order);
        track = responseCreate.extract().path("track");
        ValidatableResponse responseGetOrders = orderClient.orderList();
        int statusCodeGetList = responseGetOrders.extract().statusCode();
        assertEquals(SC_OK,statusCodeGetList);
        ArrayList<String> listOrders = responseGetOrders.extract().path("orders");
        assertNotNull(listOrders);
    }
}

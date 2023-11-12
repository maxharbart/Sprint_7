import com.github.javafaker.Faker;

public class CourierGenerator {
    private static final Faker faker = new Faker();

    public static Courier getDefault() {
        return new Courier(faker.name().username(), faker.internet().password(), faker.name().firstName());
    }

    public static Courier getPasswordOnly() {
        return new Courier(null, "none", null);
    }

    public static Courier getLoginOnly() {
        return new Courier(faker.name().username(), "", "");
    }

    public static Courier getNameOnly() {
        return new Courier("", "", faker.name().firstName());
    }
}

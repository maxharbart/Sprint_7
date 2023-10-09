public class CourierGenerator {

    public static Courier getDefault() {
        return new Courier("maxim39","password1","Max");
    }

    public static Courier getPasswordOnly() {
        return new Courier(null,"none",null);
    }

    public static Courier getLoginOnly() {
        return new Courier("Ivan","","");
    }

    public static Courier getNameOnly() {
        return new Courier("","","Max");
    }
}
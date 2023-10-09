import java.util.List;

public class OrderGenerator {

    public static Order getDefault() {
        List<String> color = List.of("BLACK,GREY");
        return new Order("max","miller","lenina 101","3","9999999999",2,"2023-10-19","comment",color);
    }

    public static Order getColor(List<String> color) {
        return new Order("julian","brandt","mira 10","5","9999999999",2,"2023-10-20","comment",color);
    }
}
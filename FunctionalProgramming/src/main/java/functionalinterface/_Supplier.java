package functionalinterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        System.out.println("simple function");
        System.out.println(getDBConnectionUrl());

        System.out.println("supplier");
        System.out.println(getDBConnectionUrlSupplier.get());
    }

    static String getDBConnectionUrl() {
        return "jdbc://localhost:5432/users";
    }

    static Supplier<List<String>> getDBConnectionUrlSupplier = () -> List.of("jdbc://localhost:5432/users", "jdbc://localhost:5432/customer");
}

package order;

import java.util.Arrays;
import example.*;

public class OrdersTestData {

    public static Order bodyPostWithBlack() {
        return new Order("Наташа", "Романофф", "Staropetr pr. 26", 26, "+7 800 355 35 35", 12, "2025-01-22", "Привезти самокат чистым", Arrays.asList("BLACK"));
    }

    public static Order bodyPostWithGrey() {
        return new Order("Питер", "Паркер", "Staropetr pr. 26", 26, "+7 800 355 35 35", 12, "2025-01-22", "Привезти самокат чистым", Arrays.asList("GREY"));
    }

    public static Order bodyPostWithBothColors() {
        return new Order("Тони", "Старк", "Staropetr pr. 4", 26, "+7 800 355 35 35", 12, "2025-01-22", "Привезти самокат чистым", Arrays.asList("BLACK", "GREY"));
    }

    public static Order bodyPostWithNonColors() {
        return new Order("Стивен", "Роджерс", "Staropetr pr. 4", 26, "+7 800 355 35 35", 12, "2025-01-22", "Привезти самокат чистым", Arrays.asList());
    }

}

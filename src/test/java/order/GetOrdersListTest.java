package order;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;


public class GetOrdersListTest {

    private OrderSteps orderSteps = new OrderSteps();

    @Test
    @DisplayName("Проверка - получение списка заказов")
    public void getOrdersListTest() {
        Response getOrders = orderSteps.getFiveOrders();
        List<Integer> orders = orderSteps.getOrdersId(getOrders);
        Assert.assertEquals(5, orders.size());
    }
}

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;


public class GetOrdersListTest {

    private OrderSteps orderSteps = new OrderSteps();

    @Test
    public void getOrdersListTest() {
        Response getOrders = orderSteps.getFiveOrders();
        List<Integer> orders = orderSteps.getOrdersId(getOrders);
        Assert.assertEquals(5, orders.size());
    }
}

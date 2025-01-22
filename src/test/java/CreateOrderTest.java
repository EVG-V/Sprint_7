import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(Parameterized.class)
public class CreateOrderTest {

    private Order order;
    private CourierSteps courierSteps = new CourierSteps();

    public CreateOrderTest(Order order) {
        this.order = order;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {OrdersTestData.bodyPostWithBlack()},
                {OrdersTestData.bodyPostWithGrey()},
                {OrdersTestData.bodyPostWithBothColors()},
                {OrdersTestData.bodyPostWithNonColors()}
        };
    }

    @Test
    public void createOrder() {
        Response createOrder = courierSteps.createOrder(order);
        createOrder.then().body("track", notNullValue());
        createOrder.then().statusCode(201);
    }

}

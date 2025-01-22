import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;

public class OrderSteps {

    ScooterApi scooterApi = new ScooterApi();
    CourierSteps courierSteps = new CourierSteps();

    @Step
    public Response acceptOrder(String idOrder, String idCourier) {
        return scooterApi.doPut(idOrder, idCourier);
    }

    @Step
    public Integer getCourierId() {
        Response postLogin = courierSteps.loginCourier(CourierTestData.bodyPost());
        return postLogin.jsonPath().getInt("id");
    }

    @Step
    public Integer getOrderId() {
        Response getFiveOrders = getFiveOrders();
        List<Integer> ordersList = getOrdersId(getFiveOrders);
        return ordersList.get(0);
    }

    @Step
    public Response getFiveOrders() {
        return scooterApi.doGet();
    }

    @Step
    public List<Integer> getOrdersId(Response OrdersList) {
        JsonPath jsonPath = new JsonPath(OrdersList.body().asString());
        return jsonPath.getList("orders.id");
    }
}

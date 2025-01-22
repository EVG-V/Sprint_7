import io.qameta.allure.Step;
import io.restassured.response.Response;

public class CourierSteps {

    private ScooterApi scooterApi = new ScooterApi();

    @Step
    public boolean checkingThatNoCourier() {
        return scooterApi.doPostLogin(CourierTestData.bodyPost()).getStatusCode() != 200;
    }

    @Step
    public Response createCourier() {
        return scooterApi.doPostCreate(CourierTestData.bodyPost());
    }

    @Step
    public Response loginCourier(Courier courier) {
        return scooterApi.doPostLogin(courier);
    }

    @Step
    public Response loginCourierNotFullData() {
        return scooterApi.doPostLogin(CourierTestData.notFullBodyPost());
    }

    @Step
    public Response loginCourierIncorrectData() {
        return scooterApi.doPostLogin(CourierTestData.bodyPostWithIncorrectData());
    }

    @Step
    public Response loginCourierNonExistentData() {
        return scooterApi.doPostLogin(CourierTestData.bodyPostWithNonExistentData());
    }

    @Step
    public Response loginCourierNotCompleteData() {
        return scooterApi.doPostLogin(CourierTestData.notCompleteBodyPost());
    }

    @Step
    public void createCourierIfDoesNotExist() {
        if (checkingThatNoCourier()) {
            createCourier();
        }
    }

    @Step
    public void deleteCourierIfExist() {
        if(!checkingThatNoCourier()) {
            Response postLogin = loginCourier(CourierTestData.bodyPost());
            deleteCourier(postLogin.jsonPath().getString("id"));
        }

    }

    @Step
    public Response createCourierNotFullData() {
        return scooterApi.doPostCreate(CourierTestData.notFullBodyPost());
    }

    @Step
    public Response createCourierNotCompleteData() {
        return scooterApi.doPostCreate(CourierTestData.notCompleteBodyPost());
    }

    @Step
    public Response createCourierWithExistingLogin() {
        return scooterApi.doPostCreate(CourierTestData.bodyPostWithExistingLogin());
    }

    @Step
    public Response createOrder(Order order) {
        return scooterApi.doPostOrder(order);
    }

    @Step
    public Response deleteCourier(String id) {
        return scooterApi.doDelete(id);
    }

}

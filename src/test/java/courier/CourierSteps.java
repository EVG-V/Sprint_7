package courier;
import example.*;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class CourierSteps {

    private ScooterApi scooterApi = new ScooterApi();

    @Step ("Проверяем, что курьер не был создан ранее")
    public boolean checkingThatNoCourier() {
        return scooterApi.doPostLogin(CourierTestData.bodyPost()).getStatusCode() != 200;
    }

    @Step ("Создаем курьера")
    public Response createCourier() {
        return scooterApi.doPostCreate(CourierTestData.bodyPost());
    }

    @Step ("Входим в систему")
    public Response loginCourier(Courier courier) {
        return scooterApi.doPostLogin(courier);
    }

    @Step ("Входим в систему без пароля")
    public Response loginCourierNotFullData() {
        return scooterApi.doPostLogin(CourierTestData.notFullBodyPost());
    }

    @Step ("Входим в систему с некорректными данными")
    public Response loginCourierIncorrectData() {
        return scooterApi.doPostLogin(CourierTestData.bodyPostWithIncorrectData());
    }

    @Step ("Входим в систему с несуществующим логином")
    public Response loginCourierNonExistentData() {
        return scooterApi.doPostLogin(CourierTestData.bodyPostWithNonExistentData());
    }

    @Step ("Входим в систему, если пароль = null")
    public Response loginCourierNotCompleteData() {
        return scooterApi.doPostLogin(CourierTestData.notCompleteBodyPost());
    }

    @Step("Cоздаем курьера")
    public void createCourierIfDoesNotExist() {
        if (checkingThatNoCourier()) {
            createCourier();
        }
    }

    @Step("Удаляем курьера")
    public void deleteCourierIfExist() {
        if(!checkingThatNoCourier()) {
            Response postLogin = loginCourier(CourierTestData.bodyPost());
            deleteCourier(postLogin.jsonPath().getString("id"));
        }

    }

    @Step("Создаем курьера с пустым паролем")
    public Response createCourierNotFullData() {
        return scooterApi.doPostCreate(CourierTestData.notFullBodyPost());
    }

    @Step("Создаем курьера с паролем null")
    public Response createCourierNotCompleteData() {
        return scooterApi.doPostCreate(CourierTestData.notCompleteBodyPost());
    }

    @Step("Создаем курьера с существующим логином")
    public Response createCourierWithExistingLogin() {
        return scooterApi.doPostCreate(CourierTestData.bodyPostWithExistingLogin());
    }

    @Step("Создаем заказ")
    public Response createOrder(Order order) {
        return scooterApi.doPostOrder(order);
    }

    @Step("Удаляем курьера")
    public Response deleteCourier(String id) {
        return scooterApi.doDelete(id);
    }

}

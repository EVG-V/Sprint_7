package courier;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.notNullValue;

public class LoginCourierTests {

    private CourierSteps courierSteps = new CourierSteps();

    @Before
    public void createCourier() {
       courierSteps.createCourierIfDoesNotExist();
    }

    @Test
    @DisplayName("Проверка - Успешный вход")
    public void loginCourierTest() {
        Response postLogin = courierSteps.loginCourier(CourierTestData.bodyPost());
        postLogin.then().statusCode(200);
    }

    @Test
    @DisplayName("Проверка - вход без указания пароля")
    public void loginCourierNotFullData() {
        Response postLogin = courierSteps.loginCourierNotFullData();
        postLogin.then().statusCode(400);
    }

    @Test
    @DisplayName("Проверка - вход с паролем  = null")
    public void loginCourierNotCompleteData() {
        Response postLogin = courierSteps.loginCourierNotCompleteData();
        postLogin.then().statusCode(504);
    }

    @Test
    @DisplayName("Проверка - вход с некорректными данными")
    public void loginCourierIncorrectData() {
        Response postLogin = courierSteps.loginCourierIncorrectData();
        postLogin.then().statusCode(404);
    }

    @Test
    @DisplayName("Проверка - вход, кода пользователя не существует в системе")
    public void loginNonExistentUser() {
        Response postLogin = courierSteps.loginCourierNonExistentData();
        postLogin.then().statusCode(404);
    }

    @Test
    @DisplayName("Проверка - ответ")
    public void loginCourierCheckResponse() {
        Response postLogin = courierSteps.loginCourier(CourierTestData.bodyPost());
        postLogin.then().body("id", notNullValue());
    }

    @After
    public void deleteCourier() {
        courierSteps.deleteCourierIfExist();
    }
}

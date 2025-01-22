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
    public void loginCourierTest() {
        Response postLogin = courierSteps.loginCourier(CourierTestData.bodyPost());
        postLogin.then().statusCode(200);
    }

    @Test
    public void loginCourierNotFullData() {
        Response postLogin = courierSteps.loginCourierNotFullData();
        postLogin.then().statusCode(400);
    }

    @Test
    public void loginCourierNotCompleteData() {
        Response postLogin = courierSteps.loginCourierNotCompleteData();
        postLogin.then().statusCode(504);
    }

    @Test
    public void loginCourierIncorrectData() {
        Response postLogin = courierSteps.loginCourierIncorrectData();
        postLogin.then().statusCode(404);
    }

    @Test
    public void loginNonExistentUser() {
        Response postLogin = courierSteps.loginCourierNonExistentData();
        postLogin.then().statusCode(404);
    }

    @Test
    public void loginCourierCheckResponse() {
        Response postLogin = courierSteps.loginCourier(CourierTestData.bodyPost());
        postLogin.then().body("id", notNullValue());
    }

    @After
    public void deleteCourier() {
        courierSteps.deleteCourierIfExist();
    }
}

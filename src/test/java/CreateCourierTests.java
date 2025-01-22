import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class CreateCourierTests {
    private CourierSteps courierSteps = new CourierSteps();

    @Before
    public void deleteCourierIfExist() {
        courierSteps.deleteCourierIfExist();
    }

    @Test
    public void createCourier() {
        Response createCourier = courierSteps.createCourier();
        createCourier.then().statusCode(201);
    }

    @Test
    public void createCourierCheckResponse() {
        Response createCourier = courierSteps.createCourier();
        createCourier.then().body("ok", equalTo(true));
    }

    @Test
    public void cantCreateTwoIdenticalCouriers() {
        courierSteps.createCourierIfDoesNotExist();
        Response createCourier = courierSteps.createCourier();
        createCourier.then().statusCode(409);
    }

    @Test
    public void cantCreateCourierNotFullData() {
        Response createCourier = courierSteps.createCourierNotFullData();
        createCourier.then().statusCode(400);
    }

    @Test
    public void cantCreateCourierNotCompleteData() {
        Response createCourier = courierSteps.createCourierNotCompleteData();
        createCourier.then().statusCode(400);
    }

    @Test
    public void cantCreateCourierWithExistingLogin() {
        courierSteps.createCourierIfDoesNotExist();
        Response createCourier = courierSteps.createCourierWithExistingLogin();
        createCourier.then().statusCode(409);
    }

    @After
    public void deleteCourier() {
        courierSteps.deleteCourierIfExist();
    }
}

package com.restful.booker.crudtest;

import com.restful.booker.model.UserPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UserPostBooking extends TestBase {

    @Test
    public void createAuth(){
        UserPojo userPojo = new UserPojo();
        userPojo.setUsername("admin");
        userPojo.setPassword("password123");
    }

    @Test
    public void createUser(){
        List<String>checkInOut = new ArrayList<String>();
        checkInOut.add("2018-01-01");
        checkInOut.add("2019-01-01");
        UserPojo userPojo = new UserPojo();
        userPojo.setFirstname("Jim"+ getRandomValue());
        userPojo.setLastname("Brown"+ getRandomValue());
        userPojo.setTotalPrice(111);
        userPojo.setDepositpaid(true);
        userPojo.setBookingdates(checkInOut);
        userPojo.setAdditionalneeds("Breakfast");

        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .when()
                .body(userPojo)
                .post();
        response.prettyPrint();
        response.then().log().all().statusCode(201);

    }

}

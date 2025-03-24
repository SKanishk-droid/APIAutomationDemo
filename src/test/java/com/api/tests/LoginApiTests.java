package com.api.tests;

import static io.restassured.RestAssured.*;/*For readability*/

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginApiTests {

    @Test(description = "verify If Login API is working...")
    public void loginTest() {
        /*RestAssured.baseURI = "http://64.227.160.186:8080";*/

        /*RequestSpecification x = RestAssured.given();
        RequestSpecification y = x.header("Content-Type", "application/json");
        RequestSpecification z = y.body("{\n" +
                "  \"username\": \"Kanishk\",\n" +
                "  \"password\": \"Sonu@2002\"\n" +
                "}");
        Response response = z.post("/api/auth/login");
        System.out.println(response.asPrettyString());*/



        /*Response response =
                given()
                        .baseUri("http://64.227.160.186:8080")
                .header("Content-Type", "application/json")
                .body("{\n" +
                "  \"username\": \"Kanishk\",\n" +
                "  \"password\": \"Sonu@2002\"\n" +
                "}")
                .post("/api/auth/login");
        System.out.println(response.asPrettyString());

        This was based on Builder Design Pattern
        Assert.assertEquals(response.getStatusCode(),200);
    */

        /*AuthService authService = new AuthService();
        Response response = authService.login("{\n" +
                "  \"username\": \"Kanishk\",\n" +
                "  \"password\": \"Sonu@2002\"\n" +
                "}");*/

        LoginRequest loginRequest = new LoginRequest("Kanishk","Sonu@2002");
        AuthService authService = new AuthService();
        Response response = authService.login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);

//      System.out.println(response.asPrettyString());
        System.out.println(loginResponse.getToken());
        System.out.println(loginResponse.getEmail());
        System.out.println(loginResponse.getId());

        Assert.assertTrue(loginResponse.getToken() != null);
    }
}

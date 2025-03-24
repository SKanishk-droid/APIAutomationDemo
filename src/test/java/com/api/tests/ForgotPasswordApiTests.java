package com.api.tests;

import com.api.base.AuthService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ForgotPasswordApiTests {
    @Test(description = "Verify if the ForgotApi is Working")
    public void forgotPasswordTests(){
        AuthService authService = new AuthService();
        Response response = authService.forgotPassword("Sonu@gmail.com");
        System.out.println(response.asPrettyString());
    }
}

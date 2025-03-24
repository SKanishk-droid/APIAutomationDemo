package com.api.tests;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class SignInApiTests {

    @Test(description = "Verify if the SignUp is Working")
    public void signInTests(){

        SignUpRequest signUpRequest = new SignUpRequest.Builder()
                .userName("Kanishk819")
                .email("Sonu@gmail.com")
                .firstName("Kanishk")
                .lastName("Shukla")
                .password("rozhok87")
                .mobileNumber("1234567890")
                .build();

        AuthService authService = new AuthService();
        Response signupResponse = authService.signup(signUpRequest);

        System.out.println(signupResponse.asPrettyString());
    }
}

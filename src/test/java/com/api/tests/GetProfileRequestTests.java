package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetProfileRequestTests {
    @Test
    public void getProfileInfoTest(){

        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("Kanishk819", "rozhok87"));
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(loginResponse.getToken());

        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        Response profileResponse = userProfileManagementService.getProfile(loginResponse.getToken());
        UserProfileResponse userProfileResponse = profileResponse.as(UserProfileResponse.class);
        System.out.println(userProfileResponse);
//        Assert.assertEquals(profileResponse.statusCode(),200);
    }
}

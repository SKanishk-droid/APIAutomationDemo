package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateProfileApiTests {
    @Test
    public void updateProfileInfoTest(){

        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("Kanishk819", "rozhok87"));
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(loginResponse.getToken());

        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        response = userProfileManagementService.getProfile(loginResponse.getToken());
        System.out.println(response.prettyPrint());
        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
        Assert.assertEquals(userProfileResponse.getUsername(),"Kanishk819");

        ProfileRequest profileRequest = new ProfileRequest.ProfileRequestBuilder()
                .setFirstName("Kanishk718")
                .setLastName("Shukla98")
                .setEmail("Sonu@gmail.com")
                .setMobileNumber("0987654321")
                .build();


        response = userProfileManagementService.updateProfile(profileRequest,loginResponse.getToken());
        System.out.println(response.asPrettyString());


    }
}

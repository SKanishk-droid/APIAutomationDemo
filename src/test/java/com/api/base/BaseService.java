package com.api.base;

import com.api.filters.LoggingFilter;
import com.api.models.request.LoginRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;/*For readability*/
import io.restassured.response.Response;

public class BaseService {
    //Wrapper For Rest Assured !!
    //Handles Base URI
    //Creating The Request
    //Handling The Response

    static {
        RestAssured.filters(new LoggingFilter());
    }

    private static final String BASE_URL = "http://64.227.160.186:8080";
    private RequestSpecification requestSpecification;

    public BaseService() {
        requestSpecification = given().baseUri(BASE_URL);
    }

    protected void setAuthToken(String token){
        requestSpecification.header("Authorization", "Bearer " + token);
    }

    /*protected Response postRequest(String payload,String endpoint){
       return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
    }*/

    protected Response getRequest(String endpoint){
        return requestSpecification.get(endpoint);
    }

    protected Response postRequest(Object payload, String endpoint){
       return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
    }

    protected Response putRequest(Object payload, String endpoint){
        return requestSpecification.contentType(ContentType.JSON).body(payload).put(endpoint);
    }
}

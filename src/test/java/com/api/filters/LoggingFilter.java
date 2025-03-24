package com.api.filters;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingFilter implements Filter {

    private static final Logger LOGGER = LogManager.getLogger(LoggingFilter.class);

    @Override
    public Response filter(FilterableRequestSpecification filterableRequestSpecification, FilterableResponseSpecification filterableResponseSpecification, FilterContext filterContext) {
        logRequest(filterableRequestSpecification);
        Response response = filterContext.next(filterableRequestSpecification,filterableResponseSpecification);//Request is going to be executed
        return response;
    }

    public void logRequest(FilterableRequestSpecification requestSpecification){
        LOGGER.info("BASE URI: "+requestSpecification.getBaseUri());
        LOGGER.info("REQUSET HEADER: "+requestSpecification.getHeaders());
        LOGGER.info("REQUSET PAYLOAD: "+requestSpecification.getBody());
    }

    public void logResponse(Response response){
        LOGGER.info("STATUS CODE : "+response.getStatusCode());
        LOGGER.info("REQUSET HEADER: "+response.headers());
        LOGGER.info("REQUSET PAYLOAD: "+response.getBody().prettyPrint());
    }
}

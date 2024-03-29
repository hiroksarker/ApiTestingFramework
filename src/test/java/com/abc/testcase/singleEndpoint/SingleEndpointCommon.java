package com.abc.testcase.singleEndpoint;

import com.abc.util.ObjectFactory;
import com.abc.util.PropertyReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import static com.abc.constant.ResponseCodeConstant.STATUS_CODE_200;
import static com.abc.constant.ServiceConstant.BASE_URL;

public class SingleEndpointCommon extends PropertyReader {

    protected static RequestSpecification requestSpecification;
    protected static ResponseSpecification responseSpecification;

    // Singleton instance of softAssert
    protected SoftAssert softAssert = ObjectFactory.getSoftAssert();

    /*******************************************************************
     * Create a static RequestSpecification and set BaseUrl:
     * Create a static ResponseSpecification that checks whether:
     * - the response has statusCode 200
     * - the response contentType is JSON
     ******************************************************************/
    @BeforeClass
    public static void setUp() {
        requestSpecification = new RequestSpecBuilder().
                setBaseUri(prop.getProperty(BASE_URL)).
                build();

        responseSpecification = new ResponseSpecBuilder().
                expectStatusCode(STATUS_CODE_200).
                expectContentType(ContentType.JSON).
                build();
    }
}
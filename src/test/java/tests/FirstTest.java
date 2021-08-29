package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class FirstTest {

    @BeforeClass
    public static void init(){
        RestAssured.baseURI = "http://localhost:8080";
        RestAssured.basePath = "/api/users/";
    }

    //http://localhost:8080/swagger-ui.html#/
    @Title("GET send request")
    @Test
    public void testGetRequest(){

        Response response =SerenityRest
                .given()
                .when()
                    .get("4")
        ;
        response.prettyPrint();
        response.then().statusCode(200);
        response.then().body("firstName", Matchers.equalTo("Chris"));
    }
}

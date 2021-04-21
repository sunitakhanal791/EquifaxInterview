import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.net.URI;
import java.util.Locale;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;


public class RestAssured {



    @Test

    public static void getCall() {
        getResponseBody();
        getResponseStatus();
    }

    public static void getResponseBody(){

        given().when().get("http://dummy.restapiexample.com/api/v1/employees").then().log()
                .all();
    }

    public static void getResponseStatus(){
        int statusCode = given().when().get("http://dummy.restapiexample.com/api/v1/employees").getStatusCode();
        System.out.println("Status Code:" + statusCode);

        given().when().get("http://dummy.restapiexample.com/api/v1/employees").then().assertThat().statusCode(200);
    }

    @Test

    public void deleteRequest(){
      int deletestatusCode = given().when()
              .delete("http://dummy.restapiexample.com/api/v1/delete/2").getStatusCode();
      System.out.println("Status Code" + deletestatusCode);

      given().when().delete("http://dummy.restapiexample.com/api/v1/delete/2").then().statusCode(200);

      ResponseBody response = given().when().delete("http://dummy.restapiexample.com/api/v1/delete/2").getBody();
      String responseString = response.asString();
        Assert.assertEquals(responseString, responseString, "successfully! deleted Records");



    }

}

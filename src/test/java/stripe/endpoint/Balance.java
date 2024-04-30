package stripe.endpoint;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
public class Balance extends BaseAPI {
    public static ValidatableResponse retrieveBalance() {
        RequestSpecification request = given()
                                      .config(RestAssured.config()
                                      .encoderConfig(EncoderConfig.encoderConfig()
                                      .encodeContentTypeAs("x-www-form-urlencoded", ContentType.URLENC)))
                                      .header("Authorization", "Bearer " + Token);

        ValidatableResponse response = request.get(Retrieve_Balance_URL).then().assertThat().statusCode(200);
        return response;
    }


    public void validateBalanceResponseSchema(String schemaPath) {
        ValidatableResponse retrievedResponse = retrieveBalance();
        System.out.println(schemaPath);
      retrievedResponse.assertThat().body(matchesJsonSchemaInClasspath(schemaPath));
    }
}

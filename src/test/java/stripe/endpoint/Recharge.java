package stripe.endpoint;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class Recharge extends BaseAPI {
    public  int  chargeAmount ;
    public  String  chargeCurrency ;
    public  String  amountAuthorized ;
    public  String  cardBrand ;
    public  String  exp_month ;
    public  String  exp_year;

    public void createARecharge(String amount, String currency, String source, String description)
     {
         RequestSpecification request = given()
                         .config(RestAssured.config()
                         .encoderConfig(EncoderConfig.encoderConfig()
                         .encodeContentTypeAs("x-www-form-urlencoded", ContentType.URLENC)))
                         .queryParam("source",source)
                         .queryParam("description",description)
                         .queryParam("currency",currency)
                         .queryParam("amount",amount)
                         .header("Authorization","Bearer "+ Token);


         ValidatableResponse response =  request
                                        .post(Create_Charge_URL).then().assertThat().statusCode(200) ;


         cardBrand= response.extract().body().jsonPath().getString("payment_method_details.card.brand");
         chargeAmount = response.extract().body().jsonPath().getInt("amount");
         chargeCurrency = response.extract().body().jsonPath().getString("currency");
         amountAuthorized = response.extract().body().jsonPath().getString("payment_method_details.card.amount_authorized");
         exp_year = response.extract().body().jsonPath().getString("payment_method_details.card.exp_year");
         exp_month = response.extract().body().jsonPath().getString("payment_method_details.card.exp_month");
    }


    public void verifyCardBrand(String brand){
        Assert.assertEquals(cardBrand,brand);
    }
    public void verifyChargeAmount(String amount){
        Assert.assertEquals(chargeAmount, amount);
    }

    public void verifyChargeAmountNotEqualZero() {
        int currentBalance =chargeAmount;
        Assert.assertNotEquals(currentBalance, 0);
    }
    public void verifyAuthorizedAmount(String amount){
        Assert.assertEquals(amountAuthorized, amount);
    }

    public void verifyChargeCurrency(String currency){
        Assert.assertEquals(chargeCurrency, currency);
    }

    public void verifyExp_year (String year){
        Assert.assertEquals(exp_year , year);
    }

    public void verifyExp_month (String month){
        Assert.assertEquals(exp_month, month);
    }
}


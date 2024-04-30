package stripe.endpoint;

public class BaseAPI {
    protected static final String Token = "sk_test_51P8Rqg2MrX0AJuYkeGANm6IHoz18xKYNgHEFqAbfTyfOvr67vLQtdnKQm1MJyduht0ZpoGWYRhYkJgffbOZTJFm500stdygbTS";
    public static  String BaseURL = "https://api.stripe.com/v1";
    public static  String ChargingEndPoint = "/charges";
    public static  String BalanceEndPoint = "/balance";
    public static String Create_Charge_URL = BaseURL+ ChargingEndPoint;
    public static String Retrieve_Balance_URL = BaseURL+ BalanceEndPoint ;
}

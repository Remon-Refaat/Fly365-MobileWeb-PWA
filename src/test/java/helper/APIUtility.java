package helper;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIUtility extends TestBase {

    GeneralMethods gmObject = new GeneralMethods();

    public static String orderNumber = null;
    public static String orderID = null;

    public String oneWayAPI() {
        String departureDate1 = gmObject.addDateWithCertainPeriodAndFormat(10, "yyyy-MM-dd");
        String oneWay = "{\"legs\": [{\"origin\": \"DMS\",\"destination\": \"CAI\",\"departureDate\": \"" + departureDate1 + "\"}],\n" +
                " \"cabinClass\": \"Economy\",\"infant\": 0,\"child\": 0,\"adult\": 1}";
        return oneWay;
    }

    public String roundTripAPI() {
        String departureDate1 = gmObject.addDateWithCertainPeriodAndFormat(10, "yyyy-MM-dd");
        String departureDate2 = gmObject.addDateWithCertainPeriodAndFormat(20, "yyyy-MM-dd");
        String roundTrip = "{\"legs\": [{\"origin\": \"DMS\",\"destination\": \"CAI\",\"departureDate\": \"" + departureDate1 + "\"\n" +
                "   },{\"origin\": \"CAI\",\"destination\": \"DMS\",\"departureDate\": \"" + departureDate2 + "\"}],\n" +
                " \"cabinClass\": \"Economy\",\"infant\": 0,\"child\": 0,\"adult\": 1}";
        return roundTrip;
    }

    public String multiCityAPI() {
        String departureDate1 = gmObject.addDateWithCertainPeriodAndFormat(10, "yyyy-MM-dd");
        String departureDate2 = gmObject.addDateWithCertainPeriodAndFormat(20, "yyyy-MM-dd");
        String departureDate3 = gmObject.addDateWithCertainPeriodAndFormat(30, "yyyy-MM-dd");
        String multiCity = "{\"legs\": [{\"origin\": \"DMS\",\"destination\": \"CAI\",\"departureDate\": \"" + departureDate1 + "\"\n" +
                "   },{\"origin\": \"CAI\",\"destination\": \"DMS\",\"departureDate\": \"" + departureDate2 + "\"},{\"origin\": \"CAI\",\n" +
                "     \"destination\": \"DXB\",\"departureDate\": \"" + departureDate3 + "\"}],\n" +
                " \"cabinClass\": \"Economy\",\"infant\": 0,\"child\": 0,\"adult\": 1}";
        return multiCity;
    }

    public static String sendRequest(String requestUrl, String tripType, String apiType) {
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod(apiType);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("x-store-id", "fly365_com");
            connection.setRequestProperty("authorization", "guMRjevTJNNgv49LRTNCTzfp9cWnW6Sj");
            connection.setRequestProperty("x-store-user", "fly365_com_nz");
            if (apiType == "POST"){
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
            writer.write(tripType);
            writer.close();
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer jsonString = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                jsonString.append(line);
            }
            br.close();
            connection.disconnect();
            return jsonString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public static String getItineraryId(String returnedJsongString, int tripnumber) {
        JSONObject jObject = new JSONObject(returnedJsongString);
        JSONArray arr = jObject.getJSONArray("itineraries");
        String itineraryId = null;
        for (int i = 0; i < arr.length(); i++) {
            itineraryId = arr.getJSONObject(tripnumber - 1).getString("itineraryId");
        }
        return itineraryId;
    }


    public static String createCart(String itineraryId, String domain) {

        String createCartAPI = "{\"itineraryId\": \"" + itineraryId + "\"}";
        String returnedJsonString = sendRequest("https://api.fly365" + domain + ".com/flight/cart", createCartAPI, "POST");
        JSONObject jObject = new JSONObject(returnedJsonString);
        return jObject.getString("id");

    }

    public static void addPassenger(String cartID, String domain) {

        String addPassengerDetailsAPI = "{\"passengers\": [" +
                "{\"firstName\": \"John\",\"middleName\": \"William\",\"lastName\": \"Smith\",\"title\": \"Mr\",\"dateOfBirth\": \"1991-06-04\"," +
                "\"reference\": \"123\",\"passengerType\": \"ADT\",\"frequentFlyerOptions\": {\"airlineCode\": \"code\",\"number\": \"num\"" +
                "}}],\"customer\": {\"title\": \"mr\",\"firstName\": \"John\",\"lastName\": \"William\",\"email\": \"john.smith.fly365pwa@gmail.com\"," +
                "\"mobileNumber\": \"0121234567\"}}";
        sendRequest("https://api.fly365" + domain + ".com/flight/cart/" + cartID + "/passenger", addPassengerDetailsAPI, "POST");

    }

    public static void checkoutTrip(String cartID, String domain) {

        String addCardDetailsAPI = "{\"method\":\"cc\",\"type\":\"direct\",\"card\":{\"number\":\"4242424242424242\",\"cvv\":\"123\",\n" +
                "\"expiryDate\":\"1120\",\"type\":\"visa\",\"holderName\": \"Alaa Attya\"},\n" +
                " \"billingAddress\":{\"address\":\"Something\",\"country\":\"DO\",\"city\":\"AZS\",\"zipCode\":\"5678\",\"state\":\"NY\"}}";
        String returnedJsonString = sendRequest("https://api.fly365" + domain + ".com/flight/cart/" + cartID + "/checkout", addCardDetailsAPI, "POST");

//To validate that the order no./pnr number is displayed correctly in retrieve my booking
        JSONObject jObject = new JSONObject(returnedJsonString);
        orderNumber = jObject.getJSONObject("order").getString("orderNumber");
        orderID = jObject.getJSONObject("order").getString("orderId");
    }

    public static String getFlightDetails(String details, String domain){
        String returnedJsonString = sendRequest("https://api.fly365" + domain + ".com/user/order/find?orderNumber="+orderNumber+"&orderId="+orderID+"", "", "GET");
        JSONObject jObject = new JSONObject(returnedJsonString);
        String pnrNumber = jObject.getString(details);
        return pnrNumber;
    }
}

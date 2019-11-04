package step_definition;

import cucumber.api.java.en.And;
import helper.APIUtility;
import helper.TestBase;

public class APITest extends TestBase {

    public static String fly365Reference = null;
    APIUtility apiObject = new APIUtility();

    @And("^Book a trip from API for \"(.*)\"$")
    public void bookATripFromAPIForAndGet(String domain) {
        String requestUrl = "https://api.fly365" + domain + ".com/flight-search/search";
        String allAvailableTrips = apiObject.sendRequest(requestUrl, apiObject.oneWayAPI(), "POST");
        String itinaryID = apiObject.getItineraryId(allAvailableTrips, 2);
        String cardID = apiObject.createCart(itinaryID, domain);
        apiObject.addPassenger(cardID, domain);
        apiObject.checkoutTrip(cardID, domain);
    }

    @And("^Get Fly365 Reference for the trip$")
    public void getTheFollowingDetailsForTheTrip() {
     fly365Reference = apiObject.getFlightDetails("flightPNR","stage");
    }
}

package step_definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import helper.GeneralMethods;
import helper.TestBase;
import org.openqa.selenium.By;


public class HomeTest extends TestBase {

    GeneralMethods gmObject = new GeneralMethods();

    By oneWayTAB = By.xpath("//a[text()='One Way']");
    By originTXT = By.xpath("//input[@aria-label='From']");
    By destinationTXT = By.xpath("//input[@aria-label='To']");
    By origingSearchFieldTXT = By.xpath("//*[@id='app']/div[4]//div[1]//input");
    By destinationSearchFieldTXT = By.xpath("//*[@id='app']/div[3]//div[1]//input");
    By airportSearchResult = By.xpath("//*[@id='app']//div[2]//div[2]/span");
    By departureCalenderDPK = By.xpath("//*[@id='flight-0']/div[3]//input");
    By calendarArrowBTN = By.xpath("//div/button[@aria-label='Move forward to switch to the next month.']");
    By calendarSaveBTN = By.xpath("//button/div[text()='save']");
    By passengerCabinMENU = By.xpath("//input[@aria-label='Passengers and cabin class']");
    By plusAdultBTN = By.xpath("//div[1]/div[2]/button[2]");
    By plusChildBTN = By.xpath("//div[2]/div[2]/button[2]");
    By plusInfantBTN = By.xpath("//div[3]/div[2]/button[2]");
    By cabinClassSaveBTN = By.xpath("//button/div[text()='Save']");
    By searchNowBTN = By.xpath("//button/div[text()='search now']");

    @Given("^Select One Way trip$")
    public void selectOneWayTrip(){
        driver.findElement(oneWayTAB).click();
    }


    @And("^Add airport to the Origin \"(.*)\"$")
    public void addAirportToTheOrigin(String originAirport) throws InterruptedException {
        driver.findElement(originTXT).click();
        driver.findElement(origingSearchFieldTXT).sendKeys(originAirport);
        Thread.sleep(1000);
        driver.findElement(airportSearchResult).click();
    }

    @And("^Add airport to the Destination \"(.*)\"$")
    public void addAirportToTheDestination(String originAirport) throws InterruptedException {
        driver.findElement(destinationTXT).click();
        driver.findElement(destinationSearchFieldTXT).sendKeys(originAirport);
        Thread.sleep(1000);
        driver.findElement(airportSearchResult).click();
    }


    @And("^Select the date of the departure, after \"(.*)\" day from today$")
    public void selectTheDateOfTheDepartureAfterDayFromToday(int period)  {
        driver.findElement(departureCalenderDPK).click();
        String departureDate = gmObject.addDateWithCertainPeriodAndFormat(period, "yyyy-MM-dd");
        if (driver.findElement(By.xpath("//button[@date='"+departureDate+"']")).isDisplayed()){
            driver.findElement(By.xpath("//button[@date='"+departureDate+"']")).click();
        }
        else {
        driver.findElement(calendarArrowBTN).click();
        driver.findElement(By.xpath("//button[@date='"+departureDate+"']")).click();
        }
        driver.findElement(calendarSaveBTN).click();
    }

    @And("^Select Passengers: \"(.*)\" adult, \"(.*)\" child, \"(.*)\" infant$")
    public void selectPassengersAdultChildInfant(int adultCount, int childCount, int infantCount) {

        driver.findElement(passengerCabinMENU).click();

        for (int counter = 0; counter < (adultCount - 1); counter++) {
            driver.findElement(plusAdultBTN).click();
        }

        for (int counter = 0; counter < childCount; counter++) {
            driver.findElement(plusChildBTN).click();
        }

        for (int counter = 0; counter < infantCount; counter++) {
            driver.findElement(plusInfantBTN).click();
        }

        driver.findElement(cabinClassSaveBTN).click();

    }

    @And("^Select \"(.*)\" Class$")
    public void selectClass(String cabinClass)  {
        driver.findElement(passengerCabinMENU).click();
        driver.findElement(By.xpath("//label[text()='" + cabinClass + "']/preceding-sibling::div")).click();
        driver.findElement(cabinClassSaveBTN).click();
    }

    @And("^Press on Search Now$")
    public void pressOnSearchNow() {
        driver.findElement(searchNowBTN).click();
    }
}

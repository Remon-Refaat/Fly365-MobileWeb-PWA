package step_definition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import helper.DataBase;
import helper.TestBase;

public class DataBaseTest extends TestBase {

    @And("^Delete the user \"(.*)\" if he exists in the database$")
    public void deleteTheUserIfHeExistsInTheDatabase(String userEmail) {
            DataBase.execute_query_dbs("k8stage1.cl9iojf4kdop.eu-west-1.rds.amazonaws.com:5432", "user_api", "delete from users where \"email\"='" +userEmail+ "' ");
    }

    @And("^Delete the subscribed user \"(.*)\" if he exists in the database$")
    public void deleteTheSubscribedUserIfHeExistsInTheDataBase(String userEmail) {
            DataBase.execute_query_dbs("k8stage1.cl9iojf4kdop.eu-west-1.rds.amazonaws.com:5432", "user_api", "delete from newsletter_users where email='" + userEmail + "'");
    }

    @And("^Insert new user at database \"(.*)\" \"(.*)\"$")
    public void InsertNewUserAtDataBase(String userEmail, String userHashPassWord) {
        DataBase.execute_update("k8stage1.cl9iojf4kdop.eu-west-1.rds.amazonaws.com:5432", "user_api", "insert into users (email, \"lastName\",\"firstName\",password,\"storeId\", \"groupId\",\"title\",\"phoneNumber\",\"isActive\",\"isLocked\")values('" + userEmail + "','Smith','John','" + userHashPassWord + "','fly365_com','fly365','Mr','+20 136253637474',True,False)");
    }

    @And("^Delete payment card \"(.*)\" from database$")
    public void deletePaymentCardFromDatabase(String creditCardNumber) {
            DataBase.execute_query_dbs("k8stage1.cl9iojf4kdop.eu-west-1.rds.amazonaws.com:5432", "payment_api", "delete from user_cards where \"email\" = 'john.smith.fly365pwa@gmail.com' and \"lastFourDigits\" = '"+creditCardNumber.substring(creditCardNumber.length()-4)+"'");
    }

    @And("^Delete traveller \"([^\"]*)\" from database$")
    public void deleteTravellerFromDatabase(String travellerName)  {

        String firstName = travellerName.replaceAll("\\s\\w*\\s\\w*","");
        String lastName = travellerName.replaceAll("\\w*\\s\\w*\\s","");
        DataBase.execute_query_dbs("k8stage1.cl9iojf4kdop.eu-west-1.rds.amazonaws.com:5432", "payment_api", "delete from travellers where \"firstName\" = '"+firstName+"' and \"lastName\" = '"+lastName+"'");

    }
}

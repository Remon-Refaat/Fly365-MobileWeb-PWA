package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GeneralMethods extends TestBase {
    public String addDateWithCertainPeriodAndFormat(int period, String pattern) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, period);
        SimpleDateFormat simpleFormat = new SimpleDateFormat(pattern);
        String date = simpleFormat.format(cal.getTime());
        return date;
    }

    public void selectDateFromDDL(By option, String value) {
        Select dayDDL = new Select(driver.findElement(option));
        dayDDL.selectByValue(value);
    }
}

package helper;

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
}

package flightBooking;

import java.time.DayOfWeek;
import java.time.LocalDate;

// An abstract class "searchFlight"
abstract public class searchFlight extends abstractClass {

    String sFromI, sDestinationI, sDepDateI, sDayI;

    // constructor 
    searchFlight(String sFromI, String sDestinationI, String sDepDateI) {
        this.sFromI = sFromI;
        this.sDestinationI = sDestinationI;
        this.sDepDateI = sDepDateI;
        sDayI = dateToDay();
    }

    // method which converts particular date to DayOfWeek
    String dateToDay() {
        String[] split = sDepDateI.split("/");

        int iDayL = Integer.parseInt(split[0]);
        int iMonthL = Integer.parseInt(split[1]);
        int iYearL = Integer.parseInt(split[2]);

        LocalDate ld = LocalDate.of(iYearL, iMonthL, iDayL);
        DayOfWeek getDay = ld.getDayOfWeek();
        sDayI = getDay.toString();
        return sDayI;
    }
}
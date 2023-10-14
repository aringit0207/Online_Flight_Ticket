import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

abstract class searchFlight{

    String sFromI, sDestinationI, sDepDateI, sDayI;

    searchFlight(String sFromI, String sDestinationI, String sDepDateI) {
        this.sFromI = sFromI;
        this.sDestinationI = sDestinationI;
        this.sDepDateI = sDepDateI;
        sDayI = dateToDay();
    }

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

abstract class showFlight extends searchFlight {

    showFlight(String sFromI, String sDestinationI, String sDepDateI) {
        super(sFromI, sDestinationI, sDepDateI);
    }

    void show() {
        System.out.println("S.No.\tFlight Name\tDeparture\tArrival\t\tDuration");
        switch (sDayI) {
            case "MONDAY":
            System.out.println("1.\tAir India\t06:15\t\t12:30\t\t06:15");
            break;
            case "TUESDAY":
            System.out.println("2.\tIndigo\t\t12:30\t\t06:00\t\t05:30");
            break;
            case "WEDNESDAY":
            System.out.println("3.\tSpiceJet\t16:45\t\t23:15\t\t06:30");
            break;
            case "THURSDAY":
            System.out.println("4.\tVistara\t\t20:00\t\t3:00\t\t7:00");
            break;
            case "FRIDAY":
            System.out.println("1.\tAir India\t06:15\t\t12:30\t\t06:15");
            break;
            case "SATURDAY":
            System.out.println("2.\tIndigo\t\t12:30\t\t06:00\t\t05:30");
            break;
            case "SUNDAY":
            System.out.println("3.\tSpiceJet\t16:45\t\t23:15\t\t06:30");
            break;
            default:
            System.out.println("You can't travel !!!");
        }
    }
}

class selectFlight extends showFlight {
    int num;
    selectFlight(String sFromI, String sDestinationI, String sDepDateI) {
        super(sFromI, sDestinationI, sDepDateI);
    }

    void select() {
        switch (num) {
            case 1:
                System.out.println("1.\tAir India\t06:15\t\t12:30\t\t06:15");
                break;
            case 2:
                System.out.println("2.\tIndigo\t\t12:30\t\t06:00\t\t05:30");
                break;
            case 3:
                System.out.println("3.\tSpiceJet\t16:45\t\t23:15\t\t06:30");
                break;
            case 4:
                System.out.println("4.\tVistara\t\t20:00\t\t3:00\t\t7:00");
                break;
            case 5:
                System.out.println("1.\tAir India\t06:15\t\t12:30\t\t06:15");
                break;
            case 6:
                System.out.println("2.\tIndigo\t\t12:30\t\t06:00\t\t05:30");
                break;
            case 7:
                System.out.println("3.\tSpiceJet\t16:45\t\t23:15\t\t06:30");
                break;
            default:
                System.out.println("You can't travel !!!");
        }
    }
}

public class temp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        selectFlight sf = new selectFlight("indore", "bhopal", "05/10/2023");
        
    }
}
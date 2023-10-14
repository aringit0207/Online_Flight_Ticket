import java.time.DayOfWeek;
import java.time.LocalDate;
// import java.io.File; // For creating a file
// import java.io.FileWriter; // For writing in a file
import java.io.FileReader; // For reading in a file
import java.io.IOException; // For error handling
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

     void show(){
        try{
            char[] flight  = new char[1000];
            FileReader input = new FileReader("flightDetails.txt");
            input.read(flight);
            System.out.println(flight);
            input.close();
        }
        catch (IOException e) {
			System.out.println("File error...");
		}
    }
}

class selectFlight extends showFlight {
    int Sflight, Sclass, Spassengers;

    selectFlight(String sFromI, String sDestinationI, String sDepDateI) {
        super(sFromI, sDestinationI, sDepDateI);
    }

    void selectF(int Sflight) {
        this.Sflight = Sflight;

        System.out.println("You have selected...");
        System.out.println("Flight Name\tDeparture\tArrival\t\tDuration");
        switch (Sflight) {
            case 1:
                System.out.println("Indigo\t08:30\t\t10:30\t\t02:00");
                break;
            case 2:
                System.out.println("Indigo\t\t09:20\t\t11:35\t\t02:15");
                break;
            case 3:
                System.out.println("Air India\t16:00\t\t17:45\t\t01:45");
                break;
            case 4:
                System.out.println("Vistara\t\t17:25\t\t20:40\t\t03:15");
                break;
            case 5:
                System.out.println("SpiceJet\t21:25\t\t23:50\t\t02:25");
                break;
            case 6:
                System.out.println("Indigo\t\t21:50\t\t00:30\t\t02:40");
                break;
            case 7:
                System.out.println("Indigo\t22:00\t\t23:55\t\t01:55");
                break;
            case 8:
                System.out.println("Air India\t23:05\t\t02:40\t\t03:35");
                break;
            case 9:
            System.out.println("Vistara\t23:55\t\t02:00\t\t02:05");
            break;
            case 10:
            System.out.println("SpiceJet\t01:35\t\t03:05\t\t01:30");
                break;
            default:
                System.out.println("You can't travel !!!");
        }
    }

    void selectC(int Sclass) {
        this.Sclass = Sclass;

        switch (Sclass) {
            case 1:
                System.out.println("You have selected Economy class.");
                break;
            case 2:
                System.out.println("You have selected Business class.");
                break;
            case 3:
                System.out.println("You have selected First class.");
                break;
            default:
                System.out.println("Invalid Selection !!!");
                break;
        }
    }

    void selectP(int Spassengers) {
        this.Spassengers = Spassengers;
    }
}


public class temp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Date (dd/mm/yyyy) : ");
        String date = sc.next();

        System.out.print("From : ");
        String from = sc.next();

        System.out.print("Destination : ");
        String destination = sc.next();

        selectFlight sd = new selectFlight(from, destination, date);
        System.out.println("\n" + sd.sDayI);
        sd.show();

        System.out.print("Select your flight by entering S.No. : ");
        int Sflight = sc.nextInt();
        sd.selectF(Sflight);

        System.out.println("Economy Class : 7000 Rs.\nBusiness Class : 12000 Rs.\nFirst Class : 18000 Rs.\n");
        System.out.print("Select class by entering S.No. : ");
        int Sclass = sc.nextInt();
        sd.selectC(Sclass);

        System.out.println("Enter number of passegers : ");
        int Spassengers = sc.nextInt();
        sd.selectP(Spassengers);

    }
}
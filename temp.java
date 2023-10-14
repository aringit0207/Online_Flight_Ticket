import java.time.DayOfWeek;
import java.time.LocalDate;
import java.io.File; // For creating a file
import java.io.FileWriter; // For writing in a file
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

class showFlight extends searchFlight {

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

public class temp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter date (dd/mm/yyyy): ");
        String date = sc.next();
        showFlight sd = new showFlight("indore", "bhopal", date);
        System.out.println(sd.sDayI);
        sd.show();
    }
}
package flightBooking;
import java.io.FileReader; // For reading in a file
import java.io.IOException; // For error handling

// An abstract class "showFlight"
abstract public class showFlight extends searchFlight {

    // constructor
    showFlight(String sFromI, String sDestinationI, String sDepDateI) {
        super(sFromI, sDestinationI, sDepDateI);
    }

    // method which shows details about all the flights
    void show() {
        try {
            char[] flight = new char[1000];
            FileReader input = new FileReader("flightDetails.txt");
            input.read(flight);
            System.out.println(flight);
            input.close();
        } catch (IOException e) {
            System.out.println("File error...");
        }
    }
}
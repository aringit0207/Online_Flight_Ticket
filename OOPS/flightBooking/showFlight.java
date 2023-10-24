package flightBooking;
// import java.io.File; // For creating a file
// import java.io.FileWriter; // For writing in a file
import java.io.FileReader; // For reading in a file
import java.io.IOException; // For error handling

abstract public class showFlight extends searchFlight {

    showFlight(String sFromI, String sDestinationI, String sDepDateI) {
        super(sFromI, sDestinationI, sDepDateI);
    }

    void show() {
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
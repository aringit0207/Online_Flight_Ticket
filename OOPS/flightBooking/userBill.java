package flightBooking;

import java.io.FileReader;

// A class "userBill"
public class userBill extends userDetails {

    // constructor
    userBill(String sFromI, String sDestinationI, String sDepDateI) {
        super(sFromI, sDestinationI, sDepDateI);
    }

    // method to print bill 
    void printBill() {

        try {

            char[] userData = new char[1000];
            FileReader read = new FileReader("userDetailText.txt");
            read.read(userData);
            System.out.println("\n\n\n!!! Generating E-ticket !!!\n");
            System.out.println(userData);
            read.close();

            System.out.println("\nTravelling Date : " + sDepDateI + "\tDay : " + sDayI);
            System.out.println("From : " + sFromI + "\t\t\tDestination : " + sDestinationI);

            System.out.println("\nFlight Details :-");
            System.out.println("Name : " + flightName);
            System.out.println("Departure : " + dTime + "\tArrival : " + aTime + "\t\tDuration : " + duration);
            System.out.println("Passenger : " + Spassengers + "\t\tClass : " + Fclass + "     \tFare : "
                    + (Spassengers * fare) + " Rs.");
        }

        catch (Exception e) {
            System.out.println("File Error...");
        }
    }
}
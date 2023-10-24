package flightBooking;

import java.io.FileReader;

public class userBill extends userDetails {

    userBill(String sFromI, String sDestinationI, String sDepDateI) {
        super(sFromI, sDestinationI, sDepDateI);
    }
    
    void printBill() {
        System.out.println("\n!!! Generating E-ticket !!!\n");

        try {

            char[] userData  = new char[1000];
            FileReader read = new FileReader("userDetailtext.txt");
            read.read(userData);
            System.out.println("\n\n\n!!! Generating Bill !!!\n");
            System.out.println(userData);
            read.close();
    
            System.out.println("\nTravelling Date : " + sDepDateI + "\tDay : " + sDayI);
            System.out.println("From : " + sFromI + "\t\t\tDestination : " + sDestinationI);
    
            System.out.println("\nFlight Details :-");
            System.out.println("Name : " + flightName);
            System.out.println("Departure : " + dTime + "\tArrival : " + aTime + "\t\tDuration : " + duration);
            System.out.println("Passenger : " + Spassengers + "\t\tClass : " + Fclass + "     \tFare : " + fare);
        } 
        
        catch (Exception e) {
            System.out.println("File Error...");
        }
    }
}
package flightBooking;

// An abstract class "selectFlight"
abstract public class selectFlight extends showFlight {
    int Sflight, Sclass, Spassengers;
    String flightName, dTime, aTime, duration, Fclass;
    int fare;

    // constructor
    selectFlight(String sFromI, String sDestinationI, String sDepDateI) {
        super(sFromI, sDestinationI, sDepDateI);
    }

    // method to select flight
    void selectF(int Sflight) {
        this.Sflight = Sflight;

        System.out.println("\n" + "You have selected..." + "\n");
        System.out.println("Flight Name\tDeparture\tArrival\t\tDuration");
        switch (Sflight) {
            case 1:
                System.out.println("Indigo\t08:30\t\t10:30\t\t02:00");
                flightName = "Indigo";
                dTime = "08:30";
                aTime = "10:30";
                duration = "02:00";
                break;
            case 2:
                System.out.println("Indigo\t\t09:20\t\t11:35\t\t02:15");
                flightName = "Indigo";
                dTime = "09:20";
                aTime = "11:35";
                duration = "02:15";
                break;
            case 3:
                System.out.println("Air India\t16:00\t\t17:45\t\t01:45");
                flightName = "Indigo";
                dTime = "16:00";
                aTime = "17:45";
                duration = "01:45";
                break;
            case 4:
                System.out.println("Vistara\t\t17:25\t\t20:40\t\t03:15");
                flightName = "Vistara";
                dTime = "17:25";
                aTime = "20:40";
                duration = "03:15";
                break;
            case 5:
                System.out.println("SpiceJet\t21:25\t\t23:50\t\t02:25");
                flightName = "SpiceJet";
                dTime = "21:25";
                aTime = "23:50";
                duration = "02:25";
                break;
            case 6:
                System.out.println("Indigo\t\t21:50\t\t00:30\t\t02:40");
                flightName = "Indigo";
                dTime = "21:50";
                aTime = "00:30";
                duration = "02:40";
                break;
            case 7:
                System.out.println("Indigo\t\t22:00\t\t23:55\t\t01:55");
                flightName = "Indigo";
                dTime = "22:00";
                aTime = "23:55";
                duration = "01:55";
                break;
            case 8:
                System.out.println("Air India\t23:05\t\t02:40\t\t03:35");
                flightName = "Air India";
                dTime = "23:05";
                aTime = "02:40";
                duration = "03:35";
                break;
            case 9:
                System.out.println("Vistara\t23:55\t\t02:00\t\t02:05");
                flightName = "Vistara";
                dTime = "23:55";
                aTime = "02:00";
                duration = "02:05";
                break;
            case 10:
                System.out.println("SpiceJet\t01:35\t\t03:05\t\t01:30");
                flightName = "SpiceJet";
                dTime = "01:35";
                aTime = "03:05";
                duration = "01:30";
                break;
            default:
                System.out.println("You can't travel !!!");
        }
    }

    // method to select travelling class
    void selectC(int Sclass) {
        this.Sclass = Sclass;

        switch (Sclass) {
            case 1:
                System.out.println("You have selected Economy class.");
                Fclass = "Economy";
                fare = 7000;
                break;
            case 2:
                System.out.println("You have selected Business class.");
                Fclass = "Business";
                fare = 12000;
                break;
            case 3:
                System.out.println("You have selected First class.");
                Fclass = "First";
                fare = 18000;
                break;
            default:
                System.out.println("Invalid Selection !!!");
                break;
        }
    }

    // method to select no. of passengers
    void selectP(int Spassengers) {
        this.Spassengers = Spassengers;
    }
}
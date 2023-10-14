package OOPS.flightBooking;

abstract public class selectFlight extends showFlight {
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

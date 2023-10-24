import java.time.DayOfWeek;
import java.time.LocalDate;
import java.io.FileWriter; // For writing in a file
import java.io.FileReader; // For reading in a file
import java.io.IOException; // For error handling
import java.io.BufferedWriter; // For writing data efficiently
import java.util.Scanner;

abstract class abstractClass {
    abstract String dateToDay();
    abstract void show();
    abstract void selectF(int a);
    abstract void selectC(int b);
    abstract void selectP(int c);
    abstract void printBill();
}

abstract class searchFlight extends abstractClass{

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

abstract class selectFlight extends showFlight {
    int Sflight, Sclass, Spassengers;
    String flightName, dTime, aTime, duration, Fclass, fare;

    selectFlight(String sFromI, String sDestinationI, String sDepDateI) {
        super(sFromI, sDestinationI, sDepDateI);
    }

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
                System.out.println("Indigo\t22:00\t\t23:55\t\t01:55");
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

    void selectC(int Sclass) {
        this.Sclass = Sclass;

        switch (Sclass) {
            case 1:
                System.out.println("You have selected Economy class.");
                Fclass = "Economy";
                fare = "7000 Rs.";
                break;
            case 2:
            System.out.println("You have selected Business class.");
            Fclass = "Business";
            fare = "12000 Rs.";
            break;
            case 3:
                System.out.println("You have selected First class.");
            Fclass = "First";
            fare = "18000 Rs.";
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

abstract class userDetails extends selectFlight {
    String nameI, genderI, dobI, addressI, emailIdI, nationalityI;
    int ageI;
    long phNoI;

    userDetails(String sFromI, String sDestinationI, String sDepDateI) {
        super(sFromI, sDestinationI, sDepDateI);
    }

    void getDetails(String nameL, String genderL, String dobL, String addressL, String emailIdL, String nationalityL, int ageL, long phNoL) {
        this.nameI = nameL;
        this.genderI = genderL;
        this.dobI = dobL;
        this.addressI = addressL;
        this.emailIdI = emailIdL;
        this.nationalityI = nationalityL;
        this.ageI = ageL;
        this.phNoI = phNoL;

        try {
            FileWriter userInfo = new FileWriter("userDetailtext.txt");
            BufferedWriter userFW = new BufferedWriter(userInfo);
            
            String name = "Name :\t\t" + nameI;            
            userFW.write(name);
            userFW.newLine();

            String gender = "Gender :\t" + genderI;
            userFW.write(gender);
            userFW.newLine();
            
            String dob = "DOB :\t\t" + dobI;
            userFW.write(dob);
            userFW.newLine();
            
            String address = "Address :\t" + addressI;
            userFW.write(address);
            userFW.newLine();
            
            String emailId = "Email Id :\t" + emailIdI;
            userFW.write(emailId);
            userFW.newLine();
            
            String nationality = "Nationality :\t" + nationalityI;
            userFW.write(nationality);
            userFW.newLine();
            
            String age = "Age :\t\t" + ageI;
            userFW.write(age);
            userFW.newLine();
            
            String phNo = "Ph. No. :\t" + phNoI;
            userFW.write(phNo);

            userFW.close();
        } 
        
        catch (Exception e) {
            System.out.println("File error...");
        }
    }
}

class userBill extends userDetails {

    userBill(String sFromI, String sDestinationI, String sDepDateI) {
        super(sFromI, sDestinationI, sDepDateI);
    }
    
    void printBill() {

        try {

            char[] userData  = new char[1000];
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
            System.out.println("Passenger : " + Spassengers + "\t\tClass : " + Fclass + "     \tFare : " + fare);
        } 
        
        catch (Exception e) {
            System.out.println("File Error...");
        }
    }
}

public class temp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n\t\t\t\t\t!!!!! Welcome To Online Flight Booking !!!!!\n");

        System.out.print("Date (DD/MM/YYYY) : ");
        String date = sc.next();
        sc.nextLine();

        System.out.print("From : ");
        String from = sc.next();
        sc.nextLine();

        System.out.print("Destination : ");
        String destination = sc.next();
        sc.nextLine();

        userBill ub = new userBill(from, destination, date);
        System.out.println("\n" + "These are the flights available for " + ub.sDayI + "\n");
        ub.show();

        System.out.print("Select your flight by entering S.No. : ");
        int Sflight = sc.nextInt();
        sc.nextLine();
        ub.selectF(Sflight);

        System.out.println("\n" + "Enter your preference :-" + "\n");
        System.out.println("1. Economy Class : 7000 Rs.\n2. Business Class : 12000 Rs.\n3. First Class : 18000 Rs.\n");
        System.out.print("Select class by entering S.No. : ");
        int Sclass = sc.nextInt();
        sc.nextLine();
        ub.selectC(Sclass);

        System.out.print("\n" + "Enter number of passengers : ");
        int Spassengers = sc.nextInt();
        sc.nextLine();

        ub.selectP(Spassengers);

        System.out.println("\n" + "Do you want to book your journey ?\nYes -> Y\tNo -> N");
        System.out.print("Enter : ");
        String confirm = sc.next();
        sc.nextLine();
        String c = "N";
        
        if(confirm.equals(c)) {
            System.out.println("!!! Thank You For Choosing Us !!!\n!!! Visit Once Again !!!\n");
            System.exit(0);
        }

        else {
            System.out.println("\nPlease enter your details below :-\n");

            System.out.print("Name :- ");
            String name = sc.nextLine();

            System.out.print("Gender :- ");
            String gender = sc.nextLine();

            System.out.print("DOB (DD/MM/YYYY) :- ");
            String dob = sc.nextLine();

            System.out.print("Address :- ");
            String address = sc.nextLine();

            System.out.print("Email address :- ");
            String emailId = sc.nextLine();

            System.out.print("Nationality :- ");
            String nationality = sc.nextLine();

            System.out.print("Age :- ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Phone No. :- ");
            long phNo = sc.nextLong();
            sc.nextLine();

            ub.getDetails(name, gender, dob, address, emailId, nationality, age, phNo);

            ub.printBill();
            System.out.println("\nE-ticket will be send via Email and message.");
            System.out.println("\nThanks for giving us a chance to serve you.\n\n\t!!! Visit Once Again !!!\n");

        }

        sc.close();
    }
}
/**
 * Copyright (c) 2023 Arin Jain
 * All rights reserved.
 *
 * This program is the intellectual property of Arin Jain
 * You may not reproduce, distribute, or modify this code without written permission from the author.
 *
 * Authors:
 * - Arin Jain (arinjain1610@gmail.com)
 * - Manas Maheshwari (manasmaheshwari2004@gmail.com)
 *
 */

import java.time.DayOfWeek; // For converting date to DayOfWeek
import java.time.LocalDate; // For writing date in DD/MM/YYYY format
import java.io.FileWriter; // For writing in a file
import java.io.FileReader; // For reading in a file
import java.io.IOException; // For error handling
import java.io.BufferedWriter; // For writing data efficiently
import java.text.ParseException; // For encountering problems while parsing
import java.text.SimpleDateFormat; // For data formating and parsing
import java.util.Date; // For basic date and time operations
import java.util.Scanner; // For taking user input

// An abstract class where all the abstract methods are declared
abstract class abstractClass {
    abstract String dateToDay();
    abstract void show();
    abstract void selectF(int a);
    abstract void selectC(int b);
    abstract void selectP(int c);
    abstract void setDetails(String nameL, String genderL, String dobL, String addressL, String emailIdL, String nationalityL, int ageL, long phNoL);
    abstract void printBill();
}

// An abstract class "searchFlight"
abstract class searchFlight extends abstractClass {

    String sFromI, sDestinationI, sDepDateI, sDayI;

    // constructor 
    searchFlight(String sFromI, String sDestinationI, String sDepDateI) {
        this.sFromI = sFromI;
        this.sDestinationI = sDestinationI;
        this.sDepDateI = sDepDateI;
        sDayI = dateToDay();
    }

    // method which converts particular date to DayOfWeek
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

// An abstract class "showFlight"
abstract class showFlight extends searchFlight {

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

// An abstract class "selectFlight"
abstract class selectFlight extends showFlight {
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

// An abstract class "userDetails"
abstract class userDetails extends selectFlight {
    String nameI, genderI, dobI, addressI, emailIdI, nationalityI;
    int ageI;
    long phNoI;

    // constructor
    userDetails(String sFromI, String sDestinationI, String sDepDateI) {
        super(sFromI, sDestinationI, sDepDateI);
    }

    // method to intialize user's personal info and write them to a text file
    void setDetails(String nameL, String genderL, String dobL, String addressL, String emailIdL, String nationalityL, int ageL, long phNoL) {
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

// A class "userBill"
class userBill extends userDetails {

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

public class temp {

    // public static int checkInputPhone(String str) {
    // int flag = 1;
    // String check = "^[a-zA-Z!@#$%^&*()_+=\\-\\[\\]{};':\",./<>?]*$";
    // if(str.matches(check)) {
    // flag = 0;
    // }
    // return flag;
    // }

    // static method to check validity of date(DD/MM/YYYY)
    public static boolean checkDate(String dateCheck) {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); // Set lenient to false to enforce strict date format checking.
        try {
            Date parsedDate = sdf.parse(dateCheck);
            return dateCheck.equals(sdf.format(parsedDate)); // Check if the input matches the parsed date string exactly.
        } 
        catch (ParseException e) {
            System.out.println("wrong");
            return false;
        }
    }

    // static method to check validity of string
    public static int checkInput(String str) {
        int flag = 1;
        String check = "^[a-zA-Z ]+$";
        if (str.matches(check)) {
            flag = 0;
        }
        return flag;
    }

    // static method to check validity of email ID
    public static int checkInputEmail(String str) {
        int flag = 1;
        String check = "^[a-zA-Z!@_+\\-\\.1234567890]*$";
        if (str.matches(check)) {
            flag = 0;
        }
        return flag;
    }

    // static method to check validity of integer
    public static int checkInput(int num, int start, int end) {
        int flag = 1;
        if (num >= start && num <= end) {
            flag = 0;
        }
        return flag;
    }

    // static method to check validity of confirmation
    public static int confirmation(String confirm) {
        int flag = 1;
        String yes = "Y", no = "N";
        if (confirm.equals(yes) || confirm.equals(no)) {
            flag = 0;
        }
        return flag;
    }

    // main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n\t\t\t\t\t!!!!! Welcome To Online Flight Booking !!!!!\n");

        // enter date
        System.out.print("Date (DD/MM/YYYY) : ");
        String date = sc.next();
        sc.nextLine();

        // checking the validity of string(date)
        while(!checkDate(date)) {
            System.out.print("\nKindly enter a valid date : ");
            date = sc.next();
            sc.nextLine();
        }

        // enter from
        System.out.print("\nFrom : ");
        String from = sc.next();
        sc.nextLine();

        // checking the validity of string(from)
        while (checkInput(from) == 1) {
            System.out.println("\nKindly Re-enter -");
            System.out.print("From : ");
            from = sc.next();
            sc.nextLine();
        }

        // enter destination
        System.out.print("\nDestination : ");
        String destination = sc.next();
        sc.nextLine();

        // checking the validity of string(destination)
        while (checkInput(destination) == 1) {
            System.out.println("\nKindly Re-enter -");
            System.out.print("Destination : ");
            destination = sc.next();
            sc.nextLine();
        }

        // making object of userBill
        userBill ub = new userBill(from, destination, date);
        System.out.println("\n" + "These are the flights available for " + ub.sDayI + "\n");

        // showing the list of all the available flights
        ub.show(); 

        // input for select flight
        System.out.print("Select your flight by entering S.No. : ");
        int Sflight = sc.nextInt();
        sc.nextLine();

        // checking the validity of integer(select flight)
        while (checkInput(Sflight, 1, 10) == 1) {
            System.out.print("\nKindly Re-enter Flight S.No. : ");
            Sflight = sc.nextInt();
            sc.nextLine();
        }

        // selecting the flight
        ub.selectF(Sflight);

        System.out.println("\n" + "Enter your preference :-" + "\n");
        System.out.println("1. Economy Class : 7000 Rs.\n2. Business Class : 12000 Rs.\n3. First Class : 18000 Rs.\n");

        // input for travelling class
        System.out.print("Select class by entering S.No. : ");
        int Sclass = sc.nextInt();
        sc.nextLine();

        // checking the validity of integer(class)
        while (checkInput(Sclass, 1, 3) == 1) {
            System.out.print("\nKindly Re-enter Class S.No. : ");
            Sclass = sc.nextInt();
            sc.nextLine();
        }

        // selecting the travelling class
        ub.selectC(Sclass);

        // enter no. of passengers
        System.out.print("\n" + "Enter number of passengers (Max 10) : ");
        int Spassengers = sc.nextInt();
        sc.nextLine();

        // checking the validity of integer(passengers)
        while (checkInput(Spassengers, 1, 10) == 1) {
            System.out.print("\nMax limit (10), Kindly Re-enter : ");
            Spassengers = sc.nextInt();
            sc.nextLine();
        }

        // selecting the no. of passengers
        ub.selectP(Spassengers);

        // user confirmation
        System.out.println("\n" + "Do you want to book your journey ?\nYes -> Y\tNo -> N");
        System.out.print("Enter : ");
        String confirm = sc.next();
        sc.nextLine();

        // checking the validity of string(confirmation)
        while (confirmation(confirm) == 1) {
            System.out.print("\nKindly Re-enter your confirmation (Y/N): ");
            confirm = sc.next();
            sc.nextLine();
        }

        // return if user want to exit
        String no = "N";
        if (confirm.equals(no)) {
            System.out.println("\n!!! Thank You For Choosing Us !!!\n!!! Visit Once Again !!!\n");
            sc.close();
            return;
        }

        // else ticket booking
        else {
            System.out.println("\nPlease enter your details below :-");

            // enter name
            System.out.print("\nName :- ");
            String name = sc.nextLine();

            // checking the validity of string(name)
            while (checkInput(name) == 1) {
                System.out.println("\nKindly Re-enter -");
                System.out.print("Name : ");
                name = sc.nextLine();
            }

            // enter gender
            System.out.print("\nGender :- ");
            String gender = sc.nextLine();

            // checking the validity of string(gender)
            while (checkInput(gender) == 1) {
                System.out.println("\nKindly Re-enter -");
                System.out.print("Gender : ");
                gender = sc.nextLine();
            }

            // enter dob
            System.out.print("\nDOB (DD/MM/YYYY) :- ");
            String dob = sc.nextLine();

            // checking the validity of string(date)
        while(!checkDate(dob)) {
            System.out.print("\nKindly enter a valid date : ");
            dob = sc.next();
            sc.nextLine();
        }

            // enter address
            System.out.print("\nAddress :- ");
            String address = sc.nextLine();

            // enter emailId
            System.out.print("\nEmail address :- ");
            String emailId = sc.nextLine();

            // checking the validity of string(emailId)
            while (checkInputEmail(emailId) == 1) {
                System.out.println("\nKindly Re-enter -");
                System.out.print("Email address : ");
                emailId = sc.nextLine();
            }

            // enter nationality
            System.out.print("\nNationality :- ");
            String nationality = sc.nextLine();

            // checking the validity of string(nationality)
            while (checkInput(nationality) == 1) {
                System.out.println("\nKindly Re-enter -");
                System.out.print("Nationality : ");
                nationality = sc.nextLine();
            }

            // enter age
            System.out.print("\nAge :- ");
            int age = sc.nextInt();
            sc.nextLine();

            // checking the validity of string(age)
            while (checkInput(age, 1, 120) == 1) {
                System.out.print("\nKindly enter a valid age : ");
                age = sc.nextInt();
                sc.nextLine();
            }

            // enter SphNo
            System.out.print("\nPhone No. :- ");
            String SphNo = sc.nextLine();

            // checking the validity of string(SphNo)
            // while(checkInputPhone(SphNo) == 0 && SphNo.length() != 10) {
            while (SphNo.length() != 10) {
                System.out.print("\nKindly enter a valid Phone No. : ");
                SphNo = sc.nextLine();
            }
            long phNo = Long.parseLong(SphNo);

            // set details of user
            ub.setDetails(name, gender, dob, address, emailId, nationality, age, phNo);

            // printing the bill
            ub.printBill();
            System.out.println("\nE-ticket will be send via Email and message.");
            System.out.println("\nThanks for giving us a chance to serve you.\n\n\t!!! Visit Once Again !!!\n");

        }
        // closing the scanner
        sc.close();
    }
}
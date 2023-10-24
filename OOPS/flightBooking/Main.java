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


package flightBooking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
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
package flightBooking;

import java.util.Scanner;

public class Main {
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
package flightBooking;

import java.io.FileWriter; // For writing in a file
import java.io.BufferedWriter; // For writing data efficiently

// An abstract class "userDetails"
abstract public class userDetails extends selectFlight {
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
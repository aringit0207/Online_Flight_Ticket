package flightBooking;

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

public class SavingsAccount {
    private String customerName;
    private int depositAmount;   // I added this for the whole number entered by customer
    private double balance;      // I added this to show the widened to double for decimal calculations

    // I added this block of constructor that does automatic widening conversion from int depositAmount to double balance
    public SavingsAccount(String customerName, int depositAmount) {
        this.customerName = customerName;
        this.depositAmount = depositAmount;
        this.balance = depositAmount; // I added this line of code to show automatic widening of int -> double
}
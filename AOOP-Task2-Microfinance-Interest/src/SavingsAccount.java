public class SavingsAccount {
    private String customerName;
    private int depositAmount;   // This is the whole number entered by customer
    private double balance;      // Widened to double for decimal calculations
    private double interestEarned; // This is the exact decimal interest calculated

    // I added this constructor that automatic widening conversion from int depositAmount to double balance
    public SavingsAccount(String customerName, int depositAmount) {
        this.customerName = customerName;
        this.depositAmount = depositAmount;
        this.balance = depositAmount; // This is automatic widening: int -> double
        this.interestEarned = 0.0;
    }

    // I added this block of code that calculates exact decimal interest using double arithmetic
    public double calculateInterest(double annualRatePercent) {
        double rateDecimal = annualRatePercent / 100.0;
        this.interestEarned = this.balance * rateDecimal;
        return this.interestEarned;
    }
}
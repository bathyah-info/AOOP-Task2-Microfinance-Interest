/**
 * I made this so that it models a customer savings account for a microfinance bank.
 * Accepts whole-number deposits, widens safely to {@code double}
 * for decimal interest calculations, and provides manual narrowing/rounding
 * methods that produce whole figures for accounting reports while illustrating
 * fractional precision trade-offs.
 */

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

    // I added this manual narrowing cast (from double -> long): truncates decimals completely (can lose fractional accuracy)
    public long getTruncatedInterestWhole() {
        return (long) this.interestEarned;
    }

    // I rounded whole figure for management accounting using Math.round + manual cast to long
    public long getRoundedInterestWhole() {
        return (long) Math.round(this.interestEarned);
    }

    // This is the total balance including exact interest, then rounded for accounting display
    public long getRoundedTotalBalance() {
        return (long) Math.round(this.balance + this.interestEarned);
    }
//Returns the customer's name.
    public String getCustomerName() {
        return customerName;
    }
//Returns the original whole-number deposit amount
    public int getDepositAmount() {
        return depositAmount;
    }
//Returns the current balance widened to {@code double}.
    public double getBalance() {
        return balance;
    }
//Returns the exact decimal interest calculated for this account.
    public double getInterestEarned() {
        return interestEarned;
    }
}
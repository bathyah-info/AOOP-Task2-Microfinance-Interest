public class Main {
    public static void main(String[] args) {
        double annualInterestRate = 7.5; // 7.5% annual savings rate

        // I added this to accept customer deposit information (whole numbers widened safely to double in SavingsAccount)
        SavingsAccount acc1 = new SavingsAccount("Amina Nakato", 150000);
        SavingsAccount acc2 = new SavingsAccount("Samuel Mukasa", 245750);
        SavingsAccount acc3 = new SavingsAccount("Grace Nabirye", 89400);

        // This block of code exists to calculate exact decimal interest for each account
        acc1.calculateInterest(annualInterestRate);
        acc2.calculateInterest(annualInterestRate);
        acc3.calculateInterest(annualInterestRate);

        // I added this to display per-customer breakdown comparing exact, truncated, and rounded values
        printAccountDetails(acc1, annualInterestRate);
        printAccountDetails(acc2, annualInterestRate);
        printAccountDetails(acc3, annualInterestRate);
    }

    private static void printAccountDetails(SavingsAccount account, double rate) {
        System.out.println("Customer: " + account.getCustomerName());
        System.out.println("  Initial Deposit (int -> double): " + account.getDepositAmount());
        System.out.printf("  Exact Interest @ %.1f%% (double): %.4f%n", rate, account.getInterestEarned());
        System.out.println("  Truncated Interest Cast ((long)): " + account.getTruncatedInterestWhole());
        System.out.println("  Rounded Interest for Accounting: " + account.getRoundedInterestWhole());
        System.out.println();
    }
}
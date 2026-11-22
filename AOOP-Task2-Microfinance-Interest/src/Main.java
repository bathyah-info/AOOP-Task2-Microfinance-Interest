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

        // I added this to generate summary report for management
        SavingsAccount[] accounts = {acc1, acc2, acc3};
        printManagementSummary(accounts);
    }

    private static void printAccountDetails(SavingsAccount account, double rate) {
        System.out.println("Customer: " + account.getCustomerName());
        System.out.println("  Initial Deposit (int -> double): " + account.getDepositAmount());
        System.out.printf("  Exact Interest @ %.1f%% (double): %.4f%n", rate, account.getInterestEarned());
        System.out.println("  Truncated Interest Cast ((long)): " + account.getTruncatedInterestWhole());
        System.out.println("  Rounded Interest for Accounting: " + account.getRoundedInterestWhole());
        System.out.println();
    }

    private static void printManagementSummary(SavingsAccount[] accounts) {
        long totalDeposits = 0;
        double totalExactInterest = 0.0;
        long totalRoundedInterest = 0;

        for (SavingsAccount account : accounts) {
            totalDeposits += account.getDepositAmount();
            totalExactInterest += account.getInterestEarned();
            totalRoundedInterest += account.getRoundedInterestWhole();
        }

        double roundingDifference = totalRoundedInterest - totalExactInterest;

        System.out.println("MANAGEMENT SUMMARY REPORT (ROUNDED ACCOUNTING FIGURES):");
        System.out.println("Total Customer Deposits: " + totalDeposits);
        System.out.printf("Total Exact Interest (double): %.4f%n", totalExactInterest);
        System.out.println("Total Rounded Interest for Management: " + totalRoundedInterest);
        System.out.printf("Net Rounding Variance (Rounded - Exact): %+.4f%n", roundingDifference);
        System.out.println("Accuracy Note: Automatic widening (int -> double) preserves value safely, "
                + "while manual narrowing/rounding to whole numbers trades fractional precision for reporting clarity.");
    }
}
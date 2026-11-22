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
    }
}
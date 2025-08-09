package app;

public class Main {
    public static void main(String[] args) {
        BankBranch branch = new BankBranch("B001", "Main Branch");

        Customer c1 = new Customer("C001", "Alice");
        branch.addCustomer(c1);

        SavingsAccount sa = new SavingsAccount("S001", 5000.0);
        CurrentAccount ca = new CurrentAccount("C001", 2000.0);

        c1.addAccount(sa);
        c1.addAccount(ca);

        System.out.println("Savings Account [S001] opened with initial balance: ₹5000.0");
        System.out.println("Current Account [C001] opened with initial balance: ₹2000.0 and overdraft limit ₹1000.0");

        sa.deposit(2000);
        System.out.println("Current Balance: ₹" + sa.checkBalance());

        ca.withdraw(2500);
        System.out.println("Current Balance: ₹" + ca.checkBalance());

        sa.transfer(ca, 1000);
        System.out.println("Savings Balance: ₹" + sa.checkBalance());
        System.out.println("Current Balance: ₹" + ca.checkBalance());

        System.out.println("\nTransaction History:");
        sa.showTransactionHistory();
        ca.showTransactionHistory();
    }
}

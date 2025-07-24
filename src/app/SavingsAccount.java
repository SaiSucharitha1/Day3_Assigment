package app;
public class SavingsAccount extends Account implements BankOperations {
    private final double MIN_BALANCE = 1000.0;

    public SavingsAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        addTransaction("Deposited: ₹" + amount);
    }

    @Override
    public void withdraw(double amount) {
        if ((balance - amount) >= MIN_BALANCE) {
            balance -= amount;
            addTransaction("Withdrawn: ₹" + amount);
        } else {
            System.out.println("Withdrawal denied. Minimum balance ₹" + MIN_BALANCE + " required.");
        }
    }
}



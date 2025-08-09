package app;

public class CurrentAccount extends Account implements BankOperations {
    private final double OVERDRAFT_LIMIT = 2000.0;

    public CurrentAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        addTransaction("Deposited: ₹" + amount);
    }

    @Override
    public void withdraw(double amount) {
        if ((balance - amount) >= -OVERDRAFT_LIMIT) {
            balance -= amount;
            addTransaction("Withdrawn: ₹" + amount);
        } else {
            System.out.println("Overdraft limit ₹" + OVERDRAFT_LIMIT + " exceeded.");
        }
    }
}


package samplearrays;

public class BankAccount {

    String name;
    double currentBalance;
    //TO-DO: Initialize an Array with 1000 in size that stores Double called 'transactions' to keep track of the user's transactions
    private Double[] transactions;
    private int transactionIndex;

    public BankAccount(String name, int startingBalance){
        this.name = name;
        this.currentBalance = startingBalance;

        transactions = new Double[1000];
        transactionIndex = 0;
    }

    public void deposit(double amount){
        if(amount < 0) {
            System.out.println("The deposit was unsuccesful due to invalid amount");
        }

        System.out.println("Mr/Mrs. " + name + " has deposited an amount of " + amount);
        System.out.println("Old balance is: " + currentBalance);

        // record the transaction 
        transactions[transactionIndex] = amount;
        transactionIndex++;
        // update balance
        currentBalance += amount;

        System.out.println("New balance is : " + currentBalance );
        return;
    }

    public void withdraw(double amount){
        if(amount < 0 ) {
            System.out.println("The withdraw was unsuccesful because of invalid amount");
            return;
        }
        else if(amount > currentBalance) {
            System.out.println("The withdraw was unsuccesful because the amount requested exceeds the balance");
            return;
        }

        System.out.println("Mr/Mrs. " + name + " has withdrawn an amount of " + amount);
        System.out.println("Old balance is: " + currentBalance);

        // record the transaction 
        transactions[transactionIndex] = -amount;
        transactionIndex++;
        // update balance
        currentBalance -= amount;

        System.out.println("New balance is : " + currentBalance );
        return;
    }

    public void displayTransactions(){
        System.out.println("Historic of transactions: ");
        for(int i = 0; i < transactionIndex; i++) {
            System.out.println("Transaction " + i + ": " + transactions[i]);
        }
        return;
    }

    public void displayBalance(){
        System.out.println("CurrentBalance : " + currentBalance);
    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}

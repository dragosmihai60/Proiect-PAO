package Pachet;

public class SavingsAccount extends Account{
    private double interestRate;

    public SavingsAccount(){
        super();
    }
    public SavingsAccount(int accountNumber, double interestRate){
        super(accountNumber);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return this.interestRate;
    }
    public void setInterestRate(double interestRate){
        this.interestRate= interestRate;
    }

    public double calcInterest(){
        return balance * interestRate;
    }
    public void applyInterest(){
        double interest = calcInterest();
        System.out.printf("Dobanda %.2f adaugata la sold%n", interest);
        deposit(interest);
    }

    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.printf("Valoare %.2f depozitata%n", amount);

            System.out.printf("Sold curent: %.2f%n", balance);
        }
        else {
            System.out.println("Nu poate fi depozitata o suma negativa");
        }
    }
    public void withdraw(double amount){
        if(amount > 0) {
            if((amount) <= balance){
                System.out.printf("Valoare %.2f retrasa%n", amount);
                balance -= amount;
                System.out.printf("Sold curent: %.2f%n", balance);
            }
        }
        else{
            System.out.println("Nu poate fi retrasa o suma negativa");
        }
    }
}

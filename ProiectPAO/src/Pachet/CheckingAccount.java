package Pachet;
import Pachet.Account;
public class CheckingAccount extends Account {

    private static double FEE = 2.5;

    public CheckingAccount(){
        super();
    }
    public CheckingAccount(int accountNumber, double fee){
        super(accountNumber);
        FEE = fee;
    }
    public void deposit(double amount){
        if(amount > 0){
          balance += amount;
          System.out.printf("Valoare %.2f depozitata%n", amount);
          balance -= FEE;
          System.out.printf("Comision %.2f aplicat%n", FEE);
          System.out.printf("Sold curent: %.2f%n", balance);
        }
        else {
            System.out.println("Nu poate fi depozitata o suma negativa");
        }
    }
    public void withdraw(double amount){
        if(amount > 0) {
          if((amount+FEE) <= balance){
              System.out.printf("Valoare %.2f retrasa%n", amount);
              balance -= amount;
              balance -= FEE;
              System.out.printf("Comision %.2f aplicat%n", FEE);
              System.out.printf("Sold curent: %.2f%n", balance);
          }
        }
        else{
            System.out.println("Nu poate fi retrasa o suma negativa");
        }
    }
}

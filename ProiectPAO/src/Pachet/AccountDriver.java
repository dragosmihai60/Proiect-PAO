package Pachet;
import java.awt.*;
import java.util.Scanner;
public class AccountDriver {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);

        //Cream un vector de conturi
        Account accounts [] = new Account[10];
        int numAccounts = 0;

        int choice;
        do{
            choice = menu(keyboard);
            System.out.println();

            if(choice == 1){
                accounts[numAccounts++]=createAccount(keyboard);
            }
            else if (choice == 2){
                doDeposit(accounts, numAccounts, keyboard);
            }
            else if (choice == 3){
                doWithdraw(accounts, numAccounts, keyboard);
            }
            else if (choice == 4){
                applyInterest(accounts, numAccounts, keyboard);
            }
            else {
                System.out.println("O zi buna!");
            }
            System.out.println();
        }while(choice !=5);

    }

    public static int accountMenu(Scanner keyboard){
        System.out.println("Selecteaza tipul contului: ");
        System.out.println("1. Cont curent");
        System.out.println("2. Cont de economii");

        int choice = 0;
        do{
            System.out.print("Introduce optiunea: ");
            choice = keyboard.nextInt();

        }while(choice < 1 || choice > 2);

        return choice;
    }
    public static int searchAccount(Account accounts[], int count, int accountNumber){
        for(int i=0; i<count; i++){
            if(accounts[i].getAccountNumber() == accountNumber) {
                return i;
            }
        }
        return -1;
    }

    public static void doDeposit(Account accounts [], int count, Scanner keyboard) {

        System.out.print("\nIntroduce numarul contului: ");
        int accountNumber = keyboard.nextInt();

        // cautare cont
        int index = searchAccount(accounts, count, accountNumber);

        // suma
        if(index>=0) {
            System.out.print("Introduce suma depozitata: ");
            double amount = keyboard.nextDouble();
            accounts[index].deposit(amount);
        }
        else {
            System.out.print("Nu exista acest cont: " + accountNumber);
        }
    }

    public static void doWithdraw(Account accounts [], int count, Scanner keyboard){
        System.out.print("\nIntroduce numarul contului: ");
        int accountNumber = keyboard.nextInt();

        // cautare cont
        int index = searchAccount(accounts, count, accountNumber);

        // suma
        if(index>0) {
            System.out.print("Introduce suma pe care doriti sa o retrageti: ");
            double amount = keyboard.nextDouble();
            accounts[index].withdraw(amount);
        }
        else {
            System.out.print("Nu exista acest cont: " + accountNumber);
        }
    }

    public static void applyInterest(Account accounts [], int count, Scanner keyboard){
        System.out.print("\nIntroduce numarul contului: ");
        int accountNumber = keyboard.nextInt();

        // cautare cont
        int index = searchAccount(accounts, count, accountNumber);

        // suma
        if(index>0) {
            if(accounts[index] instanceof SavingsAccount) {
                ((SavingsAccount) accounts[index]).applyInterest();
            }
        }
        else {
            System.out.print("Nu exista acest cont: " + accountNumber);
        }
    }

        public static Account createAccount(Scanner keyboard){
        Account account = null;
        int choice = accountMenu(keyboard);

        int accountNumber;
        System.out.print("Introducere numar cont: ");
        accountNumber = keyboard.nextInt();

        if(choice == 1){
            //cont curent
            System.out.print("introducere comisionul tranzactiei: ");
            double fee = keyboard.nextDouble();
            account = new CheckingAccount(accountNumber, fee);


        }
        else{
            //Cont de economii
            System.out.print("introducere dobanda depozit: ");
            double ir = keyboard.nextDouble();
            account = new SavingsAccount(accountNumber, ir);

        }
        return account;
    }

    public static int menu(Scanner keyboard){
        System.out.println("Meniu Cont Bancar");
        System.out.println("1. Creeaza un cont nou");
        System.out.println("2. Depoziteaza fonduri");
        System.out.println("3. Retragere fonduri");
        System.out.println("4. Aplica dobanda");
        System.out.println("5. Exit");

        int choice = 0;

        do{
            System.out.print("Introduce optiunea: ");
            choice = keyboard.nextInt();

        }while(choice < 1 || choice > 5);
        return choice;
    }
}

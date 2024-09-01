import java.util.*;

//abstract class account
abstract class Account{
String Name, Acc_No;
int Balance;
abstract void Deposit();
abstract void Withdraw();
abstract void Display();
}

//exception class for negative amount in account
class NegativeAmountException extends Exception{
    NegativeAmountException(String message){
    super(message);
    }
}

//exception class for insufficient amount in account
class InsufficientAmountException extends Exception{
    InsufficientAmountException(String message){
    super(message);
    }
}

//exception class for amount in account being below than min limit
class AmountBelowMinException extends Exception{
    AmountBelowMinException(String message){
        super(message);
    }
}

//child class
class SavingsAccount extends Account{
int minBalance,interestRate;
Scanner scan = new Scanner(System.in);
//child class constructor
SavingsAccount(String Name, String Acc_No, int Balance,int minBalance, int interestRate){
    this.Name = Name;
    this.Acc_No = Acc_No;
    this.Balance = Balance;  
    this.minBalance = minBalance;
    this.interestRate = interestRate;
}

//method to throw negative amount exception
public void NegativeAmount(){
    try {
        throw new NegativeAmountException("Negative Amount detected");
    } catch (NegativeAmountException e) {
        System.out.println("Exception detected:> "+ e);
    } 
}

//method to throw amount below min exception
public void AmountBelowMin(){
    try {
        throw new AmountBelowMinException("Amount in your account is/will be below the minimum limit");
    } catch (AmountBelowMinException e) {
        System.out.println("Exception detected:> "+ e);
    }
}

//method to throw insufficient amount excetion
public void InsufficientAmount(){
    try {
        throw new InsufficientAmountException("You can not withdraw more Amount than your Balance");
    } catch (InsufficientAmountException e) {
        System.out.println("Exception detected:> "+ e);
    }
}

//public to add interest to balance in the account
public void addInterest(){
    System.out.println("Interest of "+interestRate+"% added to your balance." );
    Balance += Balance*interestRate/100;
    System.out.println("Now your account has balance of Rs."+Balance);
}

//method to put a deposit 
public void Deposit(){
    System.out.print("Enter amount to be Deposited: ");
    int deposit = scan.nextInt();
    scan.nextLine();
//condition to throw negative amount if detected
    if(Balance < 0){
        System.out.print("Transaction failed. ");
        NegativeAmount();
    }
    else if(Balance<minBalance){
        System.out.print("Transaction failed. ");
        AmountBelowMin();
    }
    else{
        Balance = Balance + deposit;
        System.out.println("Transaction Successful. Rs."+deposit+" has been deposited in your account");
    }
}
public void Withdraw(){
    System.out.print("Enter ammount to be Withdrawn: ");
    int withdraw = scan.nextInt();
    scan.nextLine();
    if(Balance < 0 || Balance - withdraw < 0){
        System.out.print("Transaction failed. ");
        NegativeAmount();
    }
    if(Balance < minBalance || Balance - withdraw < minBalance){
        System.out.print("Transaction failed. ");
        AmountBelowMin();
    }
    if(Balance< withdraw){
        System.out.print("Transaction failed. ");
        InsufficientAmount();
    }
    else{
        Balance = Balance - withdraw;
        System.out.println("Transaction Successful. Rs."+withdraw+" has been withdrawn from your account");
    }
}
public void Display(){
    boolean loop = true;
    while(loop){
    System.out.println("Choose Action(Enter sr number): ");
	System.out.println("1.]Check Balance");
    System.out.println("2.]Deposit");
    System.out.println("3.]Withdraw");
    System.out.println("4.]Exit");
    int choice = scan.nextInt();
    scan.nextLine();
    switch(choice){
    case 1:System.out.println("Balance in your Account is: Rs."+Balance);
    System.out.println();
    break;
    case 2:Deposit();
    System.out.println();
    break;
    case 3: Withdraw();
    System.out.println();
    break;
    case 4: System.out.println("Thank you for reaching our services.Exited Menu");
    loop = false;
    break;
    default: System.out.println("Invalid input");
    System.out.println();
    break;
    }
    }
}
}

class testBank{
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter bank details:");
    System.out.print("Interest Rate of bank: ");
    int rate = sc.nextInt();
    System.out.print("Minimum balance limit(Enter 0 if there is no minimum): ");
    int min = sc.nextInt();
    sc.nextLine();
    System.out.println("Please Enter your Details: ");
    System.out.print("Name: ");
    String name = sc.nextLine();
    System.out.print("Account number: ");
    String accountnum = sc.nextLine();
    System.out.print("Enter Balance to put in your account: ");
    int bal = sc.nextInt();
    SavingsAccount s1 = new SavingsAccount(name, accountnum, bal, min, rate);
    s1.addInterest();
    s1.Display();
}
}

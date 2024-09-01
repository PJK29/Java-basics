import java.util.Scanner;
class Recruitment{
double Result,Total;
public Recruitment(){
    Result= 0;
    Total= 40;
}
public void getResult(){
    if(Result >= (0.6*Total)){
        System.out.println("Congratulations You have passed the recruitment tests by securing:"+Result+" Marks out of "+Total);
    }
    else{
        System.out.println("We are sorry to inform you have failed the tests with score: "+ Result);
    }
}
}
class Testing extends Recruitment{
String Name,choice;

int option,correct = 5,incorrect = 0,compromising = 2;
Scanner scan = new Scanner(System.in);
public Testing(String Name){
    super();
    this.Name=Name;
}
public void TakeTest(){
    System.out.println("*********************************************************************************************************************");
    System.out.println("Weclome "+Name+".You will be required to give 4 Objective tests :");
    System.out.println("1.]Vision Test    2.]Specialization Test   3.]Learning Aptitude Test    4.]Cooperation Test");
    System.out.println("You can only access the tests chronologically.You are allowed to attempt the test only once.");
    System.out.println("Note:You are only give one chance to choose your option.");
    System.out.println("Let's Start the rounds.");
    System.out.println("*********************************************************************************************************************");
    System.out.println();
    System.out.println("Starting with 1st test: ");
        System.out.println("1.1]What is the vision of the company (choose option number) ?");
        System.out.println("1.]Being A tech giant    2.]Providing reliable Service   3.]get moneey!");
        option = scan.nextInt();
        switch(option){
        case 1: Result += compromising;
        break;
        case 2: Result += correct;
        break;
        case 3: Result += incorrect;
        break;
        }
        System.out.println("1.2]How long will you stay in this role (choose option number) ?");
        System.out.println("1.]Till the company needs me    2.]As long as i wish   3.]As long as i am able to");
        option = scan.nextInt();
        scan.nextLine();
        switch(option){
        case 1: Result += compromising;
        break;
        case 2: Result += incorrect;
        break;
        case 3: Result += correct;
        break;
        }
    System.out.println();
    System.out.println("Start with 2nd test(yes/no): ");
        System.out.println("2.1]What is final method in Java (choose option number) ?");
        System.out.println("1.]method cannot be overridden by subclasses   2.]the last method  3.]method that is part of a class ");
        option = scan.nextInt();
        switch(option){
        case 1: Result += correct;
        break;
        case 2: Result += incorrect;
        break;
        case 3: Result += incorrect;
        break;
        }
        System.out.println("2.2]What is the latest version of Java (choose option number) ?");
        System.out.println("1.]JDK17   2.]JDK22   3.]JDK21");
        option = scan.nextInt();
        scan.nextLine();
        switch(option){
        case 1: Result += incorrect;
        break;
        case 2: Result += incorrect;
        break;
        case 3: Result += correct;
        break;
        }
    System.out.println();
    System.out.println("Starting  with 3rd test: ");
        System.out.println("3.1]What did you learn about Java in last job (choose option number) ?");
        System.out.println("1.]inheritance   2.]Frameworks  3.]Memory management 4.]I already know everything bro");
        option = scan.nextInt();
        switch(option){
        case 1: Result += incorrect;
        break;
        case 2: Result += correct;
        break;
        case 3: Result += correct;
        break;
        case 4: Result = Result - 1.5 ;
        break;
        }
        System.out.println("3.2]What do you wish to learn (choose option number) ?");
        System.out.println("1.]Work Attitude   2.]New Skills   3.]nothing   4.]Willing to learn anything");
        option = scan.nextInt();
        scan.nextLine();
        switch(option){
        case 1: Result += compromising;
        break;
        case 2: Result += compromising;
        break;
        case 3: Result += incorrect;
        break;
        case 4: Result += correct;
        break;
        }
    System.out.println();
    System.out.println("Starting  with 4th test: ");
        System.out.println("4.1]What makes a team successful (choose option number) ?");
        System.out.println("1.]Me ofcourse   2.]Teamwork  3.]Working hard in their own work");
        option = scan.nextInt();
        switch(option){
        case 1: Result += incorrect;
        break;
        case 2: Result += correct;
        break;
        case 3: Result += incorrect;
        break;
        }
        System.out.println("4.2Do you work faster in team or as individual (choose option number) ?");
        System.out.println("1.]Differs conditionally   2.]individual  3.]team ");
        option = scan.nextInt();
        scan.nextLine();
        switch(option){
        case 1: Result += correct;
        break;
        case 2: Result += compromising;
        break;
        case 3: Result += compromising;
        break;
        }
        System.out.println(Result);
    }
public void getResult(){
    System.out.println(Name+"'s Result:");
    super.getResult();
}
}
class Tester_Recruitment{
public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Welcome to ABCL Technologies Recruitment Rounds.");
    System.out.print("Please enter your name: ");
    String name = sc.nextLine();
    Testing t1 = new Testing(name);
    System.out.println("Thank you. Please enter the testing room.");
    t1.TakeTest();
    System.out.println("Your results are ready");
    t1.getResult();
    sc.close();
}
}
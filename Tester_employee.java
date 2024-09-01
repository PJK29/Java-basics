import java.util.Scanner;
class Employee{
String Name,ID,Age;
Scanner scan = new Scanner(System.in);
public Employee(String Name, String ID, String Age){
    setName();
    setID();
    setAge();
}
public void setName(){
    System.out.print("Enter Name of Employee: ");
    Name = scan.nextLine();
}
public void setID(){
    System.out.print("Enter ID of Employee: ");
    ID = scan.nextLine();
}
public void setAge(){
    System.out.print("Enter Age of Employee: ");
    Age = scan.nextLine();
}
public void getinfo(){
    System.out.println("Employee details: ");
    System.out.println("Name: "+Name);
    System.out.println("ID: "+ID);
    System.out.println("Age: "+Age);
}
}

class SalariedEmployee extends Employee{
double empSalary;
boolean status;
Scanner scan2 = new Scanner(System.in);
public SalariedEmployee(String Name, String ID, String Age,double empSalary){
    super(Name,ID,Age);
    setEmpSalary();
    setStatus();
}
public void setStatus(){
    System.out.println("Enter Employment Status(Enter sr number): ");
    System.out.println("1.]Permanent");
    System.out.println("2.]On Contract");
    int st = scan2.nextInt();
    switch(st){
        case 1:status = true;
        break;
        case 2: status = false;
        break;
        default: System.out.println("Invalid input");
        break;
    }
    scan2.nextLine();
}
public void setEmpSalary(){
    System.out.print("Enter Salary of Employee: ");
    empSalary = scan2.nextDouble();
}
public void displaySalary(){
    if(status){
        System.out.println("Salary of Employee is: "+(empSalary+2000));
    }
    if(!status){
        System.out.println("Salary of Employee is: "+empSalary);
    }
}
public void empinfo(){
    super.getinfo();
}
}

class Tester{
public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter number of Employees: ");
    int num = sc.nextInt();
    sc.nextLine();
    SalariedEmployee[] Emps = new SalariedEmployee[num];
    String name=null,id=null,age=null;
    double empsalary=0.0;
    for(int i=0; i<num; i++){
        Emps[i]= new SalariedEmployee(name,id,age,empsalary);
        System.out.println();
    }
    boolean loop = true;
    while(loop){
        System.out.println();
        System.out.println("Select action(Enter sr.number):");
        System.out.println("1.]View Employee salary.");
        System.out.println("2.]View Employee details.");
        System.out.println("3.]Exit.");
        int action = sc.nextInt();
        sc.nextLine();
        switch(action){
            case 1: System.out.println("Employee ids: ");
            for(int k=0; k<num; k++){
            System.out.print((k+1)+"]");
            System.out.println(Emps[k].ID);
            }
            System.out.print("Enter ID of the employee: ");
            String idcheck= sc.nextLine();
            for(int h=0; h<num; h++){
                if(idcheck.equals(Emps[h].ID)){
                    Emps[h].displaySalary();
                }
            }
            break;
            case 2:for(int j=0; j<num;j++){
                System.out.print((j+1)+"]");
                Emps[j].empinfo();
                System.out.println();
            }
            break;
            case 3:loop = false;
            System.out.println("Exited Menu.");
            break;
            default:System.out.println("Invalid input");
            loop = false;
            break;
        }
    }
    sc.close();
}
}
import java.util.Scanner;
class Posting{
 int CourseWork;
 int AptTest;
 int TechTest;
 int Interview;
 
 public Posting(int coursework, int apttest, int techtest,int interview){
 	this.AptTest =apttest;
 	this.TechTest = techtest;
 	this.CourseWork = coursework;
	this.Interview = interview;
 }
 public Posting(int techtest,int interview){
	this.TechTest = techtest;
 	this.Interview = interview;
 }
 public Posting(int interview){
	this.Interview = interview;
 }

public void display(String c){
	System.out.print("You have applied as: "+c+". ");
}
}

class employment{
public static void main(String []args){
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter your name: ");
	String name = sc.nextLine();
	System.out.println("Enter your domain name: ");
	System.out.println("1.]Programmer.");
	System.out.println("2.]TeamLeader.");
    	System.out.println("3.]ProjectManager");
	String choice = sc.nextLine();
	int m1,m2,m3,m4;
	if(choice.equalsIgnoreCase("Programmer")){
		System.out.println("Enter marks obtained in Coursework: ");
    	m1= sc.nextInt();
    	System.out.println("Enter marks obtained in Aptitude test: ");
    	m2= sc.nextInt();
    	System.out.println("Enter marks obtained in Tech test: ");
    	m3= sc.nextInt();
    	System.out.println("Enter marks obtained in interview: ");
    	m4= sc.nextInt();
    	boolean b1 = 80< m1+m2+m3+m4;
    	Posting p1 = new Posting(m1,m2,m3,m4);
		p1.display(choice);
		if(b1){
    	System.out.println("Congratulations "+name+". You are eligible to be recuited.");
		}
		else{
		System.out.println("You did not qualify");
		}
	}
	if(choice.equalsIgnoreCase("Teamleader")){
    	System.out.println("Enter marks obtained in Tech test: ");
    	m3= sc.nextInt();
    	System.out.println("Enter marks obtained in interview: ");
    	m4= sc.nextInt();
    	boolean b2 = 80< m3+m4;
    	Posting p2 = new Posting(m3,m4);
		p2.display(choice);
		if(b2){
    	System.out.println("Congratulations "+name+". You are eligible to be recuited.");
		}
		else{
		System.out.println("You did not qualify");
		}
	}
	if(choice.equalsIgnoreCase("Projectmanager")){
    	System.out.println("Enter marks obtained in interview: ");
    	m4= sc.nextInt();
    	boolean b3 = 90 < m4;
    	Posting p3 = new Posting(m4);
		p3.display(choice);
		if(b3){
    	System.out.println("Congratulations "+name+". You are eligible to be recuited.");
		}
		else{
		System.out.println("You did not qualify");
		}
	}
}
}

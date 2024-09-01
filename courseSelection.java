import java.util.Scanner;

abstract class Course{
abstract void studentDetails();
}

class Comps extends Course{
String UID,Name,Year;
Comps(String UID,String Name,String Year){
	this.UID = UID;
	this.Name = Name;
	this.Year = Year;
}
void studentDetails(){
	System.out.println(Year+" Student "+Name+" with UID.NO: "+UID+" is studying in Comps");
}
}

class IT extends Course{
String UID,Name,Year;
IT(String UID,String Name,String Year){
	this.UID = UID;
	this.Name = Name;
	this.Year = Year;
}
void studentDetails(){
	System.out.println(Year+" Student "+Name+" with UID.NO: "+UID+" is studying in IT branch");
}
}

public class courseSelection{
public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter number of Students for taking details: ");
	int num =sc.nextInt();
	sc.nextLine();
	Comps[] c1 = new Comps[num];
	IT[] it1 = new IT[num];
	int c=0,i=0;
	String uid=null,name=null,year=null;
	
	for(int m=0; m<num; m++){
	System.out.print("Enter Name of Student: ");
	name = sc.nextLine();
	System.out.print("Enter UID of student: ");
	uid = sc.nextLine();
	System.out.print("Enter year student is studying in(FE, SE, TE): ");
	year = sc.nextLine();
	System.out.println("Choose Course(Enter sr number): ");
	System.out.println("1.]Comps");
	System.out.println("2.]IT");
	int choice = sc.nextInt();
	sc.nextLine();
	switch(choice){
	case 1: c1[c] = new Comps(uid,name,year);
	c++;
	break;
	case 2: it1[i] = new IT(uid,name,year);
	i++;
	break;
	default: System.out.println("Invalid input");
	}
	}
	
	Comps cswap;
	for(int j=0; j<c; j++){
	for(int j2=j+1;j2<c;j2++){
	if(c1[j2].Year.equalsIgnoreCase("FE") && !(c1[j].Year.equalsIgnoreCase("FE")) ){
		cswap = c1[j2];
		c1[j2]= c1[j];
		c1[j]=cswap;
	}
	if(c1[j2].Year.equalsIgnoreCase("SE") && (c1[j].Year.equalsIgnoreCase("TE")) ){
		cswap = c1[j2];
		c1[j2]= c1[j];
		c1[j]=cswap;
	}
	}
	}
	IT itswap;
	for(int k=0; k<i; k++){
	for(int k2=k+1;k2<i;k2++){
	if(it1[k2].Year.equalsIgnoreCase("FE") && !(it1[k].Year.equalsIgnoreCase("FE")) ){
		itswap = it1[k2];
		it1[k2]= it1[k];
		it1[k]=itswap;
	}
	if(it1[k2].Year.equalsIgnoreCase("SE") && (it1[k].Year.equalsIgnoreCase("TE")) ){
		itswap = it1[k2];
		it1[k2]= it1[k];
		it1[k]= itswap;
	}
	}
	}
	System.out.println();
	System.out.println("Comps students: ");
	for(int l=0;l<c;l++){
	c1[l].studentDetails();
	}
	System.out.println();
	System.out.println("IT students: ");
	for(int t=0;t<i;t++){
	it1[t].studentDetails();
	}	
}
}

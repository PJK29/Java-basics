import java.util.Scanner;
class Items{
String Item;
int Price;

public Items(String item, int price ){
	this.Item = item;
	this.Price = price;
}
public void display(){
	System.out.println(Item +" is available for price Rs."+ Price);
}
}

class Purchase{
String Item;
int Price;
int Quantity;
Scanner scan = new Scanner(System.in);
int bill;
public Purchase(String item, int price ,  int quantity){
	this.Item = item;
	this.Price = price;
	this.Quantity = quantity;
}

public void billing(){
	bill = Price*Quantity;
	System.out.println("Net price is Rs."+bill);
}

public boolean payment(){
	int n = bill+50;
	System.out.println("Total payment for cash on delivery will be Rs."+n);
	System.out.println("Are you sure to chose this mode:(type yes to confirm only)");
	String s = scan.nextLine();
	
	if(s.equals("yes")){
	System.out.println(Item + " bought successfully.Please pay on delivery accordingly.Thank you for your using our website");
	}
	else{
	System.out.println("Exiting chosen option.");
	}
	return s.equals("yes") ;
}

public boolean payment(String Bank, int Account){
	double add = bill/100.0;
	double n = bill + add;
	System.out.println("Total payment for cash on delivery will be Rs."+n);
	System.out.println("Are you sure to chose this mode:(type yes to confirm only)");
	String s = scan.nextLine();
	
	if(s.equals("yes")){
	System.out.println(Item + " bought successfully.Please pay on delivery accordingly.Thank you for your using our website");
	}
	else{
	System.out.println("Exiting chosen option.");
	}
	return s.equals("yes") ;
	
}
public boolean payment(int c){
	double add = (2*bill)/100.0;
	double n = bill + add;
	System.out.println("Total payment for cash on delivery will be Rs."+n);
	System.out.println("Are you sure to chose this mode:(type yes to confirm only)");
	String s = scan.nextLine();
	
	if(s.equals("yes")){
	System.out.println(Item + " bought successfully.Please pay on delivery accordingly.Thank you for your using our website");
	}
	else{
	System.out.println("Exiting chosen option.");
	}
	return s.equals("yes") ;
} 

public static void main(String[] args){
	Items i1 = new Items( "keyboard",4000);
	System.out.print("1.]");
	i1.display();
	Items i2 = new Items( "chair",525);
	System.out.print("2.]");
	i2.display();
	Items i3 = new Items( "shoes",2300);
	System.out.print("3.]");
	i3.display();

	Scanner sc = new Scanner(System.in);
	System.out.println("Enter item name: ");
	String i = sc.nextLine();
	int p = 0;
	if(i.equals(i1.Item)){
		 p =i1.Price;
	}
	if(i.equals(i2.Item)){
		p =i2.Price;
	}
   	if(i.equals(i3.Item)){
	p =i3.Price;
	}
	System.out.println("Enter item quantity: ");
	int q = sc.nextInt();
	sc.nextLine();
	Purchase p1 = new Purchase(i,p,q);
	p1.billing();
	
	
	boolean b1 = false;
	while(!b1){
	System.out.println("Enter mode of payment(Enter sr. number)");
	System.out.println("1.]COD.");
	System.out.println("2.]NetBanking.");
	System.out.println("3.]Credit-Card.");
	int mode = sc.nextInt();
	sc.nextLine();
	switch (mode){
	case 1: b1 = p1.payment();
	break;
	
	case 2:System.out.println("Enter Bank name");
	String bank = sc.nextLine();
	System.out.println("Enter account number");
	int acc = sc.nextInt();
	b1 = p1.payment(bank,acc);
	break;
	
	case 3: System.out.println("Enter credit card number");
	int credit = sc.nextInt();
	b1 = p1.payment(credit);
	break;
	
	default : System.out.println("Invalid input");
	break;
	}
	}
}
}

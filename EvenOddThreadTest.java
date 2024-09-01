import java.util.*;

class EvenThread implements Runnable{
int Start,End;
EvenThread(int Start, int End){
	this.Start = Start;
	this.End = End;
}
public void run(){
	for(int i=Start; i<End; i++){
	if(i%2 == 0)
	System.out.println(i+" is even ");
	}	
}
}


class OddThread implements Runnable{
int Start,End;
OddThread(int Start, int End){
	this.Start = Start;
	this.End = End;
}
public void run(){
	for(int i=Start; i<End; i++){
	if(i%2 != 0)
	System.out.println(i+" is odd number");
	}	
}
}


class Sum implements Runnable{
int Start,End;

Sum(int Start, int End){
	this.Start = Start;
	this.End = End;
}
public void run(){
	int sum_even=0,sum_odd=0;;
	for(int i=Start; i<End; i++){
	if(i%2 == 0){
	sum_even += i;
		}	
	if(i%2 != 0){
	sum_odd += i;
		}
	}
	int sum = sum_odd + sum_even;
	System.out.println("SUM IS "+ sum);
}
}
class EvenOddThreadTest{
public static void main(String [] args){
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter start of range: ");
	int st = sc.nextInt();
	System.out.print("Enter end of range: ");
	int ed = sc.nextInt();
	EvenThread e1 = new EvenThread(st,ed);
	OddThread o1 = new OddThread(st,ed);
	Sum s1 = new Sum(st,ed);
	Thread t1 = new Thread(e1);
	Thread t2 = new Thread(o1);
	Thread t3 = new Thread(s1);
	
	t1.start();
	try{
	t1.join();
	}
	catch(Exception e){
	System.out.println("Exception detected: "+e);
	}
	t2.start();
	try{
	t2.join();
	}
	catch(Exception e){
	System.out.println("Exception detected: "+e);
	}
	t3.start();
	try{
	t3.join();
	}
	catch(Exception e){
	System.out.println("Exception detected: "+e);
	}
	
}
}

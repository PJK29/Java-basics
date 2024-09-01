/*Write a two-threaded program, where one thread finds all prime numbers (in 0 to 100) and another thread finds all palindrome numbers 
(in 10 to 1000). Schedule these threads in a sequential manner to get the results. Now reschedule them as parallel threads.*/
import java.util.*;

class primeNumber implements Runnable{
int start,end;
primeNumber(int start,int end){
    this.start = start;
    this.end = end;
}
public void run(){
    for(int i = start+1; i<end; i++){
    int count =0;
    for(int divisor = 2; divisor <= i/2; divisor++){
        if(i%divisor == 0){
            count ++;
        }
    }
    if(count<1){
        System.out.println(i+" is a prime number.");
    }
    }
}
}

class palindrome implements Runnable{
int start,end;
palindrome(int start,int end){
    this.start = start;
    this.end = end;
}
public void run(){
    for(int i=start+1; i<end; i++){
        int n = i,a=0;
        while(n>0){ 
        int d = n%10;
        a =a*10 + d;
        n = n/10;
        }
        
    if(i == a){
        System.out.println(i+" is a palindrome number.");
    }
    }
}
}

class NumberThreads{
public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter range for prime numbers:");
    System.out.print("Start: ");
    int st1 = sc.nextInt();
    System.out.print("End: ");
    int ed1 = sc.nextInt();
    System.out.println("Enter range for palindrome numbers:");
    System.out.print("Start: ");
    int st2 = sc.nextInt();
    System.out.print("End: ");
    int ed2 = sc.nextInt();

    primeNumber pn1 = new primeNumber(st1,ed1);
    palindrome pp1 = new palindrome(st2,ed2);

    Thread t1 = new Thread(pn1);
    Thread t2 = new Thread(pp1);
    System.out.println();
    System.out.println("Running threads Serially:");
    System.out.println();
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
    System.out.println();
    System.out.println("*************************************************************************");
    System.out.println("Running threads parallel:");
    System.out.println();
    Thread t3 = new Thread(pn1);
    Thread t4 = new Thread(pp1);
    t3.start();
    t4.start();
}
}
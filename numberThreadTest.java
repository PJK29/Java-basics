/*Write a Java program that implements a multi-thread application that has three threads.
 First thread generates a random integer for every 1 second; second thread computes the square of the number and prints;
  third thread will print the value of cube of the number. */

import java.util.*;

class numberGenerator extends Thread{
int max;
static int num;
numberGenerator(){}
numberGenerator(int max){
this.max = max;
}
public void generate(){
    double n=max*Math.random();
    num = (int)n;
    System.out.println("Random output generated: "+num);
}
}

class numberSquare extends numberGenerator{

public void run(){
    int n = num*num;
    System.out.println("Square of "+num+" = "+n);   
}
}
class numberCube extends numberGenerator{

public void run(){
    int n = (int)Math.pow(num,3);
    System.out.println("Cube of "+num+" = "+n);    
}
}

class numberThreadTest{
public static void main(String [] args){
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter range of number from 0 to ___:");
    int number = scan.nextInt();
    System.out.println("Taking random number from 0 to "+number);
    numberGenerator t1 = new numberGenerator(number);
    numberSquare t2 = new numberSquare();
    numberCube t3 = new numberCube();

    t1.generate();
    t2.start();
    t3.start();
}
}
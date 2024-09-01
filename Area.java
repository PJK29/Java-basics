import java.util.Scanner;

abstract class Shape{
abstract void RectangleArea(double Length,double breadth);
abstract void SquareArea(double Side);
abstract void CircleArea(double Radius);
}

class Area extends Shape{
public void RectangleArea(double length, double breadth){
    System.out.println("Units Area of rectangle is: "+ (length*breadth));
}
public void SquareArea(double Side){
    System.out.println("Units Area of Square is: "+ (Side*Side));
}
public void CircleArea(double Radius){
    System.out.println("Units Area of circle is: "+(Radius*Radius*Math.PI));
}
public void menu(){
Scanner sc = new Scanner(System.in);
boolean loop = true;
while(loop){
System.out.println("Choose shape(Enter sr number):");
System.out.println("1.]Rectanlge.");
System.out.println("2.]Square.");
System.out.println("3.]Circle");
System.out.println("4.]Exit.");
int choice = sc.nextInt();
switch(choice){
case 1:System.out.print("Enter length of Rectangle: " );
double l = sc.nextDouble();
System.out.print("Enter breadth of Rectangle: ");
double b = sc.nextDouble();
RectangleArea(l, b);
System.out.println();
break;
case 2:System.out.print("Enter Side of Square: " );
double s = sc.nextDouble();
SquareArea(s);
System.out.println();
break;
case 3:System.out.print("Enter Radius of Circle: " );
double r = sc.nextDouble();
CircleArea(r);
System.out.println();
break;
case 4: loop = false;
System.out.println("Exited menu");
break;
}
}
}

public static void main(String [] args){
Area a1 = new Area();
a1.menu();
}
}
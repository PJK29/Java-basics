/*Write a program to implement stack operations:
a.Push b. Pop
Write a user defined exception to check whether the 
stack is full or empty.*/

import java.util.*;
class stackEmpty extends Exception{
public String toString(){
    return "Error detected. Stack is empty." ;
}
}
class stackFull extends Exception{
    public String toString(){
        return "Error detected. Stack is full." ;
    }
}
class testStack{
static void checkError(Stack<String> st){
    try{
        if(st.isEmpty()){
        throw new stackEmpty();
        }
    }
    catch(stackEmpty E){
        System.out.println(E);
    }
    try{
        if(!st.isEmpty()){
        throw new stackFull();
        }
    }
    catch(stackFull E){
        System.out.println(E);
    }
}
public static void main(String []  args){
    Stack<String> st = new Stack<String>();
    Scanner sc = new Scanner(System.in);
    checkError(st);
    st.push("1st");
    st.push("2nd");
    st.push("3rd");
    st.push("4th");
    st.push("5th");
    System.out.println("Stack is: "+st);
    checkError(st);
    boolean loop =true;
    while(loop){
    System.out.println();
    System.out.println("Choose action(Enter sr number):");
    System.out.println("1.]Add element.");
    System.out.println("2.]Remove element.");
    System.out.println("3.]Print stack");
    System.out.println("4.]Exit.");
    int choice = sc.nextInt();
    sc.nextLine();
    switch(choice){
    case 1: System.out.print("Enter element: ");
    String addition = sc.nextLine();
    st.push(addition);
    break;
    case 2:String removed = st.pop();
    System.out.println("Removed element: "+ removed);
    break;
    case 3:System.out.println("Stack is: "+ st);
    break;
    case 4: loop = false;
    System.out.println("Exited menu");
    break;
    default:
    System.out.println("Inovalid input");
    }
    checkError(st);
    }
    }
    }
import java.util.*;
interface Sortable{
void sort();
}
class BubbleSort implements Sortable{
int [] arrayInt;
BubbleSort(int [] arrayInt){
	this.arrayInt = arrayInt;
}
public void view(){
	System.out.print("{ ");
	for(int i=0; i<arrayInt.length; i++){
	System.out.print(arrayInt[i]);
	if(i< arrayInt.length -1){
	System.out.print(", ");
	}
	}
	System.out.print(" }");
}
public void sort(){
	int flag=0;
	for(int i=0; i<arrayInt.length; i++){
	for(int j=0; j<arrayInt.length - 1; j++){
	if(arrayInt[j+1] < arrayInt[j]){
	flag = arrayInt[j+1];
	arrayInt[j+1]= arrayInt[j];
	arrayInt[j]=flag;
	}
	}
	}
	view();
}
}
class SelectionSort implements Sortable{
int [] arrayInt;
SelectionSort(int [] arrayInt){
	this.arrayInt = arrayInt;
}
public void view(){
	System.out.print("{ ");
	for(int i=0; i<arrayInt.length; i++){
	System.out.print(arrayInt[i]);
	if(i< arrayInt.length -1){
	System.out.print(", ");
	}
	}
	System.out.print(" }");
}
public void sort(){
	int flag = 0;
	for(int i=0; i<arrayInt.length; i++){
	int min = i;
	for(int j=i; j<arrayInt.length; j++){
	if(arrayInt[j] < arrayInt[min] ){
	min = j;
	}
	}
	flag = arrayInt[i];
	arrayInt[i]= arrayInt[min];
	arrayInt[min]=flag; 
	}
	view();
}
}
class Sorting{
public static void main(String [] args){
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter size of array: ");
	int size = sc.nextInt();
	int [] array = new int[size];
	for(int i=0; i<size; i++){
	System.out.print("Enter "+i+" index array element: ");
	array[i] = sc.nextInt();
	}
	System.out.println("Choose sorting type(Enter sr number): ");
	System.out.println("1.]Bubble sort");
    System.out.println("2.]Selection sort");
    int choice = sc.nextInt();
    switch(choice){
    case 1:BubbleSort b1 = new BubbleSort(array);
    b1.sort();
    break;
    case 2:SelectionSort s1 = new SelectionSort(array);
    s1.sort();
    System.out.println();
    break;
    default:
    break;
    }
}
}

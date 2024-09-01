
import java.nio.file.Path;
import java.net.URL;
import java.io.*;
import java.util.*;

interface Searchable{
void search();
}

class Document implements Searchable{
String word,Sentences;
static String prevWord = "asdfasdfasdf";
static int line = 0;
Document(String word,String Sentences){
	this.word = word;
	if(!prevWord.equals(word)){
		line =0;
	}
	this.prevWord = word;
	this.Sentences = Sentences;
}
public void search(){
	line ++;
	for(int i=0; i< Sentences.length() - word.length() +1; i++){
	if(Sentences.substring(i,i + word.length()).equalsIgnoreCase(word)){
	if((i >0 && i+ word.length() < Sentences.length())){
	if( (Sentences.charAt(i+word.length()) == ' ' || Sentences.charAt(i+word.length()) == '.' )  && (Sentences.charAt(i-1) == ' ' || Sentences.charAt(i-1) == '.') ){
	System.out.println("The word "+word+" found in line "+line+" at index "+ i);
	}
	}
	if(i==0 && (Sentences.charAt(word.length()) == ' ' || Sentences.charAt(word.length()) == '.')){
	System.out.println("The word "+word+" found in line "+line+" at index "+ i);
	}
	if( i + word.length()  == Sentences.length()  && (Sentences.charAt(i-1) == ' ' || Sentences.charAt(i-1) == '.')){
	System.out.println("The word "+word+" found in line "+line+" at index "+ i);
	}
	}
	}
}
}

class WebPage implements Searchable{
int number;
static int line=0;
String webpage;
WebPage(int number,String webpage){
	this.number = number;
	this.webpage = webpage;
}
public int digits(){
	int a = number,digit = 0;
	while(a>0){
	digit++;
	a = a/10;
	}
return digit;
}
public void search(){
	line ++;
	int digit = digits();
	String num = Integer.toString(number);
	for(int i=0; i< webpage.length() - digit + 1; i++){
	if(webpage.substring(i,i + digit).equals(num)){
	if(i >0 && i+ digit < webpage.length()){
	if( (webpage.charAt(i+digit) == ' ' || webpage.charAt(i+digit) == '.' )  && (webpage.charAt(i-1) == ' ' || webpage.charAt(i-1) == '.') ){
	System.out.println("The number "+number+" found in line "+line+" at index "+ i);
	}
	}
	if(i==0 && (webpage.charAt(digit) == ' ' || webpage.charAt(digit) == '.')){
	System.out.println("The number "+number+" found in line "+line+" at index "+ i);
	}
	if( i + digit  == webpage.length()  && (webpage.charAt(i-1) == ' ' || webpage.charAt(i-1) == '.')){
	System.out.println("The number "+number+" found in line "+line+" at index "+ i);
	}
	}
	}

}
}

class Searching{
public static void main(String[] args)throws IOException{
	Scanner scan = new Scanner(System.in);
	boolean loop = true;
	while(loop){
	System.out.println("Choose Searching type(Enter sr number): ");
	System.out.println("1.]Search Word from a Document");
    System.out.println("2.]Search number from a webpage");
	System.out.println("3.]Exit.");
    int choice = scan.nextInt();
	scan.nextLine();
    switch(choice){
    case 1:
	System.out.print("Enter Searching word (Recommended word: hello): ");
	String word = scan.nextLine();
	Path Document = Path.of("D:\\PDAF\\PSTDY\\COMPSC125PSOOP\\experiment8\\Document.txt");
	Scanner sc = new Scanner(Document);
	while(sc.hasNext()){
	String document = sc.nextLine();
	Document d1 = new Document(word,document);
	d1.search();
	}
	System.out.println();
    break;
    case 2:
	System.out.print("Enter number to be searched: ");
	int num = scan.nextInt();
	scan.nextLine();
	URL webpagelink = new URL("https://www.spit.ac.in/");
	Scanner scc = new Scanner(webpagelink.openStream());
	while(scc.hasNext()){
	String webpage = scc.nextLine();
	WebPage w1 = new WebPage(num,webpage);
	w1.search();
	}
    System.out.println();
    break;
	case 3: System.out.println("Exited menu.");
	loop = false;
	break;
    default:System.out.println("Invalid input. try again");
    break;
    }
	}
}
}

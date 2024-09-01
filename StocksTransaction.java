import java.util.Scanner;

class Stocks{
String StockName;
int [] StockPriceArray;

public Stocks(String StockName,int [] StockPriceArray){
	this.StockName = StockName;
	this.StockPriceArray = StockPriceArray;
	System.out.print("Stock Prices: {");
	for(int i=0; i<StockPriceArray.length ; i++){
		System.out.print(StockPriceArray[i]);
		if(i< StockPriceArray.length-1){
			System.out.print(",");
		}
	}
	System.out.println("}");
}
}

class Transaction extends Stocks{
String StockName;
int[] Prices;
public Transaction(String Name, int[] PricesArray){
	super(Name,PricesArray);
	StockName = Name;
	Prices = PricesArray;
}

public void findMaxProfit(){
	int t=-1,profit=0;
	for(int i=0; i< Prices.length; i++){	
	for(int j=i; j<Prices.length; j++){
	if(i>t && i == (Prices.length - 2) && Prices[j]>Prices[i]){
		profit = profit +(Prices[j]-Prices[i]);
		System.out.println("A.]Buy on day "+(i+1)+" and sell on day "+(j+1)+".");
	}

	if(Prices[j]<Prices[i]){
	for(int o=i; o<=j;o++){
	if(Prices[o]<= Prices[i]){
		i=j;
		break;
		}
	}
	}

	if(Prices[j]>Prices[i]){
	for(int q=j; q<Prices.length; q++){
	if( i>t && Prices[j]>Prices[q] ){
		t=j;
		profit = profit +(Prices[j]-Prices[i]);
		System.out.println("B.]Buy on day "+(i+1)+" and sell on day "+(j+1)+".");
		break;
		}
	if( i>t && Prices[j]<Prices[q]){
		if(q == (Prices.length -1) || Prices[q+1]<Prices[q]){
		t=q;
		profit = profit +(Prices[q]-Prices[i]);
		System.out.println("C.]Buy on day "+(i+1)+" and sell on day "+(q+1)+".");
		break;
	}
	}
	}
	i++;
	}

	}
	}	
	System.out.println("Total Profit earned is: "+profit);
}
public static void main(String [] args){
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter number of Days: ");
	int N = sc.nextInt();
	
	int [] A = new int[N];
	for(int i=0; i<N;i++){
	System.out.print("Enter predicted price of stocks on day "+(i+1)+": ");
	A[i]= sc.nextInt();
	}
	sc.nextLine();
	System.out.print("Enter name of stocks: ");
	String name = sc.nextLine();
	Transaction t1 = new Transaction(name,A);
	t1.findMaxProfit();
	sc.close();
}
} 

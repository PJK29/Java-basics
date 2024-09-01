import java.util.*;
abstract class Player{
int Number;
abstract int getGuess();
}
class HumanPlayer extends Player{
Scanner scan = new Scanner(System.in);
public HumanPlayer(){}
public HumanPlayer(int K){
    System.out.print("Enter Number to be guessed(0-100): ");
    Number = scan.nextInt();
}
public int getGuess(){    
    System.out.print("Enter your guess: ");
    int guess = scan.nextInt();
    return guess;
    }
}

class ComputerPlayer extends Player{
public ComputerPlayer(){}
 public ComputerPlayer(int K){
    System.out.println("ComputerPlayer 1 is setting answer.");
    double n = Math.random()*100;
    Number = (int)n;
}
public int getGuess(){ 
    System.out.println("ComputerPlayer 2 is guessing answer.");
    double g = Math.random()*100;
    return (int)g;
}
}
class GuessGame{
Scanner scan = new Scanner(System.in);
void Play(Player player1, Player player2){
    System.out.println("Choose gameplay"); 
	System.out.println("1.]Human vs Human");
	System.out.println("2.]Human vs Computer");
    System.out.println("3.]Computer vs Computer");
    int choice = scan.nextInt();
    System.out.println("For Player 1: ");
    System.out.print("Enter number of guesses to be given: ");
    int K = scan.nextInt();
    if(choice == 1){
    player1 = new HumanPlayer(K);
    }
    if(choice ==2){
    player1 = new HumanPlayer(K);
    player2 = new ComputerPlayer(); 
    }
    if(choice == 3){
    player1 = new ComputerPlayer(K);
    player2 = new ComputerPlayer();
    }
    System.out.println("**************************************************************************");
    System.out.println("**************************************************************************");
    System.out.println("**************************************************************************");
    System.out.println("For Player 2. Starting the game now: ");
    System.out.println();
    boolean win;
    for(int i=0; i< K; i++){
    int guess = player2.getGuess();
    System.out.print((i+1)+".]");
    win = Checkanswer(guess, player1.Number);
    if(win){ 
        break;
    }
    if(i == K - 1 && !win){
        System.out.println("You've run out of guesses :( .The answer was "+player1.Number);
    }
    System.out.println();
    }
}
boolean Checkanswer(int guess,int answer){
    if(guess > answer ){
        System.out.println("Number you guessed "+guess+" is greater than actual number");
    }
    if(guess < answer ){
        System.out.println("Number you guessed "+guess+" is lower than actual number");
    }
    if(guess == answer ){
        System.out.println("Congrats You've guessed "+guess+" the actual Number!");
        return true;
    }
    return false;
}
public static void main(String[] args){
    GuessGame g1 = new GuessGame();
    Player p1 = new HumanPlayer();
    Player p2 = new HumanPlayer();
    g1.Play(p1,p2);
}
}
//import textio.TextIO;
//import java.awt.font.TextHitInfo;
//import java.util.*;
import java.util.Scanner; 


public class HighLow{
	public static void main(String[] args){
		//Scanner scan = new Scanner(System.in);
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("This program lets you play a simple card game,");
		System.out.println("HighLow. a card game dealt from a deck of cards.");
		System.out.println("higher or lower. your score in the game is the ");
		System.out.println("number of correct predictions you make before");
		System.out.println("you guessed wrong");
		System.out.println();
		
		
		int gamesPlayed = 0; 
		int sumOfScores = 0; 
		
		double averageScore; 
		boolean playAgain; 
		
		do{
			int scoreThisGame; 
			scoreThisGame = play();
			sumOfScores+= scoreThisGame;
			gamesPlayed++;
			System.out.print("Play again? ");
			playAgain = keyboard.nextBoolean();
			//playAgain = TextIO.getInBoolean();
		}while(playAgain);
		
			averageScore =((double)sumOfScores)/gamesPlayed;
				
				System.out.println();
			System.out.println("you played"+ gamesPlayed +"games");
			System.out.printf("Your average score was %1.3f.\n", averageScore);
	}
			
	private static int play(){
		Deck deck = new Deck();
		
		Card currentCard; 
		Card nextCard;
		
		int correctGuesses;
		
		char guess;
		
		deck.shuffle();
		
		correctGuesses = 0; 
		currentCard = deck.dealCard();
		System.out.println("The first card is the "+ currentCard);
		
		while(true){
			Scanner keyboard = new Scanner(System.in);
			System.out.print("will the next card be higher (H) or Lower (L)? ");
			do{
				guess = keyboard.next().charAt(0);
				guess = Character.toUpperCase(guess);
				if(guess !='H' && guess != 'L');
					System.out.println("Please respond with H OR L: ");
			}while (guess != 'H' && guess != 'L');
				nextCard = deck.dealCard();
				System.out.println("the next card is" + nextCard);
				
				if(nextCard.getValue()== currentCard.getValue()){
					System.out.println("the value is the same as the prevous card.");
					System.out.println("you lose on ties. sorry!");
					break; 
				}
				else if (nextCard.getValue()> currentCard.getValue()){
					if(guess =='H'){
						System.out.println("your prediciton was correct.");
						correctGuesses++;
					}else
					{
						System.out.println("your prediction was incorrect.");
						break;
					}
				}else {
					if (guess == 'L'){
						System.out.println("your prediction was correct.");
						correctGuesses++;
					}
					else{
						System.out.println("your prediction was incorrect. ");
						break; 
					}
				}
						currentCard = nextCard; 
						System.out.println();
						System.out.println("the card is "+ currentCard);
		}
		System.out.println();
		System.out.println("the game is over.");
		System.out.println("you made "+ correctGuesses
											+"correct predictions.");
		System.out.println();
		return correctGuesses; 
	}
}
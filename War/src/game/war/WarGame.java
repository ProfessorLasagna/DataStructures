//All commented code in this class is debug commands that were used to collect data on how the game functions.

package game.war;
 
 import java.util.ArrayList;
 import java.util.NoSuchElementException;
 import java.util.Scanner;
 
 public class WarGame extends Card{
 
 	public static Scanner in = new Scanner(System.in);
 	public static int handcur = 26, handcur2 = 26, a = 0;
 	
 	public static void main(String args[]){
 		
 		
// 		int win = 0, loss = 0, endless = 0, underone = 0, overone = 0;
// 		
// 		for(a = 0; a < 10000; a++){
 			
 			Card card = new Card();
 			
 			card.deck();
 			
 			int no = 1;
 			
  			System.out.format("Welcome to the card game war!"
  					+ "%nThis game is a true test of luck. You will be computing against me, the computer!"
  					+ "%nI will deal twenty-six cards to you and then 26 to myself."
  					+ "%nWe will then begin by placing our first card down. The player with the highest value card wins both cards."
  					+ "%nIf we both draw the same card that means we have to go to war!"
  					+ "%nIn the case of war we will each place another two cards, one face up and the other down, on the playing field."
  					+ "%nThe player with the highest face up card gets all of the cards on the table!"
  					+ "%nThis will continue until one of us has no cards left."
  					+ "%n%nPlease press the 'Enter' key to begin!");
 			
 			do{	 
 	
 				in.nextLine();
 				System.out.format("%n%nTurn:%d%n%n", no);
 				no++;
 				cardDraw();	
  				
 							
 			}while(hand1.size() > 0 && hand2.size() > 0 && no < 10000);
 	
 			if(hand1.size() == 0){
 			
  				System.out.format("%nCards Remaining:  0         Cards Remaining: 52");
  				System.out.format("%n%nOh no! You lost! %nGame over!");
// 				loss++;
 				
// 				if(no < 1000)
// 					underone++;
// 				
// 				else
// 					overone++;
 			
 			}
 			
 			else if(hand2.size() == 0){
 				
  				System.out.format("%nCards Remaining: 52         Cards Remaining:  0");
  				System.out.format("%n%nYay! You Won! %nGame Over!");
// 				win++;
 				
// 				if(no < 1000)
// 					underone++;
// 				
// 				else
// 					overone++;
// 				
// 			}else{
// 				endless++;
// 			}
 			
// 			hand1.removeAll(hand1);
// 		    hand2.removeAll(hand2);
 			
// 		}
 		
// 		System.out.format("%n%n%n%nWins: %d %nLosses: %d %nEndless: %d %n%nGames that took less than 1000 turns: %d"
//				+ "%nGames that took over 1000 turns: %d", win, loss, endless, underone, overone);
 		
 		
 			}
 			
 		in.close();
 	
 	}
 	
 	public static void cardDraw(){
 		
 		String card1, card2;
 		
  		System.out.format("%nCards Remaining: %2d         Cards Remaining: %2d", hand1.size(), hand2.size());
 		
 		try{
 			
 			card1 = hand1.remove();
 		
 		}catch(NoSuchElementException e){
 			
 			return;
 			
 		}
 		
 		try{
 			
 			card2 = hand2.remove();
 		
 		}catch(NoSuchElementException e){
 			
 			return;
 			
 		}
 		
 		
 		
  		System.out.format("%n __________                  __________  "
  						+ "%n|          |                |          | "
  						+ "%n|          |                |          | "
  						+ "%n|    %2s    |       VS       |    %2s    |"
  						+ "%n|          |                |          | "
  						+ "%n|          |                |          | "
  						+ "%n|__________|                |__________| ", card1, card2);
 		
 			if(Integer.parseInt(card1) < Integer.parseInt(card2)){
 				
  				System.out.format("%nYou Lost! Press enter to draw again.%n%n%n");
 				
 				if((int)Math.random()* 10 > 5){
 					
 					hand2.add(card2);
 					hand2.add(card1);
 					
 				}else{
 					
 					hand2.add(card1);
 					hand2.add(card2);
 					
 				}
 				
 			}else if(Integer.parseInt(card1) > Integer.parseInt(card2)){
 				
  				System.out.format("%nYou Won! Press enter to draw again.%n%n%n");
 				
 				if((int)Math.random()* 10 >= 5){
 					
 					hand1.add(card2);
 					hand1.add(card1);
 					
 				}else{
 					
 					hand1.add(card1);
 					hand1.add(card2);
 					
 				}
 				
 				
 			}else
 				war(card1, card2);
 		
 	}
 	
 	public static void war(String card1, String card2){
 		
 		String card3, card4;
 		
 		ArrayList<String> field = new ArrayList<String>();
 		
 		if((int)Math.random()* 10 >= 5){
 			
 			field.add(card2);
 			field.add(card1);
 			
 		}else{
 			
 			field.add(card1);
 			field.add(card2);
 			
 		}	
 		
  		System.out.format("%nThis means war! Press enter to draw your next two cards!%n");
  		
  		in.nextLine();
 		
 		do{
 				 				
 				
 			try{
 				
 				card3 = hand1.remove();
 				card1 = hand1.remove();
 				
 				field.add(card1);
 				field.add(card3);
 				
 			}catch(NoSuchElementException e){
 				
 				return;
 				
 			}
 			
 			try{
 				
 				card4 = hand2.remove();
 				card2 = hand2.remove();
 				
 				field.add(card2);
 				field.add(card4);
 				
 			}catch(NoSuchElementException e){
 
 				return;
 				
 			}
 					
  			System.out.format("%n __________                  __________  "
  					+ "%n|          |                |          | "
  					+ "%n|          |                |          | "
  					+ "%n|    %2s    |       VS       |    %2s    |"
  					+ "%n|          |                |          | "
  					+ "%n|          |                |          | "
  					+ "%n|__________|                |__________| ", card1, card2);
 			
 			if(card1.equals(card2)){
 				
  				System.out.format("%nAnother War!! Press enter to draw your next card!%n%n%n");
  				
  				in.nextLine();
 			
 			}else if(Integer.parseInt(card1) > Integer.parseInt(card2)){
 				
  				System.out.format("%nYou won the war! Press enter to draw your next card.%n%n%n");
 				
 				for(int a = 0; a < field.size(); a++){
 					
 					hand1.add(field.get(a));
 				
 				}
 							
 			}else if(Integer.parseInt(card1) < Integer.parseInt(card2)){
 				
  				System.out.format("%nYou lost the war! Press enter to draw your next card.%n%n%n");
 				
 				for(int a = 0; a < field.size(); a++){
 					
 					hand2.add(field.get(a));
 				
 				}
 				
 			}
 			
 		}while(card1.equals(card2));
 		
 	}
 	
 }

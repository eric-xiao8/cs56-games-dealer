package edu.ucsb.cs56.projects.games.dealer;

import java.util.ArrayList;

/**
 * The player of the game.
 * @author Kin Kwan Poon
 * @version UCSB, cs56, F16
 */
public class BlackJackPlayer extends Hand {
	private String name;
	
	/**
	 * Constructor of BlackJackPlayer
	 * @param name
	 */
	public BlackJackPlayer(String name){
		super();
		this.name=name;
	}
	
	/**
	 * Getter of name
	 * @return name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * 
	 * @return total card value in hand.
	 */
 	public int getHandValue(){
		ArrayList<Card> hand=this.getHand();
		int total=0;
		boolean haveAce=false;
		for(Card c:hand){
			if(c.rankValue(true)==1)
				haveAce=true;
			total+=c.rankValue(true);
		}
		if(haveAce&&total<=11)
			total+=10;
		return total;
	}
 	
 	/**
 	 * 
 	 * @return if total card value in hand over 21 or not
 	 */
 	public boolean isBusted(){
 		return(getHandValue()>21);
 	}
 	
 	/**
 	 * Remove the card in hand.
 	 */
 	public void clearHand(){
 		hand.clear();
 		handSize=0;
 	}
 	
 	/**
 	 * TODO: write the code for GUI as well
 	 * The action will do if busted.
 	 */
 	public void busted(){
 		System.out.println(name+" busted.");
 	}
 	/**
 	 * TODO: write the code for GUI as well
 	 * The action will do if win.
 	 */
 	public void win(){
 		System.out.println(name+" wins.");
 	}
 	/**
 	 * TODO: write the code for GUI as well
 	 * The action will do if lose.
 	 */
 	public void lose(){
 		System.out.println(name+" loses.");
 	}
 	/**
 	 * TODO: write the code for GUI as well
 	 * The action will do if push.
 	 */
 	public void push(){
 		System.out.println(name+" pushes.");
 	}
 	
 	/**
 	 * @return The name and the cards in hand.
 	 */
 	@Override
 	public String toString(){
 		String result=""+name+": \n";
 		for(int i=0;i<handSize;i++){
 			if(i!=0){
 				result+=", ";
 			}
 			result+=hand.get(i).toString();
 		}
 		result+=" ("+getHandValue()+")\n";
 		return result;
 	}
 	
 	
}

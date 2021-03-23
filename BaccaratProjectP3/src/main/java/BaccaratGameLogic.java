import java.util.ArrayList;


public class BaccaratGameLogic {
//checks who won
	public String whoWon(ArrayList<Card> hand1, ArrayList<Card> hand2) {
		if(handTotal(hand1) > handTotal(hand2)){
			return "Player Won";
		}
		if(handTotal(hand1) >= 10){
			return "Dealer Won";
		}
		if(handTotal(hand2) >= 10){
			return "Player Won";
		}
		if(handTotal(hand1) == handTotal(hand2)){
		return "Tie";
		}
		return "Dealer Won";
	}
	//checks the total of the hand
	public int handTotal(ArrayList<Card> hand) {
		int val = 0;
		int total = 0;
		
		
		for(Card c: hand){
			val = c.getValue();

			if(val == 10 || val == 11 || val == 12 || val == 13) {
			val = 0;	
			}
			total = val + total;
			if(hand.size() == 2) {
			if(total >= 9) {
				total = val;
			}
			}
		//	System.out.println(total);
		}
		return total;
	}
	//determines if the banker should draw or not
	public boolean evaluateBankerDraw(ArrayList<Card> hand, int playerCard) {

		if(handTotal(hand) <= 3){
			return true;
		}
		if(handTotal(hand) >= 7){
			return false;
		}
		int temp = 0;
		int Htotal = 0;

			temp = playerCard;
			Htotal = handTotal(hand);
			//no draw

			//Face card
			if(temp == 10 || temp == 11 || temp == 12 || temp == 13 ){
				if(Htotal <= 3){
					return true;
				}
				return false;
			}
			//Ace
			if(temp == 1 ){
				if(Htotal <= 3){
					return true;
				}
				return false;
			}//2
			if(temp == 2 ){
				if(Htotal <= 4){
					return true;
				}
				return false;
			}//3
			if(temp == 3 ){
				if(Htotal <= 4){
					return true;
				}
				return false;
			}//4
			if(temp == 4 ){
				if(Htotal <= 5){
					return true;
				}
				return false;
			}//5
			if(temp == 5 ){
				if(Htotal <= 5){
					return true;
				}
				return false;
			}//6
			if(temp == 6 ){
				if(Htotal <= 6){
					return true;
				}
				return false;
			}//7
			if(temp == 7 ){
				if(Htotal <= 6){
					return true;
				}
				return false;
			}//8
			if(temp == 8 ){
				if(Htotal <= 2){
					return true;
				}
				return false;
			}//9
			if(temp == 9 ){
				if(Htotal <= 3){
					return true;
				}
				return false;
			}
			return false;
	}
	//determines if the player should draw
	public boolean evaluatePlayerDraw(ArrayList<Card> hand) {
		if (handTotal(hand) >= 6){
			return false;
			}
		else{
		return true;
	}
	}
}

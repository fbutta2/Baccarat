import java.util.ArrayList;

//
//
//
//
//
//BaccarateDealer
//
//
//
public class BaccaratDealer {
	ArrayList<Card> deck;
	
	//makes deck
	public void generateDeck() {
	 String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades" };
	 deck = new ArrayList<>();
     for( int count = 0; count < 52; count++)
     {
         this.deck.add(new Card(suits[count / 13], 1 + count%13));
         //deck.getValue();
        // this.toString();
         
     }
    // System.out.println(deck);
     shuffleDeck();
     //System.out.println(deck);

	}	
	//getter for deck
public ArrayList<Card>rtDeck() {
	
	return deck;
	
}
	 
	
	//deals cards
	public ArrayList<Card> dealHand() {
        ArrayList<Card> tmp = new ArrayList<>();
        //checks deck to make sure there is enough cards
		if (this.deckSize() < 6){
		this.generateDeck();		
		}
		// deals two cards 
        for(int i =0; i<2; i++){
            tmp.add(this.deck.remove(0));

        }
		//System.out.println(tmp);

        return tmp;
	}
	//draws one card if the player has less then 3
	public ArrayList<Card> drawOne(ArrayList<Card> tmp) {
		int value = 0;
		if(tmp.size() < 3){
			tmp.add(this.deck.remove(0));
		}
		//System.out.println(tmp);
		return tmp;

		
	}
	//shuffles
	public void shuffleDeck() {
	       java.util.Collections.shuffle(deck); 
	}
	//checks deck size
	public int deckSize() {
		return this.deck.size();
	}


}

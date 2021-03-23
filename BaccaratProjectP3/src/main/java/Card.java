

public class Card {
    String suit;
     int value;
    /**
     * Constructor for objects of class Card with parameters suit and value.
     */
    //sets suit and number
    public Card(String suit, int value)
    {
        this.suit = suit;
        this.value = value;
        
     }

     //gets suit
     public String getSuit()
     {
        return this.suit;
     }
    //gets number
    public int getValue()
    {
        return this.value;
    }
    //gets value of card drawn

    //prints suit and val
    public String toString()
    {
        return value + " " + suit;
    }
}
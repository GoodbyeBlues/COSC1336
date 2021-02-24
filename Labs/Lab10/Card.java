package Lab10;

public class Card { 
   
   //class constants: RANK and SUIT
   final String SUIT;
   final int    RANK;  
   
   //class constructor initializes Rank and Suit from its params
   public Card(String suit, int rank) {
		
		//assign
		SUIT = suit;
		RANK = rank;
    
   } 
   
   //RankAndSuit() to return RANK and SUIT
   //as a String
   public String RankAndSuit() { 

      return SUIT + "," + RANK;
   }
   
}//end class

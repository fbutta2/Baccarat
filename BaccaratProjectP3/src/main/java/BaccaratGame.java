import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;






public class BaccaratGame extends Application    {
	ArrayList<Card> playerHand;
	ArrayList<Card> bankerHand;
	BaccaratDealer theDealer;
	
	ArrayList<Card> NewDeck;
	double currentBet;
	double totalWinnings;
	private TextField text;
	private Button btn;
	Button draw;
	Button bidDealer;
	VBox paneCenter;
	Scene scene;
	MenuBar menu;
	String test;
	TextField winnings;
	TextField outCome;
	int betstatus = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaccaratDealer 	Bdeck = new BaccaratDealer();
		Bdeck.generateDeck();
		//Bdeck.toString();
		//playerHand = Bdeck.dealHand();
		//playerHand = Bdeck.drawOne(playerHand);

	    //System.out.println(playerHand);
		 launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		BaccaratDealer 	Bdeck = new BaccaratDealer();
		Bdeck.generateDeck();
		BaccaratGameLogic gameLogic = new BaccaratGameLogic();
		primaryStage.setTitle("Baccarat Game");
		
		text = new TextField();
		winnings = new TextField();
		outCome = new TextField();
		
		winnings.setText("Total Winnings = "+ totalWinnings);
		winnings.setDisable(true);
		btn = new Button("Bid on you");
		Button start = new Button("Deal");


EventHandler<ActionEvent> handler1 = new EventHandler<ActionEvent>() {
			//stores bet in currentBet
			// bets on player
			public void handle(ActionEvent action) {
				currentBet = Double.parseDouble(text.getText());
				betstatus = 1;
				btn.setDisable(true);
				bidDealer.setDisable(true);
				draw.setDisable(true);
				start.setDisable(false);




				//test double parsing
				//System.out.print(currentBet);
				
				//totalWinnings = currentBet + 1;
				//System.out.print(totalWinnings);

			}
		};

		//clears total winnings 
		start.setDisable(true);
		EventHandler<ActionEvent> handler4 = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent action) {
				int bankTotal = 0;
				int playerTotal = 0;
				boolean playerDraw;
				int drawnCard = 0;
				boolean dealerDraw;
				String whoWon;
				playerHand = Bdeck.dealHand();
				bankerHand = Bdeck.dealHand();
				bankTotal = gameLogic.handTotal(bankerHand);
				playerTotal = gameLogic.handTotal(playerHand);
				//checks for nautrals
				if((bankTotal == 8 || bankTotal == 9 || playerTotal == 8 || playerTotal == 9)) {

				if(playerTotal == 8 || playerTotal == 9) {
		
					if(betstatus == 1) {
						outCome.setText("Player scored a Natural. Player Won. Congrats you bet on player.");
						winnings.setDisable(false);
						totalWinnings = currentBet + totalWinnings;
						winnings.setText("Total Winnings = "+ totalWinnings);
						winnings.setDisable(true);
					}
					else if(betstatus == 2) {
						outCome.setText("Player scored a Natural. Player Won. Unfourtnatley you chose dealer.Sorry you lose.");
						if(totalWinnings > currentBet) {
						winnings.setDisable(false);
						totalWinnings = totalWinnings - currentBet;
						winnings.setText("Total Winnings = "+ totalWinnings);
						winnings.setDisable(true);
						}
						else {
							winnings.setDisable(false);
							totalWinnings = 0;
							winnings.setText("Total Winnings = "+ totalWinnings);
							winnings.setDisable(true);
						}
				}
					else if(betstatus == 3) {
						outCome.setText("Player scored a Natural. Player Won. Unfourtnatley you chose tie.Sorry you lose.");
						if(totalWinnings > currentBet) {
							winnings.setDisable(false);
							totalWinnings = totalWinnings - currentBet;
							winnings.setText("Total Winnings = "+ totalWinnings);
						winnings.setDisable(true);
						}
						else {
							winnings.setDisable(false);
							totalWinnings = 0;
							winnings.setText("Total Winnings = "+ totalWinnings);
							winnings.setDisable(true);
						}
				}
				}
				if(bankTotal == 8 || bankTotal == 9) {
					
					if(betstatus == 2) {
						outCome.setText("Banker scored a Natural. Banker Won. Congrats you bet on dealer.");
						winnings.setDisable(false);
						totalWinnings = (currentBet *.95) + (totalWinnings);
						winnings.setText("Total Winnings = "+ totalWinnings);
						winnings.setDisable(true);
					}
					else if(betstatus == 1) {
						outCome.setText("Player scored a Natural. Player Won. Unfourtnatley you chose dealer.Sorry you lose.");
						if(totalWinnings > currentBet) {
						winnings.setDisable(false);
						totalWinnings = totalWinnings - currentBet;
						winnings.setText("Total Winnings = "+ totalWinnings);
						winnings.setDisable(true);
						}
						else {
							winnings.setDisable(false);
							totalWinnings = 0;
							winnings.setText("Total Winnings = "+ totalWinnings);
							winnings.setDisable(true);
						}
				}
					else if(betstatus == 3) {
						outCome.setText("Player scored a Natural. Player Won. Unfourtnatley you chose tie.Sorry you lose.");
						if(totalWinnings > currentBet) {
							winnings.setDisable(false);
							totalWinnings = totalWinnings - currentBet;
							winnings.setText("Total Winnings = "+ totalWinnings);
						winnings.setDisable(true);
						}
						else {
							winnings.setDisable(false);
							totalWinnings = 0;
							winnings.setText("Total Winnings = "+ totalWinnings);
							winnings.setDisable(true);
						}
				}
				}
				if((bankTotal == 8 || bankTotal == 9) && (playerTotal == 8 || playerTotal == 9)) {
					
					if(betstatus == 3) {
						outCome.setText("Banker and player scored a Natural. It's a tie. Congrats you bet on a tie.");
						winnings.setDisable(false);
						totalWinnings = (currentBet * 8) + (totalWinnings);
						winnings.setText("Total Winnings = "+ totalWinnings);
						winnings.setDisable(true);
					}
					else if(betstatus == 1) {
						outCome.setText("Banker and player scored a Natural. It's a tie. Unfourtnatley you chose dealer.Sorry you lose.");
						if(totalWinnings > currentBet) {
						winnings.setDisable(false);
						totalWinnings = totalWinnings - currentBet;
						winnings.setText("Total Winnings = "+ totalWinnings);
						winnings.setDisable(true);
						}
						else {
							winnings.setDisable(false);
							totalWinnings = 0;
							winnings.setText("Total Winnings = "+ totalWinnings);
							winnings.setDisable(true);
						}
				}
		
					else if(betstatus == 2) {
						outCome.setText("Banker and player scored a Natural. It's a tie. Unfourtnatley you chose banker.Sorry you lose.");
						if(totalWinnings > currentBet) {
							winnings.setDisable(false);
							totalWinnings = totalWinnings - currentBet;
							winnings.setText("Total Winnings = "+ totalWinnings);
						winnings.setDisable(true);
						}
						else {
							winnings.setDisable(false);
							totalWinnings = 0;
							winnings.setText("Total Winnings = "+ totalWinnings);
							winnings.setDisable(true);
						}
				}
				}
			}
				else{
				//determines draws
				playerDraw = gameLogic.evaluatePlayerDraw(playerHand);
				if(playerDraw = true) {
					Bdeck.drawOne(playerHand);
					playerTotal = gameLogic.handTotal(playerHand);
					for(Card c:playerHand) {
						drawnCard = c.getValue();
						
					}
				}
					if(playerDraw = false) {
						if(bankTotal <= 5) {
							Bdeck.drawOne(bankerHand);
							bankTotal = gameLogic.handTotal(bankerHand);
						}
					}
					if(playerDraw = true) {
					dealerDraw = gameLogic.evaluateBankerDraw(bankerHand, drawnCard);
					if(dealerDraw = true) {
						Bdeck.drawOne(bankerHand);
						bankTotal = gameLogic.handTotal(bankerHand);

					}
					}
				
					whoWon = gameLogic.whoWon(playerHand,bankerHand);
					if(whoWon == "Player Won") {
						if(betstatus == 1) {
							outCome.setText("Player: " + playerTotal + "Dealer: " + bankTotal + "Player Won. Congrats you bet on player.");
							winnings.setDisable(false);
							totalWinnings = currentBet + totalWinnings;
							winnings.setText("Total Winnings = "+ totalWinnings);
							winnings.setDisable(true);
						}
						else if(betstatus == 2) {
							outCome.setText("Player: " + playerTotal + "Dealer: " + bankTotal + "Unfourtnatley you chose Dealer.Sorry you lose.");
							if(totalWinnings > currentBet) {
							winnings.setDisable(false);
							totalWinnings = totalWinnings - currentBet;
							winnings.setText("Total Winnings = "+ totalWinnings);
							winnings.setDisable(true);
							}
							else {
								winnings.setDisable(false);
								totalWinnings = 0;
								winnings.setText("Total Winnings = "+ totalWinnings);
								winnings.setDisable(true);
							}
					}
						else if(betstatus == 3) {
							outCome.setText("Player: " + playerTotal + "Dealer: " + bankTotal + "Unfourtnatley you chose Tie.Sorry you lose.");
							if(totalWinnings > currentBet) {
								winnings.setDisable(false);
								totalWinnings = totalWinnings - currentBet;
								winnings.setText("Total Winnings = "+ totalWinnings);
							winnings.setDisable(true);
							}
							else {
								winnings.setDisable(false);
								totalWinnings = 0;
								winnings.setText("Total Winnings = "+ totalWinnings);
								winnings.setDisable(true);
							}
					}
					}
						
					if(whoWon == "Dealer Won") {
						if(betstatus == 2) {
							outCome.setText("Player: " + playerTotal + "Dealer: " + bankTotal + "Dealer Won. Congrats you bet on Dealer.");
							winnings.setDisable(false);
							totalWinnings = (currentBet*.95) + totalWinnings;
							winnings.setText("Total Winnings = "+ totalWinnings);
							winnings.setDisable(true);
						}
						else if(betstatus == 1) {
							outCome.setText("Player: " + playerTotal + "Dealer: " + bankTotal + "Dealer wins. Unfourtnatley you chose Player.Sorry you lose.");
							if(totalWinnings > currentBet) {
							winnings.setDisable(false);
							totalWinnings = totalWinnings - currentBet;
							winnings.setText("Total Winnings = "+ totalWinnings);
							winnings.setDisable(true);
							}
							else {
								winnings.setDisable(false);
								totalWinnings = 0;
								winnings.setText("Total Winnings = "+ totalWinnings);
								winnings.setDisable(true);
							}
					}
						else if(betstatus == 3) {
							outCome.setText("Player: " + playerTotal + "Dealer: " + bankTotal + "Dealer wins. Unfourtnatley you chose Tie.Sorry you lose.");
							if(totalWinnings > currentBet) {
								winnings.setDisable(false);
								totalWinnings = totalWinnings - currentBet;
								winnings.setText("Total Winnings = "+ totalWinnings);
							winnings.setDisable(true);
							}
							else {
								winnings.setDisable(false);
								totalWinnings = 0;
								winnings.setText("Total Winnings = "+ totalWinnings);
								winnings.setDisable(true);
							}
					}
					}
					if(whoWon == "Tie") {
						if(betstatus == 3) {
							outCome.setText("Player: " + playerTotal + "Dealer: " + bankTotal + "It's a Tie. Congrats you bet on a Tie.");
							winnings.setDisable(false);
							totalWinnings = (currentBet*8) + totalWinnings;
							winnings.setText("Total Winnings = "+ totalWinnings);
							winnings.setDisable(true);
						}
						else if(betstatus == 2) {
							outCome.setText("Player: " + playerTotal + "Dealer: " + bankTotal + "It's a Tie. Unfourtnatley you chose Dealer.Sorry you lose.");
							if(totalWinnings > currentBet) {
							winnings.setDisable(false);
							totalWinnings = totalWinnings - currentBet;
							winnings.setText("Total Winnings = "+ totalWinnings);
							winnings.setDisable(true);
							}
							else {
								winnings.setDisable(false);
								totalWinnings = 0;
								winnings.setText("Total Winnings = "+ totalWinnings);
								winnings.setDisable(true);
							}
					}
						else if(betstatus == 1) {
							outCome.setText("Player: " + playerTotal + "Dealer: " + bankTotal + "It's a Tie. Unfourtnatley you chose Player.Sorry you lose.");
							if(totalWinnings > currentBet) {
								winnings.setDisable(false);
								totalWinnings = totalWinnings - currentBet;
								winnings.setText("Total Winnings = "+ totalWinnings);
							winnings.setDisable(true);
							}
							else {
								winnings.setDisable(false);
								totalWinnings = 0;
								winnings.setText("Total Winnings = "+ totalWinnings);
								winnings.setDisable(true);
							}
					}
					}
						
					}
				
		
				btn.setDisable(false);
				bidDealer.setDisable(false);
				draw.setDisable(false);
				start.setDisable(true);
				playerHand.clear();
				bankerHand.clear();
				//test total winnings reset
				//System.out.print(totalWinnings);
				

			}
		};
		start.setOnAction(handler4);
		// creates menu for gui
		menu = new MenuBar();
		
		Menu mOne = new Menu("New Game/Exit");

		
		MenuItem iOne = new MenuItem("Fresh Start");
		MenuItem iTwo = new MenuItem("Exit");
		
		//clears total winnings 
		EventHandler<ActionEvent> handler2 = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent action) {
				winnings.setDisable(false);
				totalWinnings = 0;
				winnings.setText("Total Winnings = "+ totalWinnings);
				winnings.setDisable(true);
				btn.setDisable(false);
				bidDealer.setDisable(false);
				draw.setDisable(false);


				//test total winnings reset
				//System.out.print(totalWinnings);
				

			}
		};
		
		iOne.setOnAction(handler2);

		//quits the program
		EventHandler<ActionEvent> handler3 = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent action) {
				System.exit(0);

			}
		};
		iTwo.setOnAction(handler3);
		mOne.getItems().addAll(iOne, iTwo);
		
	//handler for bidding on dealer
		 bidDealer = new Button("Bid on Dealer");
		EventHandler<ActionEvent> dealerHandler = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent action) {
				currentBet = Double.parseDouble(text.getText());
				betstatus = 2;
				btn.setDisable(true);
				bidDealer.setDisable(true);
				draw.setDisable(true);
				start.setDisable(false);


			}
		};
		 draw = new Button("Bid on Tie");
		EventHandler<ActionEvent> tieHandler = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent action) {
				currentBet = Double.parseDouble(text.getText());
				System.out.print(currentBet);
				betstatus = 3;
				btn.setDisable(true);
				bidDealer.setDisable(true);
				draw.setDisable(true);
				start.setDisable(false);
				//}

			}
		};
		
		//Initializes buttons on screen
		bidDealer.setOnAction(dealerHandler);
		draw.setOnAction(tieHandler);
		btn.setOnAction(handler1);
		//int menu
		menu.getMenus().addAll(mOne);
		
		paneCenter = new VBox(20, menu,text, btn,bidDealer,draw,start,outCome,winnings);
		scene = new Scene(paneCenter, 700, 700);
		primaryStage.setScene(scene);
		primaryStage.show();
	}



}


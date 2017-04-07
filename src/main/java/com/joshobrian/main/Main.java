package com.joshobrian.main;

import com.joshobrian.model.*;
import com.joshobrian.services.GameService;
import com.joshobrian.services.PhraseService;

import java.util.Scanner;

/**
 * Created by josh on 4/6/17.
 */
public class Main {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		Prompter prompter = new Prompter(scanner);

		Player player = new Player("Josh",new Bank());
		PhraseService phraseService = new PhraseService();
		Wheel spinWheel = new Wheel();
		Phrase phrase = phraseService.getPhrase();
		GameService gameService = new GameService(phrase);

		 while (true) {
		    try {
		    	prompter.getTitle();
			    System.out.println(gameService.getDisplay());
			    int wager = spinWheel.spin();
				prompter.promptForGame(wager);
			    if (!gameService.isInPhrase(prompter.guess())) {
				    player.getBank().removeMoney(wager);
			    }else{
			    	player.getBank().addMoney(wager);
			    }
				prompter.showCurrentStatus(gameService.getIncorrectCount(), gameService.getGuessCount(),player.getBank().getMoney());

			    if (gameService.isGameOver()||player.getBank().isBankEmpty()) {
			    	GameResults results = new GameResults(gameService.getId(),player.getId(),phrase.getId(),player.getBank().isBankEmpty());
			    	if(!player.getBank().isBankEmpty()){
			    		player.setWin();
					    System.out.printf("Won: %s Games%n");
					    phrase = phraseService.getPhrase();

					    gameService = new GameService(phrase);
				    }else{
					    System.out.printf("%n%nSorry the phrase was: %s", gameService.getPhrase());
					    break;
				    }
			    }
		    }catch (Exception e){
			    System.out.println(e.getMessage());
		    }

		 }
	}
}

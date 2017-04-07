package com.joshobrian.services;

import com.joshobrian.contoller.GameRepository;
import com.joshobrian.model.GameResults;
import com.joshobrian.model.Phrase;

import java.sql.SQLException;

/**
 * Created by josh on 4/6/17.
 */
public class GameService {
	private Integer id;
	public final Phrase phrase;
	private String correctGuesses;
	private String incorrectGuesses;
	private GameRepository repository;

	public GameService(Phrase phrase) throws Exception {
		this.phrase = phrase;
		this.correctGuesses = "";
		this.incorrectGuesses = "";
		//loadGame();
		//logGame();
	}

	public boolean isInPhrase(char guess){
		boolean isInPhrase = false;
		String answer = phrase.getPhrase();
		if(answer.indexOf(guess) == -1){
			incorrectGuesses += guess;
		}else{
			correctGuesses += guess;
			isInPhrase = true;
		}
		return isInPhrase;
	}

	public String getDisplay(){
		String display ="";
		for(char letter: phrase.getPhrase().toCharArray()){
			if(letter == ' '){
				display+= letter;
			}else if(correctGuesses.indexOf(letter) != -1){
				display += letter;
			}else{
				display+= "-";
			}
		}
		return display;
	}
	public int getGuessCount(){
		return this.incorrectGuesses.length() + this.correctGuesses.length();
	}
	public int getIncorrectCount(){
		return this.incorrectGuesses.length();
	}

	public boolean isGameOver(){
		String correctGuess = "";
		boolean isGame = false;
		for(char letter : phrase.getPhrase().toCharArray()){
			if(this.correctGuesses.indexOf(letter) != -1){
				correctGuess += letter;
			}
			if(letter == ' '){
				correctGuess += letter;
			}
		}
		if(correctGuess.equals(this.phrase)){
			isGame =true;
		}
		return isGame;
	}

	public String getPhrase(){
		return this.phrase.getPhrase();
	}

	private void loadGame(){
		this.repository = new GameRepository("jdbc:postgresql://localhost:5432/wheelophases");
	}

	private void logGame() throws Exception {
		this.id = repository.startGame(phrase);
	}

	public Integer getId() {
		return id;
	}


}

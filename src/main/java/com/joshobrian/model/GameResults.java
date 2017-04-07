package com.joshobrian.model;

/**
 * Created by josh on 4/6/17.
 */
public class GameResults {
	private Integer gameID;
	private Integer playerID;
	private Integer PhaseID;
	private boolean isWinner;

	public GameResults(Integer gameID, Integer playerID, Integer phaseID, boolean isWinner) {
		this.gameID = gameID;
		this.playerID = playerID;
		this.PhaseID = phaseID;
		this.isWinner = isWinner;
	}

	public Integer getGameID() {
		return gameID;
	}

	public Integer getPlayerID() {
		return playerID;
	}

	public Integer getPhaseID() {
		return PhaseID;
	}

	public boolean isWinner() {
		return isWinner;
	}
}

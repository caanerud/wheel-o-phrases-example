package com.joshobrian.model;

/**
 * Created by josh on 4/6/17.
 */
public class Player {
	private int id;
	private String name;
	private Integer winCount;
	private Integer loseCount;
	private Bank bank;

	public Player() {
	}

	public Player(String name, Bank bank) {
		this.name = name;
		this.bank = bank;
	}

	public Player(int id, String name, Integer winCount, Integer loseCount, Bank bank) {
		this.id = id;
		this.name = name;
		this.winCount = winCount;
		this.loseCount = loseCount;
		this.bank = bank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getWinCount() {
		return winCount;
	}

	public void setWin() {
		this.winCount += winCount;
	}

	public Integer getLoseCount() {
		return loseCount;
	}

	public void setLoseCount(Integer loseCount) {
		this.loseCount = loseCount;
	}

	public Bank getBank() {
		return bank;
	}

	public int getId() {
		return id;
	}
}

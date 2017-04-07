package com.joshobrian.model;

/**
 * Created by josh on 4/6/17.
 */
public class Bank {
	private Integer money;

	public Bank(){
		this.money = 1000;
	}
	public Bank(Integer money){
		this.money = money;
	}

	public Integer getMoney() {
		return this.money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}
	public void addMoney(Integer amount){
		this.money += amount;
	}

	public void removeMoney(Integer amount) throws Exception {
		if(amount == 0){
			this.money = 0;
		}else {
			isBankEmpty();
			this.money -= amount;
		}
	}

	public boolean isBankEmpty()throws Exception{
		boolean isEmpty = false;
		if(this.money < 0){
			throw new Exception("All out of money please buy more");
		}else if(this.money == 0){
			isEmpty = true;
		}
		return isEmpty;
	}
}

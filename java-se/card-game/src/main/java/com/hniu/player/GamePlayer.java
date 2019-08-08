package com.hniu.player;

import java.util.ArrayList;
import java.util.List;

import com.hniu.card.entity.Card;

/**
 * @author Administrator
 *
 */
public class GamePlayer {
	private String name;
	private int balance;
	private List<Card> list;

	public GamePlayer(String name, int balance) {
		super();
		this.name = name;
		this.balance = balance;
		this.list = new ArrayList<Card>();
	}

	public List<Card> getList() {
		return list;
	}

	public void setList(Card card) {
		list.add(card);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "玩家：" + name + "  金额：" + balance;
	}

}

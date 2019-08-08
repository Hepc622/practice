package com.hniu.card.game.factory;

import com.hniu.card.entity.Card;

public class CardFactory {
	// 定义工厂对象
	CardFactory cardFactory;
	// 定义一个card数组用来存储52个牌对象
	private static Card[] card;
	// 定义牌的点数
	private static String[] points = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
	// 定义牌的花色
	private static String[] drawing = { "♠", "♥", "♣", "♦" };

	// 单例模式
	private CardFactory() {
		cardFactory = new CardFactory();
	}

	/**
	 * 生产52张牌对象，以数组的形式返回<br>
	 * 	@return Card[]
	 */
	public static Card[] productionCard() {
		card = new Card[52];
		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < drawing.length; j++) {
				card[i * 4 + j] = new Card(points[i], drawing[j]);
			}
		}
		return card;
	}
}

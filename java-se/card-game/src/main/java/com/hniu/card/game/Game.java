package com.hniu.card.game;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.hniu.card.entity.Card;
import com.hniu.card.game.factory.CardFactory;
import com.hniu.card.game.gameinterface.GameRoomImp;
import com.hniu.player.GamePlayer;

public class Game implements GameRoomImp {
	private static Card[] cards;
	private Random random;

	@Override
	public void takeCards() {
		// 创建一个随机对象
		random = new Random();

		// 取一副牌出来
		cards = CardFactory.productionCard();
	}

	@Override
	public void shuffle() {
		// 洗牌
		for (int i = 0; i < cards.length; i++) {
			int index = (int) (random.nextInt(cards.length));
			Card tmp = cards[index];
			cards[index] = cards[i];
			cards[i] = tmp;
		}
	}

	@Override
	public void deal(List<GamePlayer> list, int numCard, int whom) {
		// 发牌
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < numCard; j++) {
				if (whom == i) {
					int num = 0;
					for (int k = cards.length - 1; k > 0; k--) {
						Card card = cards[k];
						if (card.getPoints().equals("A") && card.getDrawing().equals("♠")) {
							list.get(i).setList(cards[k]);
							num++;
						} else {
							if (card.getDrawing().equals("♠")) {
								list.get(i).setList(cards[k]);
								num++;
							}
						}
						if (num == numCard)
							break;
					}
					break;
				} else {
					list.get(i).setList(cards[i * numCard + j]);
				}
			}

			System.out.println(list.get(i).toString());
			Iterator<Card> iterator = list.get(i).getList().iterator();
			while (iterator.hasNext()) {
				iterator.next().showCard();
			}
		}
	}

}

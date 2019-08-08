package com.hniu.card.game;

import java.util.ArrayList;
import java.util.List;

import com.hniu.card.game.gameinterface.GameRoomImp;
import com.hniu.player.GamePlayer;

public class GameRoom {

	private static Game game;
	private static List<GamePlayer> list;

	public static void main(String[] args) {
		// 初始化list集合
		list = new ArrayList<GamePlayer>();

		// 初始化游戏
		game = new Game();

		// 初始化玩家
		list.add(new GamePlayer("张三", 3000));
		list.add(new GamePlayer("李四", 3000));
		list.add(new GamePlayer("王五", 3000));

		// 取牌
		game.takeCards();

		// 洗牌
		game.shuffle();

		// 发牌
		game.deal(list, GameRoomImp.THREECARD,GameRoomImp.ZERO);
	}

}

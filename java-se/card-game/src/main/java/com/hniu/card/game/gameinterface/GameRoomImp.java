package com.hniu.card.game.gameinterface;

import java.util.List;

import com.hniu.player.GamePlayer;

public interface GameRoomImp {
	/**
	 * THREECARD 炸金花
	 */
	public static final int THREECARD = 3;
	/**
	 * FIVECARD 斗牛
	 */
	public static final int FIVECARD = 5;
	/**
	 * zero 为不发特殊牌
	 */
	public static final int ZERO = 0;
	public static final int ONE = 1;
	public static final int TWO = 2;
	public static final int THREE = 3;
	public static final int FOUR = 4;
	public static final int FIVE = 5;
	public static final int SIX = 6;

	/**
	 * 取出从工厂一副牌
	 */
	public void takeCards();

	/**
	 * 洗牌<br>
	 * shuffle
	 */
	public void shuffle();

	/**
	 * 发牌
	 * 
	 * @param person
	 *            玩家人数
	 * @param numCard
	 *            玩牌类型
	 * @param whom
	 *            给谁发特殊牌 0为不发特殊牌，其他按照发牌顺序数
	 */
	public void deal(List<GamePlayer> person, int numCard, int whom);

}

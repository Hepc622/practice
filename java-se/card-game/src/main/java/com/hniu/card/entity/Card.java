package com.hniu.card.entity;

public class Card {

	private String points; // 牌的点数
	private String drawing; // 牌的图形

	public Card(String points, String drawing) {
		this.points = points;
		this.drawing = drawing;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public String getDrawing() {
		return drawing;
	}

	public void setDrawing(String drawing) {
		this.drawing = drawing;
	}

	public void showCard() {
		if (points == "10") {
			System.out.print("......\r." + points + "  .\r." + drawing + "   .\r......\r");
		} else {
			System.out.print("......\r." + points + "   .\r." + drawing + "   .\r......\r");
		}
	}

}

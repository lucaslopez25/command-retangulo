package main;

public class Rectangle {
	
	private String currentColor = "";
	private int xAxis = 0;
	private int yAxis = 0;
	
	public Rectangle (int x, int y, String userColor) {
		currentColor = userColor;
		xAxis = x;
		yAxis = y;
	}
	
	public Rectangle (Rectangle r) {
		currentColor = r.getCurrentColor();
		xAxis = r.getXAxis();
		yAxis = r.getYAxis();
	}

	public String getCurrentColor() {
		return currentColor;
	}

	public void setCurrentColor(String currentColor) {
		this.currentColor = currentColor;
	}

	public int getXAxis() {
		return xAxis;
	}

	public void setXAxis(int xAxis) {
		this.xAxis = xAxis;
	}

	public int getYAxis() {
		return yAxis;
	}

	public void setYAxis(int yAxis) {
		this.yAxis = yAxis;
	}
}

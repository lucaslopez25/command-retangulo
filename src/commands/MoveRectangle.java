package commands;

import interfaces.ICommand;
import main.Rectangle;

public class MoveRectangle implements ICommand {
	private int newX;
	private int newY;
	private int oldX;
	private int oldY;
	private Rectangle storedRectangle;
	
	public MoveRectangle (Rectangle userRectangle, int x, int y) {
		storedRectangle = userRectangle;
		oldX = userRectangle.getXAxis();
		oldY = userRectangle.getYAxis();
		newX = x;
		newY = y;
	}

	@Override
	public Rectangle undo() {
		storedRectangle.setXAxis(oldX);
		storedRectangle.setYAxis(oldY);
		
		return storedRectangle;
	}

	@Override
	public Rectangle redo() {
		storedRectangle.setXAxis(newX);
		storedRectangle.setYAxis(newY);
		
		return storedRectangle;
	}
	
	@Override
	public String getStatus() {
		return "Move Rectangle from " + oldX + ", " + oldY + " to " + newX + ", " + newY;
	}

}

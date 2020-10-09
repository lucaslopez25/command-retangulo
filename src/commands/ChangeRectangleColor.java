package commands;

import interfaces.ICommand;
import main.Rectangle;

public class ChangeRectangleColor implements ICommand {
	private String oldColor;
	private String newColor;
	private Rectangle storedRectangle;
	
	public ChangeRectangleColor (Rectangle userRectangle, String userColor) {
		oldColor = userRectangle.getCurrentColor();
		storedRectangle = userRectangle;
		newColor = userColor;
	}
	
	
	@Override
	public Rectangle undo() {
		storedRectangle.setCurrentColor(oldColor);
		
		return storedRectangle;
	}

	@Override
	public Rectangle redo() {
		storedRectangle.setCurrentColor(newColor);
		
		return storedRectangle;
	}
	
}

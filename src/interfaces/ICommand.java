package interfaces;

import main.Rectangle;

public interface ICommand {
	public Rectangle undo();
	public Rectangle redo();
	public String getStatus();
}

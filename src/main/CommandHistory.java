package main;

import java.util.ArrayList;
import interfaces.ICommand;

public class CommandHistory {
	private ArrayList<ICommand> history = new ArrayList<ICommand>();
	private int lastExecuted = -1;
	
	public void add(ICommand command) {
		if (lastExecuted != history.size() - 1) history.subList(lastExecuted + 1, history.size()).clear();
		
		history.add(command);
		command.redo();
		lastExecuted = history.size() - 1;
	}
	
	public Rectangle moveBack () throws Exception {
		if (lastExecuted >= 0) {
			return history.get(lastExecuted - 1).undo();
		}
		else throw new Exception ("Hey! There is no previous command.");
	}
	
	public Rectangle moveForward() throws Exception {
		if (lastExecuted < history.size() - 1) {
			return history.get(lastExecuted + 1).redo();
		}
		else throw new Exception ("Hey! There is no next command.");
	}

}

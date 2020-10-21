package main;

import java.util.ArrayList;
import interfaces.ICommand;

public class CommandHistory {
	private ArrayList<ICommand> history = new ArrayList<ICommand>();
	private int lastExecuted = -1;
	
	public void add(ICommand command) {
		if (lastExecuted != history.size()-1) history.subList(lastExecuted + 1, history.size()).clear();
		
		history.add(command);
		command.redo();
		lastExecuted = history.size()-1;
	}
	
	public Rectangle moveBack () throws Exception {
		if (lastExecuted >= 0) {
			return history.get(lastExecuted - 1).undo();
		}
		else throw new Exception ("Hey! There is no previous command.");
	}
	
	public Rectangle moveForward() throws Exception {
		if (lastExecuted < history.size()-1) {
			return history.get(lastExecuted + 1).redo();
		}
		else throw new Exception ("Hey! There is no next command.");
	}
	
	public boolean hasItems() {
		if (history.size() > 0) return true;
		else return false;
	}
	
	public void getStatus() {
		for (int i = 0 ; i < history.size() ; i++) {
			int iTemp = i + 1;
			String tempString = iTemp + " - " + history.get(i).getStatus();
			System.out.println(tempString);
		}
		int leTemp = lastExecuted + 1;
		System.out.println("Your position is: " + leTemp);
	}

}

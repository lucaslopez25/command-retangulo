package main;

import java.util.Scanner;

import commands.MoveRectangle;
import commands.ChangeRectangleColor;

public class Main {
	
	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle(0,0, "black");
		Scanner scanner = new Scanner(System.in);
		CommandHistory commandHistory = new CommandHistory();
		
		int status = 0;
		//starting rectangle
		System.out.println("Welcome to Rectangle Command! Have a nice day!\n\n\n");
		//moving rectangle
		do {
			System.out.println("OPTIONS MENU\n");

			System.out.println("0 - Quit");
			System.out.println("1 - Move the rectangle");
			System.out.println("2 - Color the rectangle");
			System.out.println("3 - Undo previous operation");
			System.out.println("4 - Redo subsequent operation\n");
			
			if (commandHistory.hasItems()) {
				System.out.println("HISTORIC");
				commandHistory.getStatus();
			}

			System.out.println("\nRectangle status:\n");
			System.out.println("Rectangle color: " + rectangle.getCurrentColor());
			System.out.println("Rectangle position: " + rectangle.getXAxis() + ", " + rectangle.getYAxis() + "\n");
			
			System.out.println("User input:");
			status = Integer.parseInt(scanner.nextLine());
			
			switch (status) {
			case 0:
				System.out.println("Quitting...");
				break;
			case 1:
				System.out.println("Please type the new X/Y position of the rectangle (like \"x, y\"): ");
				String userInput = scanner.nextLine();
				String [] splittedUserInput = userInput.split(",");
				
				int tempX = Integer.parseInt(splittedUserInput[0].trim());
				int tempY = Integer.parseInt(splittedUserInput[1].trim());
				
				commandHistory.add(new MoveRectangle(new Rectangle(rectangle), tempX, tempY));
				
				rectangle.setXAxis(tempX);
				rectangle.setYAxis(tempY);
				break;
			case 2:
				System.out.println("Please type in the new color of the rectangle: ");
				String tempColor = scanner.nextLine();
			
				commandHistory.add(new ChangeRectangleColor(new Rectangle(rectangle), tempColor));
				
				rectangle.setCurrentColor(tempColor);
				break;
			case 3:
				System.out.println("Un-doing...");
				try {
					rectangle = commandHistory.moveBack();
				}
				catch (Exception e) {
					System.out.println("I can't move backwards! Sorry :(");
				}
				break;
			case 4:
				System.out.println("Re-doing...");
				try {
					rectangle = commandHistory.moveForward();
				}
				catch (Exception e) {
					System.out.println("I can't move forwards! Sorry :(");
				}
				break;
			}
			System.out.println("");
			
		} while (status != 0);
		
		scanner.close();
	}

}

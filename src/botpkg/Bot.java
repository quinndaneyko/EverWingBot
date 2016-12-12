package botpkg;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class Bot {
	static boolean keepPlaying;
	public static void main(String[] args) throws AWTException {
		Robot robot = new Robot();
		playGame(robot);

	}
	
	public static void playGame(Robot robot) {
		int leftCoord = 260;
		int rightCoord = 640;
		int yCoord = 900;
		
		robot.mousePress(InputEvent.BUTTON1_MASK);
		while (!checkForNewGame(robot)){ 
		    robot.mouseMove(leftCoord, yCoord);
		    try {Thread.sleep(700); } catch (Exception e) {}
		    robot.mouseMove(rightCoord, yCoord);
		    try {Thread.sleep(700); } catch (Exception e) {}
		}
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		restart(robot);
	}
	
	public static void restart(Robot robot) {
		
		//Some time to terminate Bot between games
		System.out.println("Termination Period: Started");
	    try {Thread.sleep(5000); } catch (Exception e) {}
	    System.out.println("Termination Period: Ended\n\nGame Started");
	    
		//Play Again Button Click
		robot.mouseMove(350, 930);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		try {Thread.sleep(100); } catch (Exception e) {}
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
	    
		//Level Up Button Click
		robot.mouseMove(420, 700);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		try {Thread.sleep(100); } catch (Exception e) {}
		robot.mouseRelease(InputEvent.BUTTON1_MASK);		
	    
		playGame(robot);
	}
	
	//TODO: Read multiple points on play again to ensure match.
	public static boolean checkForNewGame(Robot robot) {
		Color levelUpColor = robot.getPixelColor(420, 700);
		Color playAgainColor = robot.getPixelColor(350, 930);
		if ((levelUpColor.getRed() == 95 && levelUpColor.getGreen() == 229 && levelUpColor.getBlue() == 1) ||
			playAgainColor.getRed() == 64 && playAgainColor.getGreen() == 128 && playAgainColor.getBlue() == 255) {
			System.out.println("Game Has Ended\n");
			return true;
		}
		return false;
	}

}

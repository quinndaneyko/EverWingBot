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

		// Move the cursor
		Color color = robot.getPixelColor(350, 930);
		robot.mouseMove(450, 930);
		robot.mousePress(InputEvent.BUTTON1_MASK);

		while (color.getRed() != 64 && color.getGreen() != 128 && color.getBlue() != 255){ 
		    robot.mouseMove(leftCoord, yCoord);
		    try {Thread.sleep(700); } catch (Exception e) {}
		    robot.mouseMove(rightCoord, yCoord);
		    try {Thread.sleep(700); } catch (Exception e) {}
		    color = robot.getPixelColor(350, 930);
		}
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		restart(robot);
	}
	
	public static void restart(Robot robot) {
		robot.mouseMove(350, 930);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		try {Thread.sleep(100); } catch (Exception e) {}
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
	    try {Thread.sleep(3000); } catch (Exception e) {}
		playGame(robot);
	}

}

import java.util.Scanner;

/**
 * Homework for Week 1. Task: write a program, calculating the number of rolls of wallpapers for a room of given
 * dimensions (doors and windows not considered). Calculations are done in meters.
 *
 * @author Aleksei Litvinov
 */
public class Main {
	public static void main(String[] args) {
		//Rooms may have not ideal dimensions - using floating point numbers
		//Default values
		double roomWidth = 3.0;
		double roomLength = 5.5;
		double roomHeight = 2.7;
		double shiftPattern = 0.15;
		double wallpaperWidth = 1.06;

		//Uncomment these lines for additional interactivity
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("Please enter the room width in meters: ");
//		roomWidth = Double.parseDouble(scanner.next());
//		System.out.print("Please enter the room length in meters: ");
//		roomLength = Double.parseDouble(scanner.next());
//		System.out.print("Please enter the heights of the ceiling in meters: ");
//		roomHeight = Double.parseDouble(scanner.next());
//		System.out.print("If the wallpaper has pattern (rapport) shift, please enter the enter the value of the shift" +
//				" in cm, or enter 0 otherwise: ");
//		shiftPattern = Double.parseDouble(scanner.next()) / 100; //adjusting to meters

		double roomPerimeter = (roomWidth + roomLength) * 2;
		int stripsNeeded = (int) Math.ceil(roomPerimeter / wallpaperWidth);

		double stripLength = roomHeight + 0.1 + shiftPattern;
		int stripsInRoll = (int) (10 / stripLength);

		int rollsNeeded = (stripsNeeded +  stripsInRoll - 1) / stripsInRoll; //A mathematical hack instead of ceil()
		System.out.println("You would need " + rollsNeeded + " rolls of selected wallpapers");

	}
}

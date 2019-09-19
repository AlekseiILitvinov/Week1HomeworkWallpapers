import java.util.Scanner;

/**
 * Homework for Week 1. Task: write a program, calculating the number of rolls of wallpapers for a room of given
 * dimensions (doors and windows not considered). Calculations are done in meters, some of the user input is taken in
 * cm, but it is converted to meters.
 *
 * @author Aleksei Litvinov
 */
public class Main {
	public static void main(String[] args) {
		double roomWidth;
		double roomLength;
		double roomHeight;
		double shiftPattern;
		double patternSize;
		double wallpaperWidth = 1.06;
		double padding = 0.1;
		double rollLength = 10.0;
		double minPatternSize = 0.01;

		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter the room width in meters: ");
		roomWidth = Double.parseDouble(scanner.next());
		System.out.print("Please enter the room length in meters: ");
		roomLength = Double.parseDouble(scanner.next());
		System.out.print("Please enter the heights of the ceiling in meters: ");
		roomHeight = Double.parseDouble(scanner.next());
		System.out.print("Please enter the pattern (rapport)size in cm (enter 0 if  pattern matching is not needed): ");
		patternSize = Double.parseDouble(scanner.next()) / 100;
		System.out.print("If the wallpaper has pattern (rapport) shift, please enter the enter the value of the shift" +
				" in cm, or enter 0 otherwise: ");
		shiftPattern = Double.parseDouble(scanner.next()) / 100;

		double roomPerimeter = (roomWidth + roomLength) * 2;
		int stripsNeeded = (int) Math.ceil(roomPerimeter / wallpaperWidth);

		double stripLength = roomHeight + padding;
		if (patternSize >= minPatternSize) {
			stripLength = Math.ceil(stripLength / patternSize) * patternSize + shiftPattern + padding;
		}
		int stripsInRoll = (int) (rollLength / stripLength);

		int rollsNeeded = (stripsNeeded + stripsInRoll - 1) / stripsInRoll;
		System.out.println("You would need " + rollsNeeded + " rolls of selected wallpapers");

	}
}

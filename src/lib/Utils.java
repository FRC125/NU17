package lib;

public class Utils {
	
	/**
	 * Gets rid of minuscule unwanted input and only returns user input.
	 * 
	 * @param value number to check
	 * @param deadband how much is a minuscule amount
	 * @param center 	how much joystick is broken, displacement from center
	 * @return value for user to use in the case that joystick was intended to move
	 */
	public static double deadband(double value, double deadband, double center){
		return (value < (center + deadband) && value > (center - deadband)) ? center : value;
	}
}

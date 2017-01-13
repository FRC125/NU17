package com.nutrons.nu17;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//PWM
	public static final int SHOOTER = 0;
	public static final int ROLLER_A = 1;
	public static final int ROLLER_B = 2;
	public static final int DRIVE_LEFT_A = 0;
	public static final int DRIVE_LEFT_B = 1;
	public static final int DRIVE_RIGHT_A = 0; 
	public static final int DRIVE_RIGHT_B = 3;
	
	//Analog
	public static final int ULTRASONIC_RX = 0;
	public static final int ULTRASONIC_TX = 1;
	
	
	
}

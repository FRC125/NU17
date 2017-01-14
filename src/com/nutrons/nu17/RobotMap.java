package com.nutrons.nu17;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	// Ports of wheels
	public static final int FRONT_LEFT = 0;
	public static final int FRONT_RIGHT = 1;
	public static final int BACK_LEFT = 2;
	public static final int BACK_RIGHT = 3;
	
	// Port of gyro
	public static final int GYRO = 0;
	
	// Port of gear placer
	public static final int PLACER = 0;
	
	// 
	public static final double PLACER_MAX_POSITION = 1;

	// PWM
	public static final int SHOOTER = 0;
	public static final int ROLLER_A = 1;
	public static final int ROLLER_B = 2;
	public static final int DRIVE_LEFT_A = 0;
	public static final int DRIVE_LEFT_B = 1;
	public static final int DRIVE_RIGHT_A = 0; 
	public static final int DRIVE_RIGHT_B = 3;
	
	// Analogs
	public static final int ULTRASONIC_RX = 0;
	public static final int ULTRASONIC_TX = 1;
	
	// PID constants of drive train
	public static final double P_DRIVE = 0;
	public static final double I_DRIVE = 0;
	public static final double D_DRIVE = 0;
	
	// PID constants of gyro
	public static final double P_HEADING = 0;
	public static final double I_HEADING = 0;
	public static final double D_HEADING = 0;
	
	
	
	
}

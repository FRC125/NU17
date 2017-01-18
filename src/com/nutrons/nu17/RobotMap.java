package com.nutrons.nu17;

public class RobotMap {

	// Ports of wheels
	public static final int FRONT_LEFT = 0;
	public static final int	BACK_LEFT = 1;
	public static final int FRONT_RIGHT = 2;
	public static final int BACK_RIGHT = 3;
	
	// Ports of intake
	public static final int ROLLER_A = 0;
	public static final int ROLLER_B = 0;
	
	// Ports of fly wheels
	public static final int FLY_WHEEL_R = 0;
	public static final int FLY_WHEEL_L = 0;
	
	// Ports of Ultrasonics
	public static final int ULTRASONIC_RX = 0;
	public static final int ULTRASONIC_TX = 1;

	// Port of gyro
	public static final int HEADING_GYRO = 0;

	// Port of gear placer
	public static final int PLACER = 0;
	
	// Port of shooter
	public static final int SHOOTER = 0;
	
	// Port of climber
	public static final int CLIMBER = 0;
	
	// Port of micro switch
	public static final int MICRO_SWITCH = 0;

	// Ports of encoders
	public static final int DRIVE_DISTANCE_ENCODER_PORT_1 = 1;
	public static final int DRIVE_DISTANCE_ENCODER_PORT_2 = 2;
	public static final int FLY_ENCODER_FRONT_RIGHT = 5;
	public static final int FLY_ENCODER_BACK_RIGHT = 6;
	public static final int FLY_ENCODER_FRONT_LEFT = 7;
	public static final int FLY_ENCODER_BACK_LEFT = 8;
	public static final int TWIN_A_ENCODER_PORT_1 = 9;
	public static final int TWIN_A_ENCODER_PORT_2 = 10;
	public static final int TWIN_B_ENCODER_PORT_1 = 11;
	public static final int TWIN_B_ENCODER_PORT_2 = 12;
	public static final int SHOOT_ENCODER_PORT_1 = 0;
	public static final int SHOOT_ENCODER_PORT_2 = 1;
	
		
	// Port of joysticks
	public static final int JOYSTICK1 = 0;
	public static final int JOYSTICK2 = 1;

	// Buttons
	public static final int JOYSTICK_A = 0;
	public static final int JOYSTICK_B = 1;
	public static final int JOYSTICK_X = 2;
	public static final int JOYSTICK_Y = 3;
	public static final int JOYSTICK_LEFT_BUMPER = 4;
	
	// TODO tune this constant for deadband
	public static final double JOYSTICK_DEADBAND = 0.05;
}

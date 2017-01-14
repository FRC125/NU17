package com.nutrons.nu17;

import edu.wpi.first.wpilibj.DigitalSource;

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

	// Ports of encoders
	public static final int ENCODERA1 = 1;
	public static final int ENCODERA2 = 2;
	public static final int ENCODERB1 = 3;
	public static final int ENCODERB2 = 4;
	public static final int ENCODER_FLY_R = 5;
	public static final int ENCODER_FLY_L = 6;
	
	// Port of climber
	public static final int CLIMBER = 0;

	// Max position for Gear Placer
	public static final double PLACER_MAX_POSITION = 1;

	// PWM
	public static final int SHOOTER = 0;
	public static final int ROLLER_A = 1;
	public static final int ROLLER_B = 2;
	public static final int TWIN_A = 3;
	public static final int TWIN_B = 4;
	public static final int ENCODER_A = 5;
	public static final int ENCODER_B = 6;
	public static final int FLY_WHEEL_L = 7;
	public static final int FLY_WHEEL_R = 8;

	// Can
	public static final int DRIVE_LEFT_A = 0;
	public static final int DRIVE_LEFT_B = 1;
	public static final int DRIVE_RIGHT_A = 0;
	public static final int DRIVE_RIGHT_B = 3;

	// Analogs
	public static final int ULTRASONIC_RX = 0;
	public static final int ULTRASONIC_TX = 1;

	// PID constants of gyro
	public static final double P_HEADING = 0;
	public static final double I_HEADING = 0;
	public static final double D_HEADING = 0;
	// PID constants for Flywheel
	public static final double P_TURN = 0;
	public static final double I_TURN = 0;
	public static final double D_TURN = 0;
}
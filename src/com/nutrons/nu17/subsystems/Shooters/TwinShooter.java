package com.nutrons.nu17.subsystems.Shooters;

import com.nutrons.nu17.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Subsystem;
import lib.EncoderWrapper;
import lib.HoldPID;

public class TwinShooter extends Subsystem {
	
	private final Shooter TWIN_A = new Shooter();
	private final Shooter TWIN_B = new Shooter();
	private final Encoder ENCODER_1 = new Encoder(
			RobotMap.TWIN_ENCODER_1,
			RobotMap.TWIN_ENCODER_2);
	private final Encoder ENCODER_2 = new Encoder(
			RobotMap.TWIN_ENCODER_3,
			RobotMap.TWIN_ENCODER_4);
	
	// PID Wrappers and Holder Objects
	private EncoderWrapper encWrap1 = new EncoderWrapper(
			PIDSourceType.kDisplacement,
			ENCODER_1,
			RobotMap.TWIN_ENCODER_1,
			RobotMap.TWIN_ENCODER_2);
			
	private HoldPID twinHold1 = new HoldPID();
			
	private EncoderWrapper encWrap2 = new EncoderWrapper(
			PIDSourceType.kDisplacement,
			ENCODER_2,
			RobotMap.TWIN_ENCODER_3,
			RobotMap.TWIN_ENCODER_4);
			
	private HoldPID twinHold2 = new HoldPID();
	
	public TwinShooter() {
		//empty
	}

	// TODO: tune these constants
	private static final double P_SHOOT = 0.025;
	private static final double I_SHOOT = 0.0;
	private static final double D_SHOOT = 0.01;

	public final PIDController SPEED_PID_A = new PIDController(
			P_SHOOT, 
			I_SHOOT, 
			D_SHOOT,
			encWrap1, 
			twinHold1);
	public PIDController SPEED_PID_B = new PIDController(
			P_SHOOT, 
			I_SHOOT, 
			D_SHOOT,
			encWrap2, 
			twinHold2);
	
	
	
	public void initDefaultCommand() {
		//empty
	}

	/**
	 * Runs the first shooting motor to a speed.
	 * 
	 * @param power Speed to run the first shooting motor at.
	 */
	public void runTwinA(double power) {
		TWIN_A.runShooter(power);
	}

	/**
	 * Runs the second shooting motor to a speed
	 * 
	 * @param power Speed to run the second shooting motor at.
	 */
	public void runTwinB(double power) {
		TWIN_B.runShooter(power);
	}

	/**
	 * Runs both shooting motors at the same time to the same speed.
	 * 
	 * @param power Speed to run both shooting motors at.
	 */
	public void twinRun(double power) {
		runTwinA(power);
		runTwinB(power);
	}

	/**
	 * Stops the first shooting motor.
	 */
	public void stopTwinA() {
		TWIN_A.runShooter(0.0);
	}

	/**
	 * Stops the second shooting motor.
	 */
	public void stopTwinB() {
		TWIN_B.runShooter(0.0);
	}

	/**
	 * Stops both shooting motors.
	 */
	public void stopTwins() {
		runTwinA(0.0);
		runTwinB(0.0);
	}

	public void resetEncoderA() {
		TWIN_A.resetEncoder();
	}

	public void resetEncoderB() {
		TWIN_B.resetEncoder();
	}

	public void twinReset() {
		resetEncoderA();
		resetEncoderB();
	}
}

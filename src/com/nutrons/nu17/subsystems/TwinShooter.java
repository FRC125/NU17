package com.nutrons.nu17.subsystems;

import com.nutrons.nu17.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Subsystem;

public class TwinShooter extends Subsystem {
	
	private final Shooter TWIN_A = new Shooter();
	private final Shooter TWIN_B = new Shooter();
	private final Encoder ENCODER_1 = new Encoder(RobotMap.TWIN_ENCODER_1, RobotMap.TWIN_ENCODER_2);
	private final Encoder ENCODER_2 = new Encoder(RobotMap.TWIN_ENCODER_3, RobotMap.TWIN_ENCODER_4);

	public TwinShooter() {
		//empty
	}

	// TODO tune these constants
	private static final double P_SHOOT = 0.025;
	private static final double I_SHOOT = 0.0;
	private static final double D_SHOOT = 0.01;

	public final PIDController SPEED_PID_A = new PIDController(
			P_SHOOT, 
			I_SHOOT, 
			D_SHOOT,
			new EncoderWrapperA(), 
			new HoldShooterOutputA());
	public PIDController SPEED_PID_B = new PIDController(
			P_SHOOT, 
			I_SHOOT, 
			D_SHOOT,
			new EncoderWrapperB(), 
			new HoldShooterOutputB());
	
	private static double holdShootA;
	private static double holdShootB;
	
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

	private class EncoderWrapperA implements PIDSource {
		@Override
		public void setPIDSourceType(PIDSourceType pidSource) {
			//empty
		}

		@Override
		public PIDSourceType getPIDSourceType() {
			return PIDSourceType.kDisplacement;
		}

		@Override
		public double pidGet() {
			return ENCODER_1.getRate();
		}
	}

	private class HoldShooterOutputA implements PIDOutput {

		@Override
		public void pidWrite(double output) {
			holdShootA = output;
		}
	}

	private class EncoderWrapperB implements PIDSource {
		@Override
		public void setPIDSourceType(PIDSourceType pidSource) {
			//empty
		}

		@Override
		public PIDSourceType getPIDSourceType() {
			return PIDSourceType.kDisplacement;
		}

		@Override
		public double pidGet() {
			return ENCODER_2.getRate();
		}
	}

	private class HoldShooterOutputB implements PIDOutput {
		@Override
		public void pidWrite(double output) {
			holdShootB = output;
		}
	}
}

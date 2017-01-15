package com.nutrons.nu17.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Subsystem;

public class TwinShooter extends Subsystem {
	
	public Shooter twinA;
	public Shooter twinB;
	public Encoder EncoderA;
	public Encoder EncoderB;

	public TwinShooter() {
		//empty
	}

	public TwinShooter(
			int PORT_A, 
			int PORT_B, 
			int E_A1, 
			int E_B1, 
			int E_A2, 
			int E_B2) {
		twinA = new Shooter(
				PORT_A, 
				E_A1, 
				E_B1);
		twinB = new Shooter(
				PORT_B, 
				E_A2, 
				E_B2);
	}

	// TODO tune these constants
	public double P_SHOOT = 0.025;
	public double I_SHOOT = 0.0;
	public double D_SHOOT = 0.01;

	public PIDController ShootSpeedControlA = new PIDController(this.P_SHOOT, this.I_SHOOT, this.D_SHOOT,
			new EncoderWrapperA(), new HoldShooterOutputA());
	public PIDController ShootSpeedControlB = new PIDController(this.P_SHOOT, this.I_SHOOT, this.D_SHOOT,
			new EncoderWrapperB(), new HoldShooterOutputB());
	
	public static double holdShootA;
	public static double holdShootB;

	/**
	 * Runs the first shooting motor to a speed.
	 * 
	 * @param power Speed to run the first shooting motor at.
	 */
	public void runTwinA(double power) {
		twinA.runShooter(power);
	}

	/**
	 * Runs the second shooting motor to a speed
	 * 
	 * @param power Speed to run the second shooting motor at.
	 */
	public void runTwinB(double power) {
		twinB.runShooter(power);
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
		twinA.runShooter(0.0);
	}

	/**
	 * Stops the second shooting motor.
	 */
	public void stopTwinB() {
		twinB.runShooter(0.0);
	}

	/**
	 * Stops both shooting motors.
	 */
	public void stopTwins() {
		runTwinA(0.0);
		runTwinB(0.0);
	}

	public void resetEncoderA() {
		twinA.resetEncoder();
	}

	public void resetEncoderB() {
		twinB.resetEncoder();
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
			return EncoderA.getRate();
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
			return EncoderB.getRate();
		}
	}

	private class HoldShooterOutputB implements PIDOutput {
		@Override
		public void pidWrite(double output) {
			holdShootB = output;
		}
	}

	public void initDefaultCommand() {
		//empty
	}
}

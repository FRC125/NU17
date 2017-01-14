package com.nutrons.nu17.subsystems;

import com.nutrons.nu17.Robot;
import com.nutrons.nu17.subsystems.Shooter.EncoderWrapper;
import com.nutrons.nu17.subsystems.Shooter.HoldShooterOutput;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Josh Young
 */
public class TwinShooter extends Subsystem {
	public Shooter twinA;
	public Shooter twinB;
	public Encoder EncoderA;
	public Encoder EncoderB;

	public TwinShooter() {

	}

	public TwinShooter(int PORT_A, int PORT_B, int E_A1, int E_B1, int E_A2, int E_B2) {
		twinA = new Shooter(PORT_A, E_A1, E_B1);
		twinB = new Shooter(PORT_B, E_A2, E_B2);
	}

	// PID Constants
	public double P_SHOOT = 0.025;
	public double I_SHOOT = 0.0;
	public double D_SHOOT = 0.01;

	// PID Controller Stuff
	public PIDController ShootSpeedControlA = new PIDController(this.P_SHOOT, this.I_SHOOT, this.D_SHOOT,
			new EncoderWrapperA(), new HoldShooterOutputA());
	public static double holdShootA;
	public PIDController ShootSpeedControlB = new PIDController(this.P_SHOOT, this.I_SHOOT, this.D_SHOOT,
			new EncoderWrapperB(), new HoldShooterOutputB());
	public static double holdShootB;

	/**
	 * Runs TwinA given param power
	 * 
	 * @param power
	 */
	public void runTwinA(double power) {
		twinA.runShooter(power);
	}

	/**
	 * Runs TwinB given param power
	 * 
	 * @param power
	 */
	public void runTwinB(double power) {
		twinB.runShooter(power);
	}

	/**
	 * Runs boths twins at the same time
	 * 
	 * @param power
	 */
	public void twinRun(double power) {
		runTwinA(power);
		runTwinB(power);
	}

	/**
	 * Stops TwinA
	 */
	public void stopTwinA() {
		twinA.runShooter(0.0);
	}

	/**
	 * Stops TwinB
	 */
	public void stopTwinB() {
		twinB.runShooter(0.0);
	}

	/**
	 * Stops both Twins
	 */
	public void stopTwins() {
		runTwinA(0.0);
		runTwinB(0.0);
	}

	/**
	 * Resets EncoderA
	 */
	public void resetEncoderA() {
		twinA.resetEncoder();
	}

	/**
	 * Resets EncoderB
	 */
	public void resetEncoderB() {
		twinB.resetEncoder();
	}

	/**
	 * Resets both Encoders
	 */
	public void twinReset() {
		resetEncoderA();
		resetEncoderB();
	}

	/**
	 * This creates the source and retrieves the data from the PID calculation A
	 */
	private class EncoderWrapperA implements PIDSource {
		@Override
		public void setPIDSourceType(PIDSourceType pidSource) {
			// Encoder Value
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

	/**
	 * This holds the output from the PID Controller A
	 */
	private class HoldShooterOutputA implements PIDOutput {

		@Override
		public void pidWrite(double output) {
			holdShootA = output;

		}

	}

	/**
	 * This creates the source and retrieves the data from the PID calculation B
	 */
	private class EncoderWrapperB implements PIDSource {
		@Override
		public void setPIDSourceType(PIDSourceType pidSource) {
			// Encoder Value
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

	/**
	 * This holds the output from the PID Controller B
	 */
	private class HoldShooterOutputB implements PIDOutput {
		@Override
		public void pidWrite(double output) {
			holdShootB = output;
		}
	}

	public void initDefaultCommand() {
}
}

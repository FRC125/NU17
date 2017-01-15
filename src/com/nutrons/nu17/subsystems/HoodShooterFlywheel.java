package com.nutrons.nu17.subsystems;

import com.nutrons.nu17.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class HoodShooterFlywheel extends Subsystem {

	private Talon flyWheelLeft = new Talon(RobotMap.FLY_WHEEL_L);
	private Talon flyWheelRight = new Talon(RobotMap.FLY_WHEEL_R);
	private Encoder turnRight = new Encoder(RobotMap.ENCODER_FLY_R, 2);
	private Encoder turnLeft = new Encoder(RobotMap.ENCODER_FLY_L, 3);

	public PIDController angleShotPID = new PIDController(
			this.P_TURN, 
			this.I_TURN, 
			this.D_TURN, 
			new TurnSourcePID(), 
			new TurnOutput());

	// TODO tune these constants
	private final double P_TURN = 0.001;
	private final double I_TURN = 0;
	private final double D_TURN = 0;

	public void initDefaultCommand() {
		//empty
	}

	/**
	 * Drive the flywheel.
	 * 
	 * @param left Speed that the left fly wheel is set to.
	 * @param right Speed that the right fly wheel is set to.
	 */

	public void turnShot(double left, double right) {
		this.flyWheelLeft.set(left);
		this.flyWheelRight.set(right);

	}

	/**
	 * Stops flywheel.
	 */
	public void stop() {
		this.turnShot(0, 0);
	}

	/**
	 * Resets encoders.
	 */
	public void resetEncoder() {
		this.turnLeft.reset();
		this.turnRight.reset();
	}

	private class TurnSourcePID implements PIDSource {

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
			return 0;// waiting for encoder and actual flywheel
		}
	}

	private class TurnOutput implements PIDOutput {

		@Override
		public void pidWrite(double output) {
			turnShot(output, -output);
		}
	}
}

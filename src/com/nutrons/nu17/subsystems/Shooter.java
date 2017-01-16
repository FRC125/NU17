package com.nutrons.nu17.subsystems;

import com.nutrons.nu17.Robot;
import com.nutrons.nu17.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {

	private final Talon SHOOTER = new Talon(RobotMap.SHOOTER);
	private final Encoder SHOOTER_ENCODER = new Encoder(
			RobotMap.TWIN_ENCODER_1, 
			RobotMap.TWIN_ENCODER_2);

	public static double holdShoot;
	
	// TODO: tune these constants
	private static final double P_SHOOT = 0.025;
	private static final double I_SHOOT = 0.0;
	private static final double D_SHOOT = 0.01;

	public final PIDController SPEED_PID = new PIDController(
			P_SHOOT, 
			I_SHOOT, 
			D_SHOOT,
			new EncoderWrapper(), 
			new HoldShooterOutput());
	
	public Shooter() {
		//empty
	}

	public void initDefaultCommand() {
	}

	/**
	 * Runs shooter at given param power.
	 * 
	 * @param power Speed to run the shooting motor.
	 */
	public void runShooter(double power) {
		this.SHOOTER.set(power);
	}

	/**
	 * Cuts the power to the shooter, setting it to 0.0.
	 */
	public void stopShooter() {
		runShooter(0.0);
	}

	/**
	 * Resets Encoder.
	 */
	public void resetEncoder() {
		SHOOTER_ENCODER.reset();
	}

	public class EncoderWrapper implements PIDSource {
		@Override
		public void setPIDSourceType(PIDSourceType pidSource) {
		}

		@Override
		public PIDSourceType getPIDSourceType() {
			return PIDSourceType.kDisplacement;
		}

		@Override
		public double pidGet() {
			return Robot.SHOOTER.SHOOTER_ENCODER.getRate();
		}
	}

	public class HoldShooterOutput implements PIDOutput {
		@Override
		public void pidWrite(double output) {
			holdShoot = output;
		}
	}
}

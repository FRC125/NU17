package com.nutrons.nu17.subsystems;

import com.nutrons.nu17.Robot;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {

	private Talon shooter;
	private Encoder shooterEncoder;

	public Shooter() {
		//empty
	}

	public Shooter(int PORT, int E_A, int E_B) {
		shooter = new Talon(PORT);
		shooterEncoder = new Encoder(E_A, E_B);
	}

	// TODO: tune these constants
	public double P_SHOOT = 0.025;
	public double I_SHOOT = 0.0;
	public double D_SHOOT = 0.01;

	public PIDController ShootSpeedControl = new PIDController(this.P_SHOOT, this.I_SHOOT, this.D_SHOOT,
			new EncoderWrapper(), new HoldShooterOutput());
	public static double holdShoot;

	public void initDefaultCommand() {
	}

	/**
	 * Runs shooter at given param power.
	 * 
	 * @param power Speed to run the shooting motor.
	 */
	public void runShooter(double power) {
		this.shooter.set(power);
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
		shooterEncoder.reset();
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
			return Robot.SHOOTER.shooterEncoder.getRate();
		}
	}

	public class HoldShooterOutput implements PIDOutput {
		@Override
		public void pidWrite(double output) {
			holdShoot = output;
		}
	}
}

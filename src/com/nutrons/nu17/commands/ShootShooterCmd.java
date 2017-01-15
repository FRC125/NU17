package com.nutrons.nu17.commands;

import com.nutrons.nu17.Robot;
import com.nutrons.nu17.subsystems.Shooter;
import edu.wpi.first.wpilibj.command.Command;

public class ShootShooterCmd extends Command {

	public ShootShooterCmd() {
		requires(Robot.shooter);
	}

	/**
	 * Resets encoder and starts running motor at a consistent speed.
	 */
	protected void initialize() {
		Robot.shooter.resetEncoder();
		Robot.shooter.runShooter(1.0);
	}
	
	/**
	 * Keeps running motor to a consistent speed.
	 */
	protected void execute() {
		Robot.shooter.runShooter(Robot.shooter.ShootSpeedControl.get());
		Robot.shooter.runShooter(Shooter.holdShoot);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.shooter.stopShooter();
	}

	protected void interrupted() {
		end();
	}
}

package com.nutrons.nu17.commands;

import com.nutrons.nu17.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ShootTwinShooterCmd extends Command {

	public ShootTwinShooterCmd() {
		requires(Robot.TWIN_SHOOTER);
	}
	
	/**
	 * Resets the encoders and starts each motor.
	 */
	protected void initialize() {
		Robot.TWIN_SHOOTER.twinReset();
		Robot.TWIN_SHOOTER.ShootSpeedControlA.enable();
		Robot.TWIN_SHOOTER.ShootSpeedControlB.enable();
	}

	/**
	 * Spins motors using PID controllers.
	 */
	protected void execute() {
		Robot.TWIN_SHOOTER.runTwinA(Robot.TWIN_SHOOTER.ShootSpeedControlA.get());
		Robot.TWIN_SHOOTER.runTwinB(Robot.TWIN_SHOOTER.ShootSpeedControlB.get());
	}
	// Don't want the shooter to stop
	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.TWIN_SHOOTER.stopTwins();
	}

	protected void interrupted() {
		end();
	}
}

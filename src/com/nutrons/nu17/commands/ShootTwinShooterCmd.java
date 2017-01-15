package com.nutrons.nu17.commands;

import com.nutrons.nu17.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ShootTwinShooterCmd extends Command {

	public ShootTwinShooterCmd() {
		requires(Robot.twinShooter);
	}
	
	/**
	 * Resets the encoders and starts each motors.
	 */
	protected void initialize() {
		Robot.twinShooter.twinReset();
		Robot.twinShooter.ShootSpeedControlA.enable();
		Robot.twinShooter.ShootSpeedControlB.enable();
	}

	/**
	 * Spins motors using PID controllers.
	 */
	protected void execute() {
		Robot.twinShooter.runTwinA(Robot.twinShooter.ShootSpeedControlA.get());
		Robot.twinShooter.runTwinB(Robot.twinShooter.ShootSpeedControlB.get());
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.twinShooter.stopTwins();
	}

	protected void interrupted() {
		end();
	}
}

package com.nutrons.nu17.commands;

import com.nutrons.nu17.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ClimberCmd extends Command {

	public ClimberCmd() {
		requires(Robot.climber);
	}

	protected void initialize() {
		Robot.climber.runClimb(1.0);
	}

	/**
	 * Keeps running the climbing motor until we touch the pad.
	 */
	protected void execute() {
		Robot.climber.runClimb(1.0);
		Robot.climber.padCheck();
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.climber.stopClimb();
	}

	protected void interrupted() {
		end();
	}
}

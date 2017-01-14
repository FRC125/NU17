package com.nutrons.nu17.commands;

import com.nutrons.nu17.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Kevin Henriquez
 */
public class ClimberCmd extends Command {

	public ClimberCmd() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.climber);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.climber.runClimb(1.0);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.climber.runClimb(1.0);
		Robot.climber.padCheck();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}

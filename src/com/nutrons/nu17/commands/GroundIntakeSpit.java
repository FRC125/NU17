package com.nutrons.nu17.commands;

import com.nutrons.nu17.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Josh Young
 */
public class GroundIntakeSpit extends Command {

	public GroundIntakeSpit() {
		requires(Robot.groundIntake);
	}

	protected void initialize() {
		Robot.groundIntake.stopRollerA();
		Robot.groundIntake.stopRollerB();
	}

	protected void execute() {
		Robot.groundIntake.driveRollerA(-1.0);
		Robot.groundIntake.driveRollerB(-1.0);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}

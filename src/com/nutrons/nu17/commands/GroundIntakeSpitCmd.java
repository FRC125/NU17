package com.nutrons.nu17.commands;

import com.nutrons.nu17.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class GroundIntakeSpitCmd extends Command {

	public GroundIntakeSpitCmd() {
		requires(Robot.groundIntake);
	}

	/**
	 * Stops intaking.
	 */
	protected void initialize() {
		Robot.groundIntake.stopRollerA();
		Robot.groundIntake.stopRollerB();
	}

	/**
	 * Reverses the motors in order for the ball to be spit out.
	 */
	protected void execute() {
		Robot.groundIntake.driveRollerA(-1.0);
		Robot.groundIntake.driveRollerB(-1.0);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.groundIntake.stopRollerA();
		Robot.groundIntake.stopRollerB();
	}

	protected void interrupted() {
		end();
	}
}

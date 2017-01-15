package com.nutrons.nu17.commands;

import com.nutrons.nu17.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class GroundIntakeCmd extends Command {

	public GroundIntakeCmd() {
		requires(Robot.groundIntake);
	}

	/**
	 * Runs first motor.
	 */
	protected void initialize() {
		Robot.groundIntake.driveRollerA(1.0);
	}

	/**
	 * Keeps running motor until the ball is ready to be centered, then runs other motor to intake.
	 */
	protected void execute() {
		Robot.groundIntake.driveRollerA(1.0);
		if (Robot.groundIntake.isBallCentered()) {
			Robot.groundIntake.driveRollerB(1.0);
		}
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

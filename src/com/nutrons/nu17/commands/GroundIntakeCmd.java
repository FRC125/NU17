package com.nutrons.nu17.commands;

import com.nutrons.nu17.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class GroundIntakeCmd extends Command {

	public GroundIntakeCmd() {
		requires(Robot.GROUND_INTAKE);
	}

	/**
	 * Runs first motor.
	 */
	protected void initialize() {
		Robot.GROUND_INTAKE.driveRollerA(1.0);
	}

	/**
	 * Keeps running motor until the ball is ready to be centered, then runs other motor to intake.
	 */
	protected void execute() {
		Robot.GROUND_INTAKE.driveRollerA(1.0);
		if (Robot.GROUND_INTAKE.isBallCentered()) {
			Robot.GROUND_INTAKE.driveRollerB(1.0);
		}
	}
	// Finishes when the ball is centered
	protected boolean isFinished() {
		return Robot.GROUND_INTAKE.isBallCentered();
	}

	protected void end() {
		Robot.GROUND_INTAKE.stopRollerA();
		Robot.GROUND_INTAKE.stopRollerB();
	}

	protected void interrupted() {
		end();
	}
}

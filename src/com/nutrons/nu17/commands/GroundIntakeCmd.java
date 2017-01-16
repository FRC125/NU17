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
		Robot.GROUND_INTAKE.driveRoller1(1.0);
	}

	/**
	 * Keeps running motor until the ball is ready to be centered, then runs other motor to intake.
	 */
	protected void execute() {
		Robot.GROUND_INTAKE.driveRoller1(1.0);
		if (Robot.GROUND_INTAKE.isBallCentered()) {
			Robot.GROUND_INTAKE.driveRoller2(1.0);
		}
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.GROUND_INTAKE.stopRoller1();
		Robot.GROUND_INTAKE.stopRoller2();
	}

	protected void interrupted() {
		end();
	}
}

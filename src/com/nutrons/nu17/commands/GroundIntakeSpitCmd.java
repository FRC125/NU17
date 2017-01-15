package com.nutrons.nu17.commands;

import com.nutrons.nu17.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class GroundIntakeSpitCmd extends Command {

	public GroundIntakeSpitCmd() {
		requires(Robot.GROUND_INTAKE);
	}

	/**
	 * Stops intaking.
	 */
	protected void initialize() {
		Robot.GROUND_INTAKE.stopRollerA();
		Robot.GROUND_INTAKE.stopRollerB();
	}

	/**
	 * Reverses the motors in order for the ball to be spit out.
	 */
	protected void execute() {
		Robot.GROUND_INTAKE.driveRollerA(-1.0);
		Robot.GROUND_INTAKE.driveRollerB(-1.0);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.GROUND_INTAKE.stopRollerA();
		Robot.GROUND_INTAKE.stopRollerB();
	}

	protected void interrupted() {
		end();
	}
}

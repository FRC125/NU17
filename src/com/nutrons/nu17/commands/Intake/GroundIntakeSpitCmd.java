package com.nutrons.nu17.commands.Intake;

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
		Robot.GROUND_INTAKE.stopRoller1();
		Robot.GROUND_INTAKE.stopRoller2();
	}

	/**
	 * Reverses the motors in order for the ball to be spit out.
	 */
	protected void execute() {
		Robot.GROUND_INTAKE.driveRoller1(-1.0);
		Robot.GROUND_INTAKE.driveRoller2(-1.0);
	}
	// Finished when there is no ball in the intake
	protected boolean isFinished() {
		return Robot.GROUND_INTAKE.noBallCheck();
	}

	protected void end() {
		Robot.GROUND_INTAKE.stopRoller1();
		Robot.GROUND_INTAKE.stopRoller2();
	}

	protected void interrupted() {
		end();
	}
}

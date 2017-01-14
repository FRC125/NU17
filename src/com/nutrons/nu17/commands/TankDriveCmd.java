package com.nutrons.nu17.commands;

import com.nutrons.nu17.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class TankDriveCmd extends Command {

	public TankDriveCmd() {
		requires(Robot.dt);
	}

	protected void initialize() {
		//empty
	}

	/**
	 * Drives the robot depending on the left and right joystick's y values.
	 * Left joystick controls left wheels while right joystick controls right
	 * wheels.
	 */
	protected void execute() {
		Robot.dt.driveLR(Robot.oi.getLeftJoystickY(), Robot.oi.getRightJoystickY());
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.dt.stop();
	}

	protected void interrupted() {
		end();
	}
}

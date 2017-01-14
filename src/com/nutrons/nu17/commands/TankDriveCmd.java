package com.nutrons.nu17.commands;

import com.nutrons.nu17.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Man Nguyen
 */
public class TankDriveCmd extends Command {

	public TankDriveCmd() {
		requires(Robot.dt);
	}

	protected void initialize() {
	}

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

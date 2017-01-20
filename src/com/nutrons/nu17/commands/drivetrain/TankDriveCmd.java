package com.nutrons.nu17.commands.drivetrain;

import com.nutrons.nu17.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class TankDriveCmd extends Command {

	public TankDriveCmd() {
		requires(Robot.DRIVETRAIN);
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
		Robot.DRIVETRAIN.driveLR(Robot.OI.getLeftJoystickY(), Robot.OI.getRightJoystickY());
	}
	
	//Don't want the robot to stop
	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.DRIVETRAIN.stop();
	}

	protected void interrupted() {
		this.end();
	}
}

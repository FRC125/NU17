package com.nutrons.nu17.commands;

import com.nutrons.nu17.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DrivePIDCmd extends Command {

	private double target;

	public DrivePIDCmd(double target) {
		requires(Robot.DRIVETRAIN);
		this.target = target;
	}

	/**
	 * Sets a target to drive to. Sets how far the robot can be displaced from the target.
	 */
	protected void initialize() {
		Robot.DRIVETRAIN.DISTANCE_PID.setSetpoint(this.target);
		Robot.DRIVETRAIN.DISTANCE_PID.setAbsoluteTolerance(0.2);
		Robot.DRIVETRAIN.DISTANCE_PID.enable();
	}

	protected void execute() {
		//empty
	}
	// Finishes when targeted destination is reached
	protected boolean isFinished() {
		return Math.abs(Robot.DRIVETRAIN.DISTANCE_PID.getError()) < 0.2;
	}

	protected void end() {
		Robot.DRIVETRAIN.DISTANCE_PID.disable();
	}

	protected void interrupted() {
		end();
	}
}

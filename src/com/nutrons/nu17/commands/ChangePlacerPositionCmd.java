package com.nutrons.nu17.commands;

import com.nutrons.nu17.Robot;
import com.nutrons.nu17.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class ChangePlacerPositionCmd extends Command {

	private double position;

	public ChangePlacerPositionCmd() {
		requires(Robot.gp);
	}

	/**
	 * Switches between Gear Placer being up and down.
	 */
	protected void initialize() {
		if (Robot.gp.getPosition() >= 0.5) {
			this.position = 0;
		} else {
			this.position = RobotMap.PLACER_MAX_POSITION;
		}
		Robot.gp.set(position);
	}

	protected void execute() {
		//empty
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		//empty
	}

	protected void interrupted() {
		//empty
	}
}

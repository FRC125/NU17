package com.nutrons.nu17.commands;

import com.nutrons.nu17.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command that brings gear placer up to give the lift a gear.
 */
public class RaiseGearPlacerCmd extends Command {

	private final double PLACER_MAX_POSITION = 1;

    public RaiseGearPlacerCmd() {
    	requires(Robot.GP);
    }

    /**
     * Lowers the gear placer.
     */
    protected void initialize() {
    	Robot.GP.set(this.PLACER_MAX_POSITION);
    }

    protected void execute() {
    	//empty
    }
    // Finishes when the placer is at the highest position
    protected boolean isFinished() {
        return Robot.GP.getPosition() == this.PLACER_MAX_POSITION;
    }

    protected void end() {
    	Robot.GP.stop();
    }

    protected void interrupted() {
    	end();
    }
}

package com.nutrons.nu17.commands;

import com.nutrons.nu17.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Lifts the gear placer to interact with a gear.
 */
public class RaiseGearPlacerCmd extends Command {

	private final double PLACER_MAX_POSITION = 1;

    public RaiseGearPlacerCmd() {
    	requires(Robot.GP);
    }

    /**
     * Raises the gear placer.
     */
    protected void initialize() {
    	Robot.GP.set(this.PLACER_MAX_POSITION);
    }

    protected void execute() {
    	//empty
    }
    
    /**
     * Raise the gear placer to the highest position.
     */
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

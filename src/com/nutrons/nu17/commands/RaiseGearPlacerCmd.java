package com.nutrons.nu17.commands;

import com.nutrons.nu17.Robot;
import com.nutrons.nu17.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * 
 */
public class RaiseGearPlacerCmd extends Command {

    public RaiseGearPlacerCmd() {
    	requires(Robot.GP);
    }

    /**
     * Lowers the gear placer.
     */
    protected void initialize() {
    	Robot.GP.set(RobotMap.PLACER_MAX_POSITION);
    }

    protected void execute() {
    	//empty
    }
    // Finishes when the placer is at the highest position
    protected boolean isFinished() {
        return Robot.GP.getPosition() == RobotMap.PLACER_MAX_POSITION;
    }

    protected void end() {
    	Robot.GP.stop();
    }

    protected void interrupted() {
    	end();
    }
}

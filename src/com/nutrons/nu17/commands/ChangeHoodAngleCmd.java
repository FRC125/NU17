package com.nutrons.nu17.commands;

import com.nutrons.nu17.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ChangeHoodAngleCmd extends Command {
	private double Point;
	
    public ChangeHoodAngleCmd() {
   requires(Robot.HOOD);
   this.Point =  Point;
    }
    protected void initialize() {
    	Robot.HOOD.SHOT_ANGLE_PID.setSetpoint(this.Point);
    	Robot.HOOD.SHOT_ANGLE_PID.enable();
    }
    // Runs pid to find angle
    protected void execute() {
    	Robot.HOOD.angleAdjust(Robot.HOOD.SHOT_ANGLE_PID.get());
    }
    protected boolean isFinished() {
        return false;
    }
    // stops it and resets angle measure
    protected void end() {
    Robot.HOOD.SHOT_ANGLE_PID.disable();
    Robot.HOOD.resetAdjust(-this.Point);
    	
    }
    protected void interrupted() {
    	// empty
    }
}
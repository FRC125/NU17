package com.nutrons.nu17.commands.drivetrain;

import com.nutrons.nu17.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveDistanceCmd extends Command {
	
	private double distance;

    public DriveDistanceCmd(double distance) {
    	requires(Robot.DRIVETRAIN);
    	this.distance = distance;
    }

    protected void initialize() {
    	Robot.DRIVETRAIN.setPercentDrive();
    	
    	Robot.DRIVETRAIN.FRONT_LEFT.enableBrakeMode(true);
    	Robot.DRIVETRAIN.FRONT_RIGHT.enableBrakeMode(true);
    	
    	Robot.DRIVETRAIN.FRONT_LEFT.set(this.distance);
    	Robot.DRIVETRAIN.FRONT_RIGHT.set(this.distance);
    	
    	Robot.DRIVETRAIN.FRONT_LEFT.setPID(
    			Robot.DRIVETRAIN.P_DRIVE, 
    			Robot.DRIVETRAIN.I_DRIVE, 
    			Robot.DRIVETRAIN.D_DRIVE);
    	Robot.DRIVETRAIN.FRONT_RIGHT.setPID(
    			Robot.DRIVETRAIN.P_DRIVE, 
    			Robot.DRIVETRAIN.I_DRIVE, 
    			Robot.DRIVETRAIN.D_DRIVE);
    	
    	Robot.DRIVETRAIN.FRONT_LEFT.enable();
    	Robot.DRIVETRAIN.FRONT_RIGHT.enable();
    }

    protected void execute() {
    	// empty
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.DRIVETRAIN.FRONT_LEFT.disable();
    	Robot.DRIVETRAIN.FRONT_RIGHT.disable();
    	Robot.DRIVETRAIN.stop();
    	Robot.DRIVETRAIN.disableBrakeMode();
    }

    protected void interrupted() {
    	this.end();
    }
}

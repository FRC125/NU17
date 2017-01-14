package com.nutrons.nu17.commands;

import com.nutrons.nu17.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author sytect
 */
public class DrivePIDCmd extends Command {
	
	private double target;

    public DrivePIDCmd(double target) {
        requires(Robot.dt);
        this.target = target;
    }

    protected void initialize() {
    	Robot.dt.resetEncoder();
    	Robot.dt.driveDistanceControl.setSetpoint(this.target);
    	Robot.dt.driveDistanceControl.setAbsoluteTolerance(0.2);
    	Robot.dt.driveDistanceControl.enable();
    }

    protected void execute() {
    	
    }

    protected boolean isFinished() {
        return Math.abs(Robot.dt.driveDistanceControl.getError()) < 0.2;
    }

    protected void end() {
    	Robot.dt.driveDistanceControl.disable();
    	Robot.dt.stop();
    }


    protected void interrupted() {
    }
}

package org.usfirst.frc.team125.robot.commands;

import org.usfirst.frc.team125.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShootCmd extends Command {
	

    public ShootCmd() {
    	requires(Robot.shooter);
    }

    protected void initialize() {
    	
    }

    protected void execute() {
    	Robot.shooter.fire();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.shooter.stop();
    }

    protected void interrupted() {
    	this.end();
    }
}
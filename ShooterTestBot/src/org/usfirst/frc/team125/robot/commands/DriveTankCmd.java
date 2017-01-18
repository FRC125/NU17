package org.usfirst.frc.team125.robot.commands;

import org.usfirst.frc.team125.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveTankCmd extends Command {

    public DriveTankCmd() {
    	requires(Robot.dt);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.dt.driveTank(Robot.oi.getJoyX(), Robot.oi.getJoyY());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.dt.stop();
    }

    protected void interrupted() {
    	this.end();
    }
}
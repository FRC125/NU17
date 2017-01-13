package com.nutrons.nu17.commands;

import com.nutrons.nu17.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class JoystickDriveCmd extends Command {

    public JoystickDriveCmd() {
        requires(Robot.driveTrain);
    }

    
    protected void initialize() {
    }

   
    protected void execute() {
    
    }

   
    protected boolean isFinished() {
        return false;
    }

    
    protected void end() {
    }

    
    protected void interrupted() {
    }
}

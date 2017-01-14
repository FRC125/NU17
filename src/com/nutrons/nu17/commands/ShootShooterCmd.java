package com.nutrons.nu17.commands;

import com.nutrons.nu17.Robot;
import com.nutrons.nu17.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *@author Josh Young
 */
public class ShootShooterCmd extends Command {

    public ShootShooterCmd() {
        requires(Robot.shooter);
    }

   
    protected void initialize() { 
    Robot.shooter.resetEncoder();
    Robot.shooter.ShootSpeedControl.enable();
    }

 
    protected void execute() {
    Robot.shooter.runShooter(Robot.shooter.ShootSpeedControl.get());
    }
    

    protected boolean isFinished() {
        return false;
    }


    protected void end() {
    }

    protected void interrupted() {
    }
}

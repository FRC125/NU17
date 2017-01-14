package com.nutrons.nu17.commands;

import com.nutrons.nu17.Robot;
import com.nutrons.nu17.subsystems.TwinShooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *@author Josh Young
 */
public class ShootTwinShooterCmd extends Command {

    public ShootTwinShooterCmd() {
        requires(Robot.twinShooter);
    }

   
    protected void initialize() { 
    Robot.twinShooter.twinReset();
    Robot.twinShooter.ShootSpeedControlA.enable();
    Robot.twinShooter.ShootSpeedControlB.enable();
    }

 
    protected void execute() {
    Robot.twinShooter.runTwinA(Robot.twinShooter.ShootSpeedControlA.get());
    Robot.twinShooter.runTwinB(Robot.twinShooter.ShootSpeedControlB.get());
    }
    

    protected boolean isFinished() {
        return false;
    }


    protected void end() {
    }

    protected void interrupted() {
    }
}

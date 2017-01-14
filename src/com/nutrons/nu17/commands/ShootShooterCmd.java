package com.nutrons.nu17.commands;

import com.nutrons.nu17.Robot;
import com.nutrons.nu17.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

/**
<<<<<<< HEAD
 *@author Josh Young
=======
 * 
>>>>>>> a9c6c6fa8ebb02724ac1e283a608a444bc3a0ccf
 */
public class ShootShooterCmd extends Command {

    public ShootShooterCmd() {
        requires(Robot.shooter);
    }

   
    protected void initialize() { 
<<<<<<< HEAD
    Robot.shooter.resetEncoder();
    Robot.shooter.ShootSpeedControl.enable();
=======
    	Robot.shooter.runShooter(1.0);
>>>>>>> a9c6c6fa8ebb02724ac1e283a608a444bc3a0ccf
    }

 
    protected void execute() {
<<<<<<< HEAD
    Robot.shooter.runShooter(Robot.shooter.ShootSpeedControl.get());
=======
    	Robot.shooter.runShooter(Shooter.holdShoot);
>>>>>>> a9c6c6fa8ebb02724ac1e283a608a444bc3a0ccf
    }
    

    protected boolean isFinished() {
        return false;
    }


    protected void end() {
    }

    protected void interrupted() {
    }
}

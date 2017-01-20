package com.nutrons.nu17.commands;

import com.nutrons.nu17.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShootShooterCmd extends Command {

  public ShootShooterCmd() {
    requires(Robot.SHOOTER);
  }

  /**
   * Resets encoder and starts running motor at a consistent speed.
   */
  protected void initialize() {
    Robot.SHOOTER.resetEncoder();
    Robot.SHOOTER.runShooter(1.0);
  }

  /**
   * Keeps running motor to a consistent speed.
   */
  protected void execute() {
    Robot.SHOOTER.runShooter(Robot.SHOOTER.speedPid.get());
  }

  // Don't want the shooter to stop
  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    Robot.SHOOTER.stopShooter();
  }

  protected void interrupted() {
    end();
  }
}

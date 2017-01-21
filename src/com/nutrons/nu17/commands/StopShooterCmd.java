package com.nutrons.nu17.commands;

import com.nutrons.nu17.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author The REAL MVP
 */
public class StopShooterCmd extends Command {

  public StopShooterCmd() {
    requires(Robot.SHOOTER);
  }

  protected void initialize() {
    Robot.SHOOTER.SHOOTER.disable();
  }


  protected void execute() {}


  protected boolean isFinished() {
    return true;
  }


  protected void end() {}


  protected void interrupted() {}
}

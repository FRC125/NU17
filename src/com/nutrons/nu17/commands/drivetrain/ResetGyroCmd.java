package com.nutrons.nu17.commands.drivetrain;

import com.nutrons.nu17.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author sytect
 */
public class ResetGyroCmd extends Command {

  public ResetGyroCmd() {
    requires(Robot.DRIVETRAIN);
  }

  protected void initialize() {
    Robot.DRIVETRAIN.resetGyro();
    Robot.DRIVETRAIN.resetEncoders();
  }

  protected void execute() {
    // empty
  }

  protected boolean isFinished() {
    return true;
  }

  protected void end() {
    // empty
  }

  protected void interrupted() {
    this.end();
  }
}

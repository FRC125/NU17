package com.nutrons.nu17.commands.drivetrain;

import com.nutrons.nu17.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author sytect
 */
public class CheesyDriveCmd extends Command {

  public CheesyDriveCmd() {
    requires(Robot.DRIVETRAIN);
  }

  protected void initialize() {
    Robot.DRIVETRAIN.setPercentDrive();
  }

  protected void execute() {
    Robot.DRIVETRAIN.driveCheesy(Robot.OI.getLeftJoystickY(), Robot.OI.getLeftJoystickX(),
        Robot.OI.getHoldHeadingMode());
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    // empty
  }

  protected void interrupted() {
    // empty
  }
}

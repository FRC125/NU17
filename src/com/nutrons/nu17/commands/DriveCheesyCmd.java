package com.nutrons.nu17.commands;

import com.nutrons.nu17.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command for CheesyDrive drive type.
 */
public class DriveCheesyCmd extends Command {

  public DriveCheesyCmd() {
    requires(Robot.DRIVETRAIN);
  }

  protected void initialize() {
    Robot.DRIVETRAIN.driveCheesy(Robot.OperatorInterface.getLeftJoystickY(),
        Robot.OperatorInterface.getRightJoystickX(), Robot.OperatorInterface.getHoldHeadingMode());
  }


  protected void execute() {

  }

  protected boolean isFinished() {
    return false;
  }


  protected void end() {}


  protected void interrupted() {}
}

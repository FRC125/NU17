package com.nutrons.nu17.commands;

import com.ctre.CANTalon.TalonControlMode;
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
    Robot.SHOOTER.SHOOTER.changeControlMode(TalonControlMode.Speed);
    Robot.SHOOTER.SHOOTER.setSetpoint(Robot.SHOOTER.SHOOTER_SPEED);
    Robot.SHOOTER.SHOOTER.enable();
  }

  protected void execute() {

  }

  // Don't want the shooter to stop
  protected boolean isFinished() {
    return true;
  }

  protected void end() {

  }

  protected void interrupted() {

  }
}

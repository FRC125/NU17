package com.nutrons.nu17.commands;

import com.ctre.CANTalon.TalonControlMode;
import com.nutrons.nu17.Robot;
import com.nutrons.nu17.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

public class ShootShooterCmd extends Command {

  public ShootShooterCmd() {
    requires(Robot.SHOOTER);
  }

  /**
   * Resets encoder and starts running motor at a consistent speed.
   */
  protected void initialize() {
    Robot.SHOOTER.shooter.changeControlMode(TalonControlMode.Speed);
    Robot.SHOOTER.shooter.setSetpoint(Shooter.SHOOTER_SPEED);
    Robot.SHOOTER.shooter.enable();
  }

  /**
   * Keeps running motor to a consistent speed.
   */
  protected void execute() {
    Robot.SHOOTER.setRpm(2000);
   
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

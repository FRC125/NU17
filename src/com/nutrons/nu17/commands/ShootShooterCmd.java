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
		Robot.SHOOTER.SHOOTER.changeControlMode(TalonControlMode.Speed);
		Robot.SHOOTER.SHOOTER.setSetpoint(Shooter.SHOOTER_SPEED);
		Robot.SHOOTER.SHOOTER.enable();
	}

  public ShootShooterCmd() {
    requires(Robot.SHOOTER);
  }

  /**
   * Resets encoder and starts running motor at a consistent speed.
   */
  protected void initialize() {
    Robot.SHOOTER.resetEncoder();
    Robot.SHOOTER.setRPM(1.0);
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

package com.nutrons.nu17.commands;

import com.nutrons.nu17.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ShootTwinShooterCmd extends Command {

  public ShootTwinShooterCmd() {
    requires(Robot.TWIN_SHOOTER);
  }

  /**
   * Resets the encoders and starts each motor.
   */
  protected void initialize() {
    Robot.TWIN_SHOOTER.twinReset();
    Robot.TWIN_SHOOTER.SPEED_PID_A.enable();
    Robot.TWIN_SHOOTER.speedPidB.enable();
  }

  /**
   * Spins motors using PID controllers.
   */
  protected void execute() {
    Robot.TWIN_SHOOTER.runTwinA(Robot.TWIN_SHOOTER.SPEED_PID_A.get());
    Robot.TWIN_SHOOTER.runTwinB(Robot.TWIN_SHOOTER.speedPidB.get());
  }

  // Don't want the shooter to stop
  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    Robot.TWIN_SHOOTER.stopTwins();
  }

  protected void interrupted() {
    end();
  }
}

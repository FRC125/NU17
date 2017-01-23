package com.nutrons.nu17.commands;

import com.nutrons.nu17.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ClimberCmd extends Command {

  public ClimberCmd() {
    requires(Robot.CLIMBER);
  }

  protected void initialize() {
    Robot.CLIMBER.runClimb(1.0);
  }

  /**
   * Keeps running the climbing motor until we touch the pad.
   */
  protected void execute() {
    Robot.CLIMBER.runClimb(1.0);
    Robot.CLIMBER.padCheck();
  }

  // Finishes when the MicroSwitch is true
  protected boolean isFinished() {
    return Robot.CLIMBER.checkSwitch();
  }

  protected void end() {
    Robot.CLIMBER.stopClimb();
  }

  protected void interrupted() {
    end();
  }
}

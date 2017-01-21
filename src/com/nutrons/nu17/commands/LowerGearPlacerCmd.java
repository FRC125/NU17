package com.nutrons.nu17.commands;

import com.nutrons.nu17.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * 
 */
public class LowerGearPlacerCmd extends Command {

  public LowerGearPlacerCmd() {
    requires(Robot.GP);
  }

  /**
   * Lowers the gear placer.
   */
  protected void initialize() {
    Robot.GP.set(0);
  }

  protected void execute() {
    // empty
  }

  // Finished when the placer is at the lowest position
  protected boolean isFinished() {
    return Robot.GP.getPosition() == 0;
  }

  protected void end() {
    Robot.GP.stop();
  }

  protected void interrupted() {
    end();
  }
}

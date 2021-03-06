package com.nutrons.nu17.commands;

import com.nutrons.nu17.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Raise the gear placer.
 */
public class RaiseGearPlacerCmd extends Command {

  private final double placerMaxPosition = 1;

  public RaiseGearPlacerCmd() {
    requires(Robot.GP);
  }

  /**
   * Lowers the gear placer.
   */
  protected void initialize() {
    Robot.GP.set(this.placerMaxPosition);
  }

  protected void execute() {
    // empty
  }

  // Finishes when the placer is at the highest position
  protected boolean isFinished() {
    return Robot.GP.getPosition() == this.placerMaxPosition;
  }

  protected void end() {
    Robot.GP.stop();
  }

  protected void interrupted() {
    end();
  }
}

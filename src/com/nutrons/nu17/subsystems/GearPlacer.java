package com.nutrons.nu17.subsystems;

import com.nutrons.nu17.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearPlacer extends Subsystem {

  private final Talon placer = new Talon(RobotMap.GEAR_PLACER_SERVO);

  public void initDefaultCommand() {
    // empty
  }

  /**
   * Sets the gear placer to a position.
   * 
   * @param position Where the gear placer will be set to.
   */
  public void set(double position) {
    placer.setPosition(position);
  }

  /**
   * Returns the current position of the gear placer.
   * 
   * @return Gives us where the gear placer is at this moment.
   */
  public double getPosition() {
    return placer.getPosition();
  }

  public void stop() {
    placer.disable();
  }
}

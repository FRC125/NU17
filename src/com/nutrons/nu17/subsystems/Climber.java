package com.nutrons.nu17.subsystems;

import com.nutrons.nu17.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {

  private final DigitalInput microSwitch = new DigitalInput(RobotMap.CLIMBER_MICRO_SWITCH);

  private final Talon climb = new Talon(RobotMap.CLIMBER_MOTOR);

  public Climber() {
    // empty
  }

  public void initDefaultCommand() {
    // empty
  }

  /**
   * Pulls the robot up using the climbing motor.
   * 
   * @param power Speed to run the climbing motor at, between 0.0 to 1.0.
   */
  public void runClimb(double power) {
    this.climb.set(power);
  }

  /**
   * Stops the motor pulling the robot up.
   */
  public void stopClimb() {
    if (microSwitch.get()) {
      this.climb.set(0);
    }
  }

  /**
   * Runs the motor until touching pad.
   */
  public void padCheck() {
    if (microSwitch.get()) {
      stopClimb();
    } else {
      runClimb(1);
    }
  }

  /**
   * Checks if the Micro Switch is true.
   * 
   * @return value of the Micro Switch
   */
  public boolean checkSwitch() {
    return microSwitch.get();
  }
}

package com.nutrons.nu17.subsystems;

import com.nutrons.nu17.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GroundIntake extends Subsystem {

  private final Talon roller1 = new Talon(RobotMap.ROLLER_FRONT);
  private final Talon roller2 = new Talon(RobotMap.ROLLER_BACK);

  private final Ultrasonic ballCenter =
      new Ultrasonic(RobotMap.ULTRASONIC_RX, RobotMap.ULTRASONIC_TX);

  // TODO: tune these constants
  private final double ballCenterMargin = 5.0;

  public GroundIntake() {
    // empty
  }

  public void initDefaultCommand() {
    // empty
  }

  /**
   * Drive's roller1 given param power.
   * 
   * @param power Speed that the first roller is set to.
   */
  public void driveRoller1(double power) {
    this.roller1.set(power);
  }

  /**
   * Drive's roller2 given param power.
   * 
   * @param power Speed that the second roller is set to.
   */
  public void driveRoller2(double power) {
    this.roller2.set(power);
  }

  /**
   * Stops roller1.
   */
  public void stopRoller1() {
    driveRoller1(0.0);
  }

  /**
   * Stops roller2.
   */
  public void stopRoller2() {
    driveRoller2(0.0);
  }

  /**
   * Returns a boolean checking if the US Sensors value in inches is less then the give margin.
   * 
   * @return Tells us whether the ball is directly in front of the robot and centered.
   */
  public boolean isBallCentered() {
    return (ballCenter.getRangeInches() < ballCenterMargin);
  }

  /**
   * Checks for a ball in the intake.
   * 
   * @return Whether there is a ball in the center or not
   */
  public boolean noBallCheck() {
    if (isBallCentered()) {
      return false;
    }
    return true;
  }
}

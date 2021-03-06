package com.nutrons.nu17.subsystems;

import com.nutrons.nu17.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class HoodShooterFlywheel extends Subsystem {

  private final Talon flyWheelLeft = new Talon(RobotMap.FLY_WHEEL_LEFT);
  private final Talon flyWheelRight = new Talon(RobotMap.FLY_WHEEL_RIGHT);
  private final Encoder turnLeft =
      new Encoder(RobotMap.FLY_ENCODER_FRONT_RIGHT, RobotMap.FLY_ENCODER_BACK_RIGHT);
  private final Encoder turnRight =
      new Encoder(RobotMap.FLY_ENCODER_FRONT_LEFT, RobotMap.FLY_ENCODER_BACK_LEFT);

  public final PIDController angleShotPid =
      new PIDController(P_TURN, I_TURN, D_TURN, new TurnSourcePid(), new TurnOutput());

  // TODO: tune these constants
  private static final double P_TURN = 0.001;
  private static final double I_TURN = 0;
  private static final double D_TURN = 0;

  public void initDefaultCommand() {
    // empty
  }

  /**
   * Drive the flywheel.
   * 
   * @param left Speed that the left fly wheel is set to.
   * @param right Speed that the right fly wheel is set to.
   */
  public void turnShot(double left, double right) {
    this.flyWheelLeft.set(left);
    this.flyWheelRight.set(right);
  }

  /**
   * Stops flywheel.
   */
  public void stop() {
    this.turnShot(0, 0);
  }

  /**
   * Resets encoders.
   */
  public void resetEncoder() {
    this.turnLeft.reset();
    this.turnRight.reset();
  }

  private class TurnSourcePid implements PIDSource {

    @Override
    public void setPIDSourceType(PIDSourceType pidSource) {
      // empty
    }

    @Override
    public PIDSourceType getPIDSourceType() {
      return PIDSourceType.kDisplacement;
    }

    @Override
    public double pidGet() {
      return 0;// waiting for encoder and actual flywheel
    }
  }

  private class TurnOutput implements PIDOutput {

    @Override
    public void pidWrite(double output) {
      turnShot(output, -output);
    }
  }
}

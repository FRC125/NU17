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

  private final Talon FLY_WHEEL_LEFT = new Talon(RobotMap.FLY_WHEEL_L);
  private final Talon FLY_WHEEL_RIGHT = new Talon(RobotMap.FLY_WHEEL_R);
  private final Encoder TURN_LEFT = new Encoder(RobotMap.FLY_ENCODER_R1, RobotMap.FLY_ENCODER_R2);
  private final Encoder TURN_RIGHT = new Encoder(RobotMap.FLY_ENCODER_L1, RobotMap.FLY_ENCODER_L2);

  public final PIDController ANGLE_SHOT_PID =
      new PIDController(P_TURN, I_TURN, D_TURN, new TurnSourcePID(), new TurnOutput());

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
    this.FLY_WHEEL_LEFT.set(left);
    this.FLY_WHEEL_RIGHT.set(right);
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
    this.TURN_LEFT.reset();
    this.TURN_RIGHT.reset();
  }

  private class TurnSourcePID implements PIDSource {

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

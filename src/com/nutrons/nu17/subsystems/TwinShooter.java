package com.nutrons.nu17.subsystems;

import com.nutrons.nu17.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Subsystem;
import lib.EncoderWrapper;
import lib.HoldPid;

public class TwinShooter extends Subsystem {

  private final Shooter twinA = new Shooter();
  private final Shooter twinB = new Shooter();
  private final Encoder encoderOne =
      new Encoder(RobotMap.TWIN_LEFT_ENCODER_1, RobotMap.TWIN_LEFT_ENCODER_2);
  private final Encoder encoderTwo =
      new Encoder(RobotMap.TWIN_RIGHT_ENCODER_1, RobotMap.TWIN_RIGHT_ENCODER_2);

  // PID Wrappers and Holder Objects
  private EncoderWrapper encWrap1 = new EncoderWrapper(PIDSourceType.kDisplacement, encoderOne,
      RobotMap.TWIN_LEFT_ENCODER_1, RobotMap.TWIN_LEFT_ENCODER_2);

  private HoldPid twinHold1 = new HoldPid();

  private EncoderWrapper encWrap2 = new EncoderWrapper(PIDSourceType.kDisplacement, encoderTwo,
      RobotMap.TWIN_RIGHT_ENCODER_1, RobotMap.TWIN_RIGHT_ENCODER_2);

  private HoldPid twinHold2 = new HoldPid();

  public TwinShooter() {
    // empty
  }

  // TODO: tune these constants
  private static final double P_SHOOT = 0.025;
  private static final double I_SHOOT = 0.0;
  private static final double D_SHOOT = 0.01;

  public final PIDController speedPidA =
      new PIDController(P_SHOOT, I_SHOOT, D_SHOOT, encWrap1, twinHold1);
  public PIDController speedPidB =
      new PIDController(P_SHOOT, I_SHOOT, D_SHOOT, encWrap2, twinHold2);



  public void initDefaultCommand() {
    // empty
  }

  /**
   * Runs the first shooting motor to a speed.
   * 
   * @param power Speed to run the first shooting motor at.
   */
  public void runTwinA(double power) {
    twinA.runShooter(power);
  }

  /**
   * Runs the second shooting motor to a speed
   * 
   * @param power Speed to run the second shooting motor at.
   */
  public void runTwinB(double power) {
    twinB.runShooter(power);
  }

  /**
   * Runs both shooting motors at the same time to the same speed.
   * 
   * @param power Speed to run both shooting motors at.
   */
  public void twinRun(double power) {
    runTwinA(power);
    runTwinB(power);
  }

  /**
   * Stops the first shooting motor.
   */
  public void stopTwinA() {
    twinA.runShooter(0.0);
  }

  /**
   * Stops the second shooting motor.
   */
  public void stopTwinB() {
    twinB.runShooter(0.0);
  }

  /**
   * Stops both shooting motors.
   */
  public void stopTwins() {
    runTwinA(0.0);
    runTwinB(0.0);
  }

  public void resetEncoderA() {
    twinA.resetEncoder();
  }

  public void resetEncoderB() {
    twinB.resetEncoder();
  }

  public void twinReset() {
    resetEncoderA();
    resetEncoderB();
  }
}

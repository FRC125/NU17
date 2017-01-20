package com.nutrons.nu17.subsystems;

import com.ctre.CANTalon;
import com.nutrons.nu17.OI;
import com.nutrons.nu17.RobotMap;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import lib.EncoderWrapper;
import lib.GyroWrapper;
import lib.HoldPID;

public class Drivetrain extends Subsystem {

  public Drivetrain() {
    // empty
  }

  // Motors
  public CANTalon frontLeft = new CANTalon(RobotMap.FRONT_LEFT);
  public CANTalon backLeft = new CANTalon(RobotMap.BACK_LEFT);
  public CANTalon frontRight = new CANTalon(RobotMap.FRONT_RIGHT);
  public CANTalon backRight = new CANTalon(RobotMap.BACK_RIGHT);

  // Sensors
  private final AnalogGyro headingGyro = new AnalogGyro(RobotMap.DRIVETRAIN_HEADING_GYRO);

  // TODO: Tune Ports
  private final Encoder driveDistanceEncoder = new Encoder(
      RobotMap.LEFT_WHEEL_DRIVE_DISTANCE_ENCODER_1, RobotMap.LEFT_WHEEL_DRIVE_DISTANCE_ENCODER_2);

  // Drive
  public RobotDrive drive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);

  // PID
  // Wrappers
  private EncoderWrapper encWrap = new EncoderWrapper(PIDSourceType.kDisplacement,
      driveDistanceEncoder, RobotMap.LEFT_WHEEL_DRIVE_DISTANCE_ENCODER_1,
      RobotMap.LEFT_WHEEL_DRIVE_DISTANCE_ENCODER_2);
  private GyroWrapper gyroWrap =
      new GyroWrapper(PIDSourceType.kDisplacement, headingGyro, RobotMap.DRIVETRAIN_HEADING_GYRO);

  // Holders
  private HoldPID distanceHolder = new HoldPID();
  private HoldPID headingPIDHolder = new HoldPID();

  // TODO: tune these constants
  private static final double P_DRIVE = 0;
  private static final double I_DRIVE = 0;
  private static final double D_DRIVE = 0;

  // TODO: tune these constants
  private static final double P_HEADING = 0;
  private static final double I_HEADING = 0;
  private static final double D_HEADING = 0;

  public final PIDController distancePid =
      new PIDController(P_DRIVE, I_DRIVE, D_DRIVE, encWrap, distanceHolder);
  public final PIDController headingPid =
      new PIDController(P_HEADING, I_HEADING, D_HEADING, gyroWrap, headingPIDHolder);

  /**
   * Returns the angle, in degrees, away from the initial gyro position.
   * 
   * @return angle Angular displacement from the initial gyro position.
   */
  public double getAngleInDegrees() {
    return this.headingGyro.getAngle();
  }

  /**
   * Returns the rate of the encoder in relation to the setting of the encoder
   * 
   * @return Encoder Rate using the .getRate method
   */
  public double getEncoderRate() {
    return this.driveDistanceEncoder.getRate();
  }

  /**
   * Resets the encoder.
   */
  public void resetEncoder() {
    this.driveDistanceEncoder.reset();

  }

  /**
   * Resets the gyro.
   */
  public void resetGyro() {
    this.headingGyro.reset();

  }

  public void initDefaultCommand() {
    drive.tankDrive(OI.DRIVER_PAD.getY(), OI.DRIVER_PAD.getX());
  }
}

package com.nutrons.nu17.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import com.nutrons.nu17.OperatorInterface;
import com.nutrons.nu17.Robot;
import com.nutrons.nu17.RobotMap;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Drivetrain extends Subsystem {
  // Constants
  private final double headingTolerance = 5.0;
  private final double turnToAngleTolerance = 10.0;

  /**
   * Drivetrain subsystem, configured for 4 wheel drive.
   */
  public Drivetrain() {
    this.setPercentDrive();

    this.holdHeading.setInputRange(-180.0, 180.0);
    this.holdHeading.setOutputRange(-1.0, 1.0);
    this.holdHeading.setAbsoluteTolerance(headingTolerance);
    this.holdHeading.setContinuous();

    this.turnToAngle.setAbsoluteTolerance(turnToAngleTolerance);

    this.leftLeader.changeControlMode(TalonControlMode.PercentVbus);
    this.leftLeader.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    this.leftLeader.configEncoderCodesPerRev((int) (256 / 0.14));
    this.leftLeader.reverseOutput(true);
    this.leftLeader.reverseSensor(true);
    this.leftLeader.setPID(0.02, 0.0, 0.08);
    this.leftLeader.configNominalOutputVoltage(+0.0f, -0.0f);
    this.leftLeader.configPeakOutputVoltage(12.0f, -12.0f);

    this.leftFollower.changeControlMode(TalonControlMode.Follower);
    this.leftFollower.set(this.leftLeader.getDeviceID());
    this.leftFollower.configNominalOutputVoltage(+0.0f, -0.0f);
    this.leftFollower.configPeakOutputVoltage(12.0f, -12.0f);

    this.rightLeader.changeControlMode(TalonControlMode.PercentVbus);
    this.rightLeader.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    this.rightLeader.configEncoderCodesPerRev((int) (256 / 0.14));
    this.rightLeader.setPID(0.02, 0.0, 0.08);
    this.rightLeader.configNominalOutputVoltage(+0.0f, -0.0f);
    this.rightLeader.configPeakOutputVoltage(12.0f, -12.0f);

    this.rightFollower.changeControlMode(TalonControlMode.Follower);
    this.rightFollower.set(this.rightLeader.getDeviceID());
    this.rightFollower.configNominalOutputVoltage(+0.0f, -0.0f);
    this.rightFollower.configPeakOutputVoltage(12.0f, -12.0f);

    this.disableBreakMode();

    this.gyro.calibrate();
  }

  // Motors
  private final CANTalon leftLeader = new CANTalon(RobotMap.FRONT_LEFT);
  private final CANTalon leftFollower = new CANTalon(RobotMap.BACK_LEFT);
  private final CANTalon rightLeader = new CANTalon(RobotMap.BACK_RIGHT);
  private final CANTalon rightFollower = new CANTalon(RobotMap.FRONT_RIGHT);


  // Sensors
  private final AnalogGyro gyro = new AnalogGyro(RobotMap.DRIVETRAIN_HEADING_GYRO);

  // TODO: Tune Ports
  private final Encoder leftSideEncoder = new Encoder(RobotMap.LEFT_WHEEL_DRIVE_DISTANCE_ENCODER_1,
      RobotMap.LEFT_WHEEL_DRIVE_DISTANCE_ENCODER_2);

  // TODO: Tune Ports
  private final Encoder rightSideEncoder = new Encoder(
      RobotMap.RIGHT_WHEEL_DRIVE_DISTANCE_ENCODER_1, RobotMap.RIGHT_WHEEL_DRIVE_DISTANCE_ENCODER_2);

  // Drive
  private RobotDrive drive = new RobotDrive(leftLeader, leftFollower, rightLeader, rightFollower);

  /**
   * Returns the angle, in degrees, away from the initial gyro position.
   * 
   * @return angle Angular displacement from the initial gyro position.
   */
  public double getAngleInDegrees() {
    return this.gyro.getAngle();
  }

  /**
   * Returns the rate of the encoder in relation to the setting of the encoder
   * 
   * @return Encoder Rate using the .getRate method
   */
  public double getLeftEncoderRate() {
    return this.leftSideEncoder.getRate();
  }

  /**
   * Resets the encoder.
   */
  public void resetLeftEncoder() {
    this.leftSideEncoder.reset();

  }

  /**
   * Returns the rate of the encoder in relation to the setting of the encoder
   * 
   * @return Encoder Rate using the .getRate method
   */
  public double getRightEncoderRate() {
    return this.rightSideEncoder.getRate();
  }

  /**
   * Resets the encoder.
   */
  public void resetRightEncoder() {
    this.rightSideEncoder.reset();

  }

  /**
   * Resets the gyro.
   */
  public void resetGyro() {
    this.gyro.reset();

  }

  public void setPercentDrive() {
    this.leftLeader.changeControlMode(TalonControlMode.PercentVbus);
    this.rightLeader.changeControlMode(TalonControlMode.PercentVbus);
  }

  /**
   * Drives drivetrain using left and right power.
   * 
   * @param leftPower Power number between -1 to 1 for the left side of dt
   * @param rightPower Power number between -1 to 1 for the right side of dt
   */
  public void drive(double leftPower, double rightPower) {
    this.leftLeader.set(leftPower);
    this.rightLeader.set(-rightPower);
  }

  /**
   * Sets up and initializes the DriveCheesy drive type.
   * @param speed a y axis value to determine the speed of the robot.
   * @param wheel a x axis value to determine the turning wheel of the robot.
   * @param holdHeading a boolean to determine whether or not robot holds heading.
   */
  public void driveCheesy(double speed, double wheel, boolean holdHeading) {
    double coeff = 1.0;
    double invert = 1.0;

    if (Robot.OperatorInterface.getSlowDrivingMode())
      coeff = 0.7;


    if (holdHeading) {
      if (!this.holdHeading.isEnabled()) {
        this.holdHeading.enable();
      }
      this.holdHeading.setSetpoint(0.0);
      drive((speed * 0.5 * invert) - (heading * invert),
          (speed * 0.5 * invert) + (heading * invert));
    } else {
      this.holdHeading.disable();
      wheel = wheel * 0.6;
      drive(((speed * invert) - (wheel)) * coeff, ((speed * invert) + (wheel)) * coeff);
    }
  }


  public void disableBreakMode() {
    this.leftLeader.enableBrakeMode(false);
    this.rightLeader.enableBrakeMode(false);
  }

  public void initDefaultCommand() {
    // empty
  }

  // PID
  // TODO: tune these constants
  private static final double P_HEADING = 0;
  private static final double I_HEADING = 0;
  private static final double D_HEADING = 0;

  // TODO: tune these constants
  private static final double P_TURN = 0;
  private static final double I_TURN = 0;
  private static final double D_TURN = 0;

  // TODO: tune these constants
  private static final double P_DISTANCE = 0;
  private static final double I_DISTANCE = 0;
  private static final double D_DISTANCE = 0;

  /**
   * Sets the heading output from PID Controller.
   * 
   * @param val Taken param
   */
  private void writeHeading(double val) {
    heading = val;
  }

  private double heading;
  public final PIDController holdHeading = new PIDController(P_HEADING, I_HEADING, D_HEADING,
      new GyroWrapper(), new HoldHeadingOutput());

  /**
   * Sets the heading output from PID Controller.
   * 
   * @param val Taken param
   */
  private void writeAngle(double val) {
    angle = val;
  }

  private double angle;
  public final PIDController turnToAngle =
      new PIDController(P_TURN, I_TURN, D_TURN, new GyroWrapper(), new TurnToAngleOutput());

  /**
   * Sets the heading output from PID Controller.
   * 
   * @param val Taken param
   */
  private void writeDistance(double val) {
    distance = val;
  }

  private double distance;
  public final PIDController driveDistance = new PIDController(P_DISTANCE, I_DISTANCE, D_DISTANCE,
      new EncoderWrapper(), new DriveDistanceOutput());

  private class GyroWrapper implements PIDSource {

    @Override
    public PIDSourceType getPIDSourceType() {
      return PIDSourceType.kDisplacement;
    }

    @Override
    public double pidGet() {
      return getAngleInDegrees();
    }

    @Override
    public void setPIDSourceType(PIDSourceType sourceType) {

    }
  }

  public class EncoderWrapper implements PIDSource {

    @Override
    public PIDSourceType getPIDSourceType() {
      return PIDSourceType.kDisplacement;
    }

    @Override
    public double pidGet() {
      return Robot.DRIVETRAIN.getLeftEncoderRate();
    }

    @Override
    public void setPIDSourceType(PIDSourceType sourceType) {

    }
  }

  private class HoldHeadingOutput implements PIDOutput {

    @Override
    public void pidWrite(double power) {
      writeHeading(power);
    }
  }

  public class TurnToAngleOutput implements PIDOutput {

    @Override
    public void pidWrite(double power) {
      writeAngle(power);
    }
  }

  public class DriveDistanceOutput implements PIDOutput {

    @Override
    public void pidWrite(double power) {
      writeDistance(power);
    }

  }
}

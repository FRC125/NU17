package com.nutrons.nu17.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import com.nutrons.nu17.Robot;
import com.nutrons.nu17.RobotMap;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Subsystem;
import lib.GyroWrapper;

import lib.HoldPID;

/**
 * @author sytect
 */
public class Drivetrain extends Subsystem {

  public final CANTalon FRONT_LEFT = new CANTalon(RobotMap.FRONT_LEFT);
  public final CANTalon FRONT_RIGHT = new CANTalon(RobotMap.FRONT_RIGHT);
  public final CANTalon BACK_LEFT = new CANTalon(RobotMap.BACK_LEFT);
  public final CANTalon BACK_RIGHT = new CANTalon(RobotMap.BACK_RIGHT);

  private AnalogGyro gyro = new AnalogGyro(RobotMap.GYRO);

  private GyroWrapper gyroWrapper = new GyroWrapper(PIDSourceType.kDisplacement, gyro);
  private HoldPID gyroPid = new HoldPID();

  // TODO: tune these constants
  public double P_DRIVE = 0.025;
  public double I_DRIVE = 0.001;
  public double D_DRIVE = 0.001;
  public double F_DRIVE = 0.001;

  // TODO: tune these constants
  public double P_HEADING = 0.025;
  public double I_HEADING = 0.001;
  public double D_HEADING = 0.001;

  private PIDController holdHeading = new PIDController(this.P_HEADING, this.I_HEADING,
      this.D_HEADING, this.gyroWrapper, this.gyroPid);

  public Drivetrain() {
    this.setPercentDrive();

    this.FRONT_LEFT.configNominalOutputVoltage(+0.0f, -0.0f);
    this.FRONT_LEFT.configPeakOutputVoltage(12.0f, -12.0f);

    this.FRONT_RIGHT.configNominalOutputVoltage(+0.0f, -0.0f);
    this.FRONT_RIGHT.configPeakOutputVoltage(12.0f, -12.0f);

    this.BACK_LEFT.configNominalOutputVoltage(+0.0f, -0.0f);
    this.BACK_LEFT.configPeakOutputVoltage(12.0f, -12.0f);

    this.BACK_RIGHT.configNominalOutputVoltage(+0.0f, -0.0f);
    this.BACK_RIGHT.configPeakOutputVoltage(12.0f, -12.0f);

    this.FRONT_LEFT.reverseOutput(true);
    this.FRONT_LEFT.reverseSensor(true);

    this.FRONT_LEFT.setPID(P_DRIVE, I_DRIVE, D_DRIVE);
    this.FRONT_RIGHT.setPID(P_DRIVE, I_DRIVE, D_DRIVE);

    this.disableBrakeMode();
  }

  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void disableBrakeMode() {
    this.FRONT_LEFT.enableBrakeMode(false);
    this.FRONT_RIGHT.enableBrakeMode(false);
  }

  public void setPercentDrive() {
    this.FRONT_LEFT.changeControlMode(TalonControlMode.PercentVbus);
    this.FRONT_RIGHT.changeControlMode(TalonControlMode.PercentVbus);

    this.BACK_LEFT.changeControlMode(TalonControlMode.Follower);
    this.BACK_LEFT.set(this.FRONT_LEFT.getDeviceID());

    this.BACK_RIGHT.changeControlMode(TalonControlMode.Follower);
    this.BACK_RIGHT.set(this.FRONT_RIGHT.getDeviceID());

    this.FRONT_LEFT.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    this.FRONT_RIGHT.setFeedbackDevice(FeedbackDevice.QuadEncoder);

    this.FRONT_LEFT.configEncoderCodesPerRev((int) (256 / 0.14));
    this.FRONT_RIGHT.configEncoderCodesPerRev((int) (256 / 0.14));
  }

  public void driveLR(double leftPower, double rightPower) {
    this.FRONT_LEFT.set(leftPower);
    this.FRONT_RIGHT.set(-rightPower);
  }

  /**
   * Drives using one joystick. Will hold heading if hold heading button is pressed with cheesy
   * drive button.
   * 
   * @param throttle Forward/backwards power.
   * @param direction
   * @param holdHeading
   */
  public void driveCheesy(double throttle, double direction, boolean holdHeading) {
    if (holdHeading) {
      driveHoldingHeading(throttle);
    } else {
      this.holdHeading.disable();
      driveLR(throttle - direction, throttle + direction);
    }
  }

  public void driveHoldingHeading(double throttle) {
    if (!this.holdHeading.isEnabled()) {
      this.holdHeading.reset();
      this.holdHeading.enable();
    }
    this.holdHeading.setSetpoint(0.0);
    driveLR((throttle * 0.5) - gyroPid.holder, (throttle * 0.5) + gyroPid.holder);
  }

  public void stop() {
    Robot.DRIVETRAIN.driveLR(0.0, 0.0);
  }
  
  public void resetGyro() {
    this.gyro.reset();
  }
  
  public void resetEncoders() {
    this.FRONT_LEFT.setPosition(0.0);
    this.FRONT_RIGHT.setPosition(0.0);
  }
}

package com.nutrons.nu17.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import com.nutrons.nu17.Robot;
import com.nutrons.nu17.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import lib.EncoderWrapper;
import lib.HoldPID;

public class Shooter extends Subsystem {
  public final double SHOOTER_SPEED = 10.0;

  public final CANTalon SHOOTER = new CANTalon(RobotMap.SHOOTER);

  // TODO: tune these constants
  public static double P_SHOOT = 0.025;
  public static double I_SHOOT = 0.0;
  public static double D_SHOOT = 0.01;
  public static double F_SHOOT = 0.025;

  public Shooter() {
    this.SHOOTER.configNominalOutputVoltage(+0.0f, -0.0f);
    this.SHOOTER.configPeakOutputVoltage(+12.0f, 0.0f);
    this.SHOOTER.configEncoderCodesPerRev((int) (256 / 0.14));
    this.SHOOTER.configEncoderCodesPerRev((int) (256 / 0.14));
    this.SHOOTER.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    this.SHOOTER.setP(P_SHOOT);
    this.SHOOTER.setI(I_SHOOT);
    this.SHOOTER.setD(D_SHOOT);
    this.SHOOTER.setF(F_SHOOT);

  }

  public void initDefaultCommand() {}

  /**
   * Runs shooter at given param power.
   * 
   * @param power Speed to run the shooting motor.
   */
  public void runShooter(double power) {
    this.SHOOTER.set(power);
  }

  /**
   * Cuts the power to the shooter, setting it to 0.0.
   */
  public void stopShooter() {
    runShooter(0.0);
  }

  /**
   * Resets Encoder.
   */
  public void resetEncoder() {
    this.SHOOTER.setEncPosition(0);
  }
}

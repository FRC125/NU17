package com.nutrons.nu17.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import com.nutrons.nu17.Robot;
import com.nutrons.nu17.RobotMap;
import com.nutrons.nu17.commands.ShootShooterCmd;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.EncoderWrapper;
import lib.HoldPid;

// Travis liked the steak
public class Shooter extends Subsystem {

  
  public static double SHOOTER_SPEED = 10.0;

  public CANTalon shooter = new CANTalon(RobotMap.SHOOTER_MOTOR);
  
  // TODO: tune these constants
  public static double P_SHOOT = 0.025;
  public static double I_SHOOT = 0.0;
  public static double D_SHOOT = 0.01;
  public static double F_SHOOT = 0.025;

  /**
   * Constructs an instance of shooter.
   */
  public Shooter() {
    this.shooter.configNominalOutputVoltage(+0.0f, -0.0f);
    this.shooter.configPeakOutputVoltage(+12.0f, 0.0f);
    this.shooter.configEncoderCodesPerRev((int) (256 / 0.14));
    this.shooter.configEncoderCodesPerRev((int) (256 / 0.14));
    this.shooter.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    this.shooter.setP(P_SHOOT);
    this.shooter.setI(I_SHOOT);
    this.shooter.setD(D_SHOOT);
    this.shooter.setF(F_SHOOT);

  }
  /**
   * Sets the default command to the ShootShooterCmd.
   */
  public void initDefaultCommand() {
    setDefaultCommand(new ShootShooterCmd());

  }

  /**
   * Changes to manual and sets the speed.
   * 
   * @param speed Speed of shooter.
   */
  public void setOpenLoop(double speed) {
    this.shooter.changeControlMode(TalonControlMode.PercentVbus);
    this.shooter.set(speed);
  }

  /**
   * Changes to closed loop. Sets the RPM from the shooter.
   */
  public void setRpm(double rpm) {
    this.shooter.changeControlMode(TalonControlMode.Speed);
    this.shooter.set(rpm);
  }

  /**
   * Cuts the power to the shooter, setting it to 0.0.
   */
  public void stopShooter() {
    setOpenLoop(0.0);
  }

  /**
   * Gets RPM from shooter.
   */
  public double getRpm() {
    return this.shooter.getSpeed();
  }

  /**
   * Resets Encoder.
   */
  public void resetEncoder() {
    this.shooter.setEncPosition(0);
  }

}

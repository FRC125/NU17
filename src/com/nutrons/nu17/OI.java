package com.nutrons.nu17;

import com.nutrons.nu17.RobotMap;
import com.nutrons.nu17.commands.GroundIntakeCmd;
import com.nutrons.nu17.commands.GroundIntakeSpitCmd;
import com.nutrons.nu17.commands.LowerGearPlacerCmd;
import com.nutrons.nu17.commands.RaiseGearPlacerCmd;
import com.nutrons.nu17.commands.ShootShooterCmd;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import lib.Utils;

/**
 * Class to define joysticks and map all buttons to commands.
 */
public class OI {

  private final Button SHOOT = new JoystickButton(OPERATOR_PAD, RobotMap.JOYSTICK_LEFT_BUMPER);
  private final Button INTAKE = new JoystickButton(OPERATOR_PAD, RobotMap.JOYSTICK_A);
  private final Button INTAKE_SPIT = new JoystickButton(OPERATOR_PAD, RobotMap.JOYSTICK_B);
  private final Button RAISE_PLACER = new JoystickButton(OPERATOR_PAD, RobotMap.JOYSTICK_Y);
  private final Button LOWER_PLACER = new JoystickButton(OPERATOR_PAD, RobotMap.JOYSTICK_X);

  public static final Joystick DRIVER_PAD = new Joystick(RobotMap.JOYSTICK1);
  public static final Joystick OPERATOR_PAD = new Joystick(RobotMap.JOYSTICK2);

  public OI() {
    this.RAISE_PLACER.whenPressed(new RaiseGearPlacerCmd());
    this.LOWER_PLACER.whenPressed(new LowerGearPlacerCmd());
    this.SHOOT.whenPressed(new ShootShooterCmd());
    this.INTAKE.whenPressed(new GroundIntakeCmd());
    this.INTAKE_SPIT.whenPressed(new GroundIntakeSpitCmd());
  }

  /**
   * @return driver's left joystick y value
   */
  public double getLeftJoystickY() {
    return Utils.deadband(DRIVER_PAD.getRawAxis(1), RobotMap.JOYSTICK_DEADBAND, 0.0);
  }

  /**
   * @return driver's right joystick x value
   */
  public double getRightJoystickX() {
    return Utils.deadband(DRIVER_PAD.getRawAxis(4), RobotMap.JOYSTICK_DEADBAND, 0.0);
  }

  /**
   * @return driver's right joystick y value
   */
  public double getRightJoystickY() {
    return Utils.deadband(DRIVER_PAD.getRawAxis(5), RobotMap.JOYSTICK_DEADBAND, 0.0);
  }
}

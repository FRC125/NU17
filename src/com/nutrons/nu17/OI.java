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

  private final Button shoot = new JoystickButton(OPERATOR_PAD, RobotMap.JOYSTICK_LEFT_BUMPER);
  private final Button intake = new JoystickButton(OPERATOR_PAD, RobotMap.JOYSTICK_A);
  private final Button intakeSpit = new JoystickButton(OPERATOR_PAD, RobotMap.JOYSTICK_B);
  private final Button raisePlacer = new JoystickButton(OPERATOR_PAD, RobotMap.JOYSTICK_Y);
  private final Button lowerPlacer = new JoystickButton(OPERATOR_PAD, RobotMap.JOYSTICK_X);

  public static final Joystick DRIVER_PAD = new Joystick(RobotMap.JOYSTICK1);
  public static final Joystick OPERATOR_PAD = new Joystick(RobotMap.JOYSTICK2);

  /**
   * Creates Joysticks and assigns buttons.
   */
  public OI() {
    this.raisePlacer.whenPressed(new RaiseGearPlacerCmd());
    this.lowerPlacer.whenPressed(new LowerGearPlacerCmd());
    this.shoot.whenPressed(new ShootShooterCmd());
    this.intake.whenPressed(new GroundIntakeCmd());
    this.intakeSpit.whenPressed(new GroundIntakeSpitCmd());
  }

  /**
   * @return driver's left joystick y value.
   */
  public double getLeftJoystickY() {
    return Utils.deadband(DRIVER_PAD.getRawAxis(1), RobotMap.JOYSTICK_DEADBAND, 0.0);
  }

  /**
   * @return driver's right joystick x value.
   */
  public double getRightJoystickX() {
    return Utils.deadband(DRIVER_PAD.getRawAxis(4), RobotMap.JOYSTICK_DEADBAND, 0.0);
  }

  /**
   * @return driver's right joystick y value.
   */
  public double getRightJoystickY() {
    return Utils.deadband(DRIVER_PAD.getRawAxis(5), RobotMap.JOYSTICK_DEADBAND, 0.0);
  }
}

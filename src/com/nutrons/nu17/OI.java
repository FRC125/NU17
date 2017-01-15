package com.nutrons.nu17;

import com.nutrons.nu17.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import lib.Utils;

/**
 * Class to define joysticks and map all buttons to commands.
 */
public class OI {

	private Button shootShooterCmd = new JoystickButton(this.operatorPad, RobotMap.JOYSTICK_A);
	private Button GroundIntake = new JoystickButton(this.operatorPad, RobotMap.JOYSTICK_B);
	private Button GroundIntakeSpit = new JoystickButton(this.operatorPad, RobotMap.JOYSTICK_X);
	private Button changePlacerPosition = new JoystickButton(this.operatorPad, RobotMap.JOYSTICK_Y);

	public Joystick driverPad = new Joystick(RobotMap.JOYSTICK1);
	public Joystick operatorPad = new Joystick(RobotMap.JOYSTICK2);

	public OI() {
		this.changePlacerPosition.whenPressed(new ChangePlacerPositionCmd());
		this.shootShooterCmd.whenPressed(new ShootShooterCmd());
		this.GroundIntake.whenPressed(new GroundIntakeCmd());
		this.GroundIntakeSpit.whenPressed(new GroundIntakeSpitCmd());
	}

	/**
	 * @return driver's left joystick y value
	 */
	public double getLeftJoystickY() {
		return Utils.deadband(this.driverPad.getRawAxis(1), 0.005, 0.0);
	}

	/**
	 * @return driver's right joystick x value
	 */
	public double getRightJoystickX() {
		return Utils.deadband(this.driverPad.getRawAxis(4), 0.05, 0.0);
	}

	/**
	 * @return driver's right joystick y value
	 */
	public double getRightJoystickY() {
		return Utils.deadband(this.driverPad.getRawAxis(5), 0.05, 0.0);
	}
}

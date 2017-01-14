package com.nutrons.nu17;

import com.nutrons.nu17.commands.ChangePlacerPositionCmd;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import lib.Utils;

public class OI {

	private Button shootShooterCmd = new JoystickButton(this.operatorPad, 0);
	private Button GroundIntake = new JoystickButton(this.operatorPad, 1);
	private Button GroundIntakespit = new JoystickButton(this.operatorPad, 2);
	private Button changePlacerPosition = new JoystickButton(this.operatorPad, 3);

	public Joystick driverPad = new Joystick(1);
	public Joystick operatorPad = new Joystick(2);

	public OI() {
		this.changePlacerPosition.whenPressed(new ChangePlacerPositionCmd());
	}

	/**
	 * Returns the y axis of driver's left joystick.
	 * 
	 * @return driver's left joystick y value
	 */
	public double getLeftJoystickY() {
		return Utils.deadband(this.driverPad.getRawAxis(1), 0.005, 0.0);

	}

	/**
	 * Returns the x axis of driver's right joystick.
	 * 
	 * @return driver's right joystick x value
	 */
	public double getRightJoystickX() {
		return Utils.deadband(this.driverPad.getRawAxis(4), 0.05, 0.0);
	}

	/**
	 * Return the y axis of driver's right joystick.
	 * 
	 * @return driver's right joystick y value
	 */
	public double getRightJoystickY() {
		return Utils.deadband(this.driverPad.getRawAxis(5), 0.05, 0.0);
	}
}
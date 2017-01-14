package com.nutrons.nu17;

import com.nutrons.nu17.commands.ChangePlacerPositionCmd;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import lib.Utils;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	/**
	 * Make robot shoot
	 */
	private Button shootShooterCmd = new JoystickButton(this.operatorPad, 0);

	/**
	 * Ground intake
	 */
	private Button GroundIntake = new JoystickButton(this.operatorPad, 1);

	/**
	 * ground intake spit
	 */
	private Button GroundIntakespit = new JoystickButton(this.operatorPad, 2);
	private Button changePlacerPosition = new JoystickButton(this.operatorPad, 3);

	/**
	 * drives the robot using joystick values
	 */
	public Joystick driverPad = new Joystick(1);
	public Joystick operatorPad = new Joystick(2);

	public OI() {
		this.changePlacerPosition.whenPressed(new ChangePlacerPositionCmd());
	}

	/**
	 * Left joystick value
	 * 
	 * @return
	 */
	public double getLeftJoystickY() {
		return Utils.deadband(this.driverPad.getRawAxis(1), 0.005, 0.0);

	}

	/**
	 * right joystick value
	 * 
	 * @return
	 */
	public double getRightJoystickX() {
		return Utils.deadband(this.driverPad.getRawAxis(4), 0.05, 0.0);
	}

	public double getRightJoystickY() {
		return Utils.deadband(this.driverPad.getRawAxis(5), 0.05, 0.0);
	}
}
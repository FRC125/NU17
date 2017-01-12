package com.nutrons.nu17;

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
	 * make robot shoot
	 */
	private Button shootShooterCmd = new JoystickButton(null, 0);
	/**
	 * ground intake
	 */
	private Button GroundIntake = new JoystickButton(null, 1);
	/** 
	 * ground intake spit
	 */
	private Button GroundIntakespit = new JoystickButton(null, 2);
	/** 
	 * drives the robot using joystick values
	 */
	public Joystick driverPad = new Joystick(1);
	/**
	 * Left joystick value 
	 * @return
	 */
	public double getLeftJoystickY() {
		return Utils.deadband(this.driverPad.getRawAxis(1), 0.005, 0.0);
		
	}
	/**
	 * right joystick value 
	 * @return
	 */
	public double getRightJoystickX() {
		return Utils.deadband(this.driverPad.getRawAxis(4), 0.05, 0.0);
	}
}

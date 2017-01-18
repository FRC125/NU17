package org.usfirst.frc.team125.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team125.robot.commands.DriveTankCmd;
import org.usfirst.frc.team125.robot.commands.ShootCmd;

public class OI {
	public Joystick stick = new Joystick(RobotMap.joyStickPort);
	private Button fireButton = new JoystickButton(stick, 8);
	
	public OI(){
		fireButton.whenPressed(new ShootCmd());
	}
	
	public double getJoyX(){
		return stick.getX();
	}

	public double getJoyY(){
		return stick.getY();
	}
}
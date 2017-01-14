package com.nutrons.nu17.subsystems;

import com.nutrons.nu17.RobotMap;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GroundIntake extends Subsystem {
	
	private Talon rollerA = new Talon(RobotMap.ROLLER_A);
	private Talon rollerB = new Talon(RobotMap.ROLLER_B);

	public GroundIntake() {
		//empty
	}

	public GroundIntake(int PORT_A, int PORT_B) {
		rollerA = new Talon(PORT_A);
		rollerB = new Talon(PORT_B);
	}

	private Ultrasonic isBallCenter = new Ultrasonic(RobotMap.ULTRASONIC_RX, RobotMap.ULTRASONIC_TX);

	// TODO: untuned constant
	private final double BALL_CENTER_MARGIN = 5.0;

	public void initDefaultCommand() {
		//empty
	}

	/**
	 * Drive's rollerA given param power.
	 * 
	 * @param power double from 0.0 to 1.0 to set rollerA motor to.
	 */
	public void driveRollerA(double power) {
		this.rollerA.set(power);
	}

	/**
	 * Drive's RollerB given param power
	 * 
	 * @param power double from 0.0 to 1.0 to set rollerB motor to.
	 */
	public void driveRollerB(double power) {
		this.rollerB.set(power);
	}

	/**
	 * Stops rollerA
	 */
	public void stopRollerA() {
		driveRollerA(0.0);
	}

	/**
	 * Stops rollerB
	 */
	public void stopRollerB() {
		driveRollerB(0.0);
	}

	/**
	 * Returns a boolean checking if the US Sensors value in inches is less then
	 * the give margin
	 * 
	 * @return true if ball will go into robot once intake is run.
	 */
	public boolean isBallCentered() {
		return (isBallCenter.getRangeInches() < BALL_CENTER_MARGIN);
	}
}

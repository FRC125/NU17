package com.nutrons.nu17.subsystems.Intake;

import com.nutrons.nu17.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GroundIntake extends Subsystem {
	
	private final Talon ROLLER_1 = new Talon(RobotMap.ROLLER_A);
	private final Talon ROLLER_2 = new Talon(RobotMap.ROLLER_B);

	private final Ultrasonic BALL_CENTER = new Ultrasonic(
			RobotMap.ULTRASONIC_RX, 
			RobotMap.ULTRASONIC_TX);

	// TODO: tune these constants
	private final double BALL_CENTER_MARGIN = 5.0;
	
	public GroundIntake() {
		//empty
	}

	public void initDefaultCommand() {
		//empty
	}

	/**
	 * Drive's ROLLER_1 given param power.
	 * 
	 * @param power Speed that the first roller is set to.
	 */
	public void driveRoller1(double power) {
		this.ROLLER_1.set(power);
	}

	/**
	 * Drive's ROLLER_2 given param power.
	 * 
	 * @param power Speed that the second roller is set to.
	 */
	public void driveRoller2(double power) {
		this.ROLLER_2.set(power);
	}

	/**
	 * Stops ROLLER_1.
	 */
	public void stopRoller1() {
		driveRoller1(0.0);
	}

	/**
	 * Stops ROLLER_2.
	 */
	public void stopRoller2() {
		driveRoller2(0.0);
	}

	/**
	 * Returns a boolean checking if the US Sensors value in inches is less then
	 * the give margin.
	 * 
	 * @return Tells us whether the ball is directly in front of the robot and centered.
	 */
	public boolean isBallCentered() {
		return (BALL_CENTER.getRangeInches() < BALL_CENTER_MARGIN);
	}
	/**
	 * Checks for a ball in the intake
	 * @return Whether there is a ball in the center or not 
	 */
	public boolean noBallCheck() {
		if(isBallCentered()){
			return false;
		}
		return true;
	}
}

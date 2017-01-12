package com.nutrons.nu17.subsystems;

import com.nutrons.nu17.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GroundIntake extends Subsystem {
	// Motors
	private Talon rollerA = new Talon(RobotMap.ROLLER_A);
	private Talon rollerB = new Talon(RobotMap.ROLLER_B);
	
	// Sensors
	private Ultrasonic isBallCenter = new Ultrasonic(RobotMap.ULTRASONIC_RX, RobotMap.ULTRASONIC_TX);
	
	//Constants
	private final double BALL_CENTER_MARGIN = 5.0;

    public void initDefaultCommand() {
        
    }
    /**
     * 
     * Drive's rollerA given param power
     * @param power
     */
    public void driveRollerA(double power) {
    	this.rollerA.set(power);
    }
    /**
     * 
     * Drive's RollerB given param power
     * @param power
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
    * Returns a boolean checking if the US Sensors value in inches is less then the give margin
    * @return
    */
    public boolean isBallCentered() {
    	return (isBallCenter.getRangeInches() < BALL_CENTER_MARGIN);
    }
}


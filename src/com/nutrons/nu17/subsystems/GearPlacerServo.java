package com.nutrons.nu17.subsystems;

import com.nutrons.nu17.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Similar to {@link GearPlacer} class but uses a servo instead.
 */
public class GearPlacerServo extends Subsystem {

	private final Servo PLACER = new Servo(RobotMap.GEAR_PLACER_SERVO);

	public void initDefaultCommand() {
		//empty
	}
	
	/**
	 * Sets the gear placer to a position.
	 * 
	 * @param position Where the gear placer will be set to.
	 */
	public void setPosition(double position) {
		PLACER.set(position);
	}

	/**
	 * Returns the current position of the gear placer.
	 * 
	 * @return Gives us where the gear placer is at this moment.
	 */
	public double getPosition() {
		return PLACER.get();
	}

	public void stop() {
		this.setPosition(this.getPosition());
	}
}


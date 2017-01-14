package com.nutrons.nu17.subsystems;

import com.nutrons.nu17.RobotMap;

//import edu.wpi.first.wpilibj.PIDSource;
//import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearPlacer extends Subsystem {

	public Talon gearPlacer = new Talon(RobotMap.PLACER);

	public void initDefaultCommand() {
		//empty
	}
	
	/**
	 * Sets the gear placer to position.
	 * 
	 * @param position double from 0.0 to 1.0 to determine where gear placer is.
	 */
	public void set(double position) {
		gearPlacer.setPosition(position);
	}

	/**
	 * Returns the current position of the gear placer.
	 * 
	 * @return double from 0.0 to 1.0 of where gear placer is.
	 */
	public double getPosition() {
		return gearPlacer.getPosition();
	}
}
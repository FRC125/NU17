package com.nutrons.nu17.subsystems;

import com.nutrons.nu17.RobotMap;

//import edu.wpi.first.wpilibj.PIDSource;
//import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author sytect
 */
public class GearPlacer extends Subsystem {

    public Talon gearPlacer = new Talon(RobotMap.PLACER);
    
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void set(double position){
    	gearPlacer.setPosition(position);
    }
    
    public double getPosition() {
    	return gearPlacer.getPosition();
    }
    
    /* encoder unknown
    private class EncoderWrapper implements PIDSource {

		@Override
		public void setPIDSourceType(PIDSourceType pidSource) {
			
		}

		@Override
		public PIDSourceType getPIDSourceType() {
			return null;
		}

		@Override
		public double pidGet() {
			return 0;
		}
    	
    }*/
}
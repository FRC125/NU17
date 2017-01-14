package com.nutrons.nu17.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {
	 DigitalInput MicroSwitch = new DigitalInput(0);
	
    private Talon Climb = new Talon(3);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void runClimb (double power){
    	this.Climb.set(1.0);
    }
    public void stopClimb (){
    	if(MicroSwitch.get()){
    		this.Climb.set(0);
    	}
    	else{
    		this.Climb.set(1);
    	}
    	
    }
}


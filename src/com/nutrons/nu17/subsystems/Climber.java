package com.nutrons.nu17.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Kevin Henriquez
 */
public class Climber extends Subsystem {
	public DigitalInput MicroSwitch = new DigitalInput(0);
	
    private Talon Climb = new Talon(3);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void runClimb (double power){
    	this.Climb.set(1.0);
    }
<<<<<<< HEAD
    public void stopClimb (){
    	if(MicroSwitch.get()){
    		this.Climb.set(0);
=======
    public void padCheck  (){
    	if(MicroSwitch.get()){
    		stopClimb(0);
>>>>>>> a9c6c6fa8ebb02724ac1e283a608a444bc3a0ccf
    	}
    	else{
    		this.Climb.set(1.0);
    	}
    	
    }
    public void stopClimb (double power){
    	this.Climb.set(0);
    }
}
      
    






    
      
      
      
      
      

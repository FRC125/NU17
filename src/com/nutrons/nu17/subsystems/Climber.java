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
    public void padCheck  (){
    	if(MicroSwitch.get()){
    		stopClimb(0);
    	}
    	else{
    		this.Climb.set(1.0);
    	}
    	
    }
    public void stopClimb (double power){
    	this.Climb.set(0);
    }




  
      
        
      

      
        
      

      
        

  Edit column
  
    
    
    
    

    
      
        Column name
      
      
        
      
      
        
      
    

    
      
        Update column
      
    

    
      
        Delete column
      
      


      
    
      Blocked
      2
    
      
        
          
          
          
            
          Add note
      
  

  

  
  
    
  
  
    
      
        
          Copy Card URL
        
        Link to Card
      

      
      
    
      Convert to issue
    

  
    Convert note to issue
    
  
  
    Title
    
  
  
    Body
    
  
  
    Convert to issue
  

  

  Edit note
  
  
      
      
        Delete note
      

    
  



  



  PID Tuning, waiting on mechanical.
  Added by Brinbri



  
  Edit note
  
    
    
      
        Note
      
      
        PID Tuning, waiting on mechanical.   
        
      
      
        
      
    
    
      
        Save note
      
    






  
  
    
  
  
    
      
        
          Copy Card URL
        
        Link to Card
      

      
      
    
      Convert to issue
    

  
    Convert note to issue
    
  
  
    Title
    
  
  
    Body
    waiting on commands
  
  
    Convert to issue
  

  

  Edit note
  
  
      
      
        Delete note
      

    
  



  



  Controller mapping
waiting on commands
  Added by KevinHenriquez



  
  Edit note
  
    
    
      
        Note
      
      
        Controller mapping 
waiting on commands

        
      
      
        
      
    
    
      
        Save note
      
    






    
      
      
      
      
      

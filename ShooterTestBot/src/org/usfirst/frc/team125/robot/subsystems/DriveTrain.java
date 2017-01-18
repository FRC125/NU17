package org.usfirst.frc.team125.robot.subsystems;

import org.usfirst.frc.team125.robot.commands.DriveTankCmd;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {

   //public CANTalon motor1 = new CANTalon(RobotMap.motor1Port);
   //public CANTalon motor2 = new CANTalon(RobotMap.motor2Port);
   
   public DriveTrain(){
   		//motor1.enable();
   		//motor2.enable();
   }

    public void initDefaultCommand() {
        new DriveTankCmd();
    }	
    
    public void driveTank(double x, double y){
    	//motor1.set(x);
    	//motor2.set(y);
    }
    
    public void stop(){
    	//motor1.set(0);
    	//motor2.set(0);
    }
}
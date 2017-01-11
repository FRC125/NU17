package com.nutrons.nu17.subsystems;

import com.nutrons.nu17.Robot;
import com.nutrons.nu17.RobotMap;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.util.*;

/**
 * @author Josh Young
 */
public class Shooter extends Subsystem {
	//Motors
	private Talon shooter = new Talon(0);
	
	// PID Constants
	public double P_SHOOT = 0.025;
	public double I_SHOOT = 0.0;
	public double D_SHOOT = 0.01;
	
	//PID Controller Stuff
	private PIDController ShootSpeedControl = new PIDController(this.P_SHOOT,this.I_SHOOT,this.D_SHOOT,new EncoderWrapper(), new HoldShooterOutput());
	public static double holdShoot;
		

    
	
	public void initDefaultCommand() {
         
}
/**
 * Runs shooter at given param double "power"	
 * @param power
 */
public void runShooter(double power) {
	this.shooter.set(power);
}
/**
 *Cuts the power to the shooter setting it to 0.0
 */
public void stopShooter(){
	runShooter(0.0);
}
/** This creates the source and retrieves the data from the PID calculation
 * 
 *
 */
private class EncoderWrapper implements PIDSource {
	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		// Encoder Value
		//Harambe was just a gorilla
	}
	@Override
	public PIDSourceType getPIDSourceType() {
	return PIDSourceType.kDisplacement;
	}
	@Override
	public double pidGet() {
		return Robot.shooter.shooter.getPosition();
	}
	
	}
/** This holds the output from the PID Controller
 * 
 *
 */
private class HoldShooterOutput implements PIDOutput {
	
	@Override
	public void pidWrite(double output) {
		holdShoot = output;
		
	}
	
}
}

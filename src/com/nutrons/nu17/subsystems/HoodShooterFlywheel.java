package com.nutrons.nu17.subsystems;

import com.nutrons.nu17.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class HoodShooterFlywheel extends Subsystem {

	private Talon Flywheel_L = new Talon(RobotMap.FLY_WHEEL_L);
	private Talon FLywheel_R = new Talon(RobotMap.FLY_WHEEL_R);
	private Encoder Turn_r = new Encoder(RobotMap.ENCODER_FLY_R,2);
	private Encoder Turn_l = new Encoder(RobotMap.ENCODER_FLY_L,3);
	
	public PIDController AngleShotPID = new PIDController(
			this.P_TURN,
			this.I_TURN,
			this.D_TURN,
			new TurnSourcePID(),
			new Turn_Out_PID());

	// TODO tune these constants
	private final double P_TURN = 0;
	private final double I_TURN = 0;
	private final double D_TURN = 0;

	public void HoodShooterFLywheel(){
	
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
   /**
    * drive the FLywheel
    * @param left
    * @param right
    */
    
    public void turnShot(double left, double right){
    	this.Flywheel_L.set(left);
    	this.FLywheel_R.set(right);
    	
    }
  
    /**
     * stops flywheel
     */
    public void stop(){
    	this.turnShot(0,0);
    }
    
    /**
     * resets encoders
     */
    
    public void resetEncoder(){
    	this.Turn_l.reset();
    	this.Turn_r.reset();
    }
    
private class TurnSourcePID implements PIDSource{

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PIDSourceType getPIDSourceType() {
		// TODO Auto-generated method stub
		return PIDSourceType.kDisplacement;
	}

	@Override
	public double pidGet() {
		// TODO Auto-generated method stub
		return 0;// waiting for encoder and actual flywheel
	}
    
private class Turn_Out_PID implements PIDOutput{

	@Override
	public void pidWrite(double output) {
			turnShot(output,output);
		
			}
		}
	}
}








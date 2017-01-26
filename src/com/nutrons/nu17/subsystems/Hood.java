package com.nutrons.nu17.subsystems;

import com.nutrons.nu17.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

/**
 *
 */
public class Hood extends Subsystem {
	private final Talon TiltHood = new Talon (RobotMap.HOOD);
	private final Encoder HoodPath = new Encoder(
			RobotMap.HOOD_ENCODER_1, 
			RobotMap.HOOD_ENCODER_2); 
// TODO tune these constants
	private static final double P_ANGLE = 0;
	private static final double I_ANGLE  = 0;
	private static final double D_ANGLE = 0;

	public final PIDController SHOT_ANGLE_PID =  new PIDController (
			P_ANGLE, 
			I_ANGLE, 
			D_ANGLE, 
			new ShotSourcePID(), 
			new ShotAngleOutput());


	
	
	public void initDefaultCommand() {
		// empty
	}
/*
 * 	sets and controls angle of hood
 */
	public void angleAdjust(double angle){
		this.TiltHood.set(angle);
	}
	/*
	 * resets hood angle
	 */
	public void resetAdjust(double angle){
		this.TiltHood.set(-angle);
	}
	private class ShotSourcePID implements PIDSource{

		@Override
		public void setPIDSourceType(PIDSourceType pidSource) {
			// empty
			
		}

		@Override
		public PIDSourceType getPIDSourceType() {
			return PIDSourceType.kDisplacement;
		}

		@Override
		public double pidGet() {
			return HoodPath.getDistance();
		}
	}
		
		
		private class ShotAngleOutput implements PIDOutput{

			@Override
			public void pidWrite(double output) {
				angleAdjust(output);
				
				
			}
			
		}
		
	}



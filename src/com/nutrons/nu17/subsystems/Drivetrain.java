package com.nutrons.nu17.subsystems;

import com.nutrons.nu17.RobotMap;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Brian Estevez
 */
public class Drivetrain extends Subsystem {
	
	private Talon driveLeftA = new Talon(RobotMap.DRIVE_LEFT_A);
	private Talon driveLeftB = new Talon(RobotMap.DRIVE_LEFT_B);
	private Talon driveRightA = new Talon(RobotMap.DRIVE_RIGHT_A);
	private Talon driveRightB = new Talon(RobotMap.DRIVE_RIGHT_B);
	
	private Encoder driveEncoder1 = new Encoder(1, 2);
	private Encoder driveEncoder2 = new Encoder(3, 4);

	// TODO tune these constants
	public double P_DISTANCE = 0.025;
	public double I_DISTANCE = 0.0;
	public double D_DISTANCE = 0.01;

	public PIDController driveDistance = new PIDController(
			this.P_DISTANCE, 
			this.I_DISTANCE, 
			this.D_DISTANCE,
			new DriveSourcePID(), 
			new DriveOutputPID());

	public Drivetrain() {
		driveEncoder1.setDistancePerPulse(1);
		driveEncoder2.setDistancePerPulse(1);
	}

	public void initDefaultCommand() {
		//empty
	}

	/**
	 * Powers all the motor.
	 * 
	 * @param leftA Powers the Left A motor.
	 * @param leftB Powers the Left B motor.
	 * @param rightA Powers the Right A motor.
	 * @param rightB Powers the Right B motor.
	 */
	public void drive(
			double leftA, 
			double leftB, 
			double rightA, 
			double rightB) {
		this.driveLeftA.set(leftA);
		this.driveLeftB.set(leftB);
		this.driveRightA.set(rightA);
		this.driveRightB.set(rightB);
	}

	/**
	 * Stops the drivetrain.
	 */
	public void stop() {
		this.drive(0, 0, 0, 0);
	}

	public void resetEncoder() {
		this.driveEncoder1.reset();
		this.driveEncoder2.reset();
	}

	private class DriveSourcePID implements PIDSource {

		@Override
		public void setPIDSourceType(PIDSourceType pidSource) {
			//empty
		}

		@Override
		public double pidGet() {
			return driveEncoder1.getDistance();
		}

		@Override
		public PIDSourceType getPIDSourceType() {
			return null;
		}
	}

	private class DriveOutputPID implements PIDOutput {

		@Override
		public void pidWrite(double output) {
			drive(output, -output, output, -output);
		}
	}
}

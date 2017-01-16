package com.nutrons.nu17.subsystems;

import com.nutrons.nu17.RobotMap;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {
	
	private final Talon FRONT_LEFT_WHEEL = new Talon(RobotMap.FRONT_LEFT);
	private final Talon BACK_LEFT_WHEEL = new Talon(RobotMap.FRONT_RIGHT);
	private final Talon FRONT_RIGHT_WHEEL = new Talon(RobotMap.BACK_LEFT);
	private final Talon BACK_RIGHT_WHEEL = new Talon(RobotMap.BACK_RIGHT);
	
	private final Encoder ENCODER_1 = new Encoder(
			RobotMap.DT_ENCODER_1, 
			RobotMap.DT_ENCODER_2);
	private final Encoder ENCODER_2 = new Encoder(
			RobotMap.DT_ENCODER_3, 
			RobotMap.DT_ENCODER_4);

	// TODO tune these constants
	private final double P_DISTANCE = 0.025;
	private final double I_DISTANCE = 0.0;
	private final double D_DISTANCE = 0.01;

	private final PIDController DISTANCE_PID = new PIDController(
			this.P_DISTANCE, 
			this.I_DISTANCE, 
			this.D_DISTANCE,
			new DriveSourcePID(), 
			new DriveOutputPID());

	public Drivetrain() {
		ENCODER_1.setDistancePerPulse(1);
		ENCODER_2.setDistancePerPulse(1);
	}

	public void initDefaultCommand() {
		//empty
	}

	/**
	 * Drives the robot depending on speed of each motor.
	 * 
	 * @param leftA Speed of the Left A motor.
	 * @param leftB Speed of the Left B motor.
	 * @param rightA Speed of the Right A motor.
	 * @param rightB Speed of the Right B motor.
	 */
	public void drive(
			double leftA, 
			double leftB, 
			double rightA, 
			double rightB) {
		this.FRONT_LEFT_WHEEL.set(leftA);
		this.BACK_LEFT_WHEEL.set(leftB);
		this.FRONT_RIGHT_WHEEL.set(rightA);
		this.BACK_RIGHT_WHEEL.set(rightB);
	}

	/**
	 * Stops the drivetrain.
	 */
	public void stop() {
		this.drive(0, 0, 0, 0);
	}

	public void resetEncoder() {
		this.ENCODER_1.reset();
		this.ENCODER_2.reset();
	}

	private class DriveSourcePID implements PIDSource {

		@Override
		public void setPIDSourceType(PIDSourceType pidSource) {
			//empty
		}

		@Override
		public double pidGet() {
			return ENCODER_1.getDistance();
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

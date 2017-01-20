package com.nutrons.nu17.subsystems;

import com.nutrons.nu17.Robot;
import com.nutrons.nu17.RobotMap;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DrivetrainGyro extends Subsystem {

	private final Talon FRONT_RIGHT = new Talon(RobotMap.FRONT_RIGHT);
	private final Talon FRONT_LEFT = new Talon(RobotMap.FRONT_LEFT);
	private final Talon BACK_RIGHT = new Talon(RobotMap.BACK_RIGHT);
	private final Talon BACK_LEFT = new Talon(RobotMap.BACK_LEFT);

	private final AnalogGyro GYRO = new AnalogGyro(RobotMap.DRIVETRAIN_HEADING_GYRO);
	
	// TODO: tune these constants
	private static final double P_DRIVE = 0;
	private static final double I_DRIVE = 0;
	private static final double D_DRIVE = 0;
	
	// TODO: tune these constants
	private static final double P_HEADING = 0;
	private static final double I_HEADING = 0;
	private static final double D_HEADING = 0;

	public final PIDController DISTANCE_PID = new PIDController(
			P_DRIVE, 
			I_DRIVE, 
			D_DRIVE,
			new EncoderWrapper(), 
			new DriveOutput());
	public final PIDController HEADING_PID = new PIDController(
			P_HEADING, 
			I_HEADING, 
			D_HEADING,
			new GyroWrapper(), 
			new GyroOutput());

	private double headingGyro;
	
	public DrivetrainGyro() {
	}

	public void initDefaultCommand() {
		//empty
	}

	/**
	 * Stops driving.
	 */
	public void stop() {
		this.driveLR(0.0, 0.0);
	}

	/**
	 * Drives the robot based on speeds of left and right wheels.
	 * 
	 * @param leftPower Speed that the left motors are set to.
	 * @param rightPower Speed that right motors are set to.
	 */
	public void driveLR(double leftPower, double rightPower) {
		this.FRONT_LEFT.set(leftPower);
		this.FRONT_RIGHT.set(-rightPower);
		this.BACK_LEFT.set(leftPower);
		this.BACK_RIGHT.set(-rightPower);
	}
	
	/**
	 * Returns the angle, in degrees, away from the initial gyro position.
	 * 
	 * @return angle Angular displacement from the initial gyro position.
	 */
	public double getAngleInDegrees() {
		return this.GYRO.getAngle();
	}

	private class GyroWrapper implements PIDSource {

		@Override
		public PIDSourceType getPIDSourceType() {
			return PIDSourceType.kDisplacement;
		}

	

		@Override
		public void setPIDSourceType(PIDSourceType PIDSource) {
			//empty
		}



		@Override
		public double pidGet() {
			// TODO Auto-generated method stub
			return 0;
		}
	}

	private class GyroOutput implements PIDOutput {

		@Override
		public void pidWrite(double wheel) {
			headingGyro = wheel;
		}
	}

	private class EncoderWrapper implements PIDSource {

		@Override
		public void setPIDSourceType(PIDSourceType pidSource) {
			//empty
		}

		@Override
		public PIDSourceType getPIDSourceType() {
			return PIDSourceType.kDisplacement;
		}

		@Override
		public double pidGet() {
			return Robot.DRIVETRAIN.backRight.getPosition();
		}
	}

	private class DriveOutput implements PIDOutput {

		@Override
		public void pidWrite(double output) {
			driveLR(output, output);
		}
	}
}

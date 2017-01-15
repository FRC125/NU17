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

	private Talon frontRight = new Talon(RobotMap.FRONT_RIGHT);
	private Talon frontLeft = new Talon(RobotMap.FRONT_LEFT);
	private Talon backRight = new Talon(RobotMap.BACK_RIGHT);
	private Talon backLeft = new Talon(RobotMap.BACK_LEFT);
	
	private Encoder driveEncoderA = new Encoder(
			RobotMap.ENCODERA1, 
			RobotMap.ENCODERA2);
	private Encoder driveEncoderB = new Encoder(
			RobotMap.ENCODERB1, 
			RobotMap.ENCODERB2);

	private AnalogGyro driveGyro = new AnalogGyro(RobotMap.GYRO);

	public PIDController driveDistanceControl = new PIDController(
			this.P_DRIVE, 
			this.I_DRIVE, 
			this.D_DRIVE,
			new EncoderWrapper(), 
			new DriveOutput());
	public PIDController holdHeading = new PIDController(
			this.P_HEADING, 
			this.I_HEADING, 
			this.D_HEADING,
			new GyroWrapper(), 
			new GyroOutput());

	private volatile double headingGyro;
	
	// TODO tune these constants
	private final double P_DRIVE = 0;
	private final double I_DRIVE = 0;
	private final double D_DRIVE = 0;
	
	// TODO tune these constants
	private final double P_HEADING = 0;
	private final double I_HEADING = 0;
	private final double D_HEADING = 0;

	public DrivetrainGyro() {
		driveEncoderA.setDistancePerPulse(1);
		driveEncoderB.setDistancePerPulse(1);
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
	 * Resets the encoders.
	 */
	public void resetEncoder() {
		this.driveEncoderA.reset();
		this.driveEncoderB.reset();
	}

	/**
	 * Drives the robot based on speeds of left and right wheels.
	 * 
	 * @param leftPower Speed that the left motors are set to.
	 * @param rightPower Speed that right motors are set to.
	 */
	public void driveLR(double leftPower, double rightPower) {
		this.frontLeft.set(leftPower);
		this.frontRight.set(-rightPower);
		this.backLeft.set(leftPower);
		this.backRight.set(-rightPower);
	}
	
	/**
	 * Returns the angle, in degrees, away from the initial gyro position.
	 * 
	 * @return angle Angular displacement from the initial gyro position.
	 */
	public double getAngleInDegrees() {
		return this.driveGyro.getAngle();
	}

	private class GyroWrapper implements PIDSource {

		@Override
		public PIDSourceType getPIDSourceType() {
			return PIDSourceType.kDisplacement;
		}

		@Override
		public double pidGet() {
			return driveEncoderA.getDistance();
		}

		@Override
		public void setPIDSourceType(PIDSourceType arg0) {
			//empty
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
			return Robot.dt.backRight.getPosition();
		}
	}

	private class DriveOutput implements PIDOutput {

		@Override
		public void pidWrite(double output) {
			driveLR(output, output);
		}
	}
}

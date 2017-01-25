package com.nutrons.nu17.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import com.nutrons.nu17.OI;
import com.nutrons.nu17.Robot;
import com.nutrons.nu17.RobotMap;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import lib.EncoderWrapper;
import lib.GyroWrapper;
import lib.HoldPID;

public class Drivetrain extends Subsystem {

public Drivetrain() {
		this.setPercentDrive();
    	
    	this.holdHeading.setInputRange(-180.0, 180.0);
    	this.holdHeading.setOutputRange(-1.0, 1.0);
    	this.holdHeading.setAbsoluteTolerance(5.0);
    	this.holdHeading.setContinuous();
    	
    	this.turnToAngle.setAbsoluteTolerance(10.0);
    	
    	this.frontLeft.changeControlMode(TalonControlMode.PercentVbus);
    	this.frontLeft.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	this.frontLeft.configEncoderCodesPerRev((int)(256 / 0.14));
    	this.frontLeft.reverseOutput(true);
		this.frontLeft.reverseSensor(true);
		this.frontLeft.setPID(0.02, 0.0, 0.08);
		this.frontLeft.configNominalOutputVoltage(+0.0f, -0.0f); 
		this.frontLeft.configPeakOutputVoltage(12.0f, -12.0f);
		
    	this.backLeft.changeControlMode(TalonControlMode.Follower);
    	this.backLeft.set(this.frontLeft.getDeviceID());
    	this.backLeft.configNominalOutputVoltage(+0.0f, -0.0f); 
		this.backLeft.configPeakOutputVoltage(12.0f, -12.0f);
		
		
		this.backRight.changeControlMode(TalonControlMode.PercentVbus);
    	this.backRight.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	this.backRight.configEncoderCodesPerRev((int)(256 / 0.14));
    	this.backRight.setPID(0.02, 0.0, 0.08);
    	this.backRight.configNominalOutputVoltage(+0.0f, -0.0f); 
		this.backRight.configPeakOutputVoltage(12.0f, -12.0f);
    	
		this.frontRight.changeControlMode(TalonControlMode.Follower);
    	this.frontRight.set(this.backRight.getDeviceID());
    	this.frontRight.configNominalOutputVoltage(+0.0f, -0.0f); 
		this.frontRight.configPeakOutputVoltage(12.0f, -12.0f);
    	
		this.disableBreakMode();
    	
    	this.GYRO.calibrate();
	}

	// Motors
	public CANTalon frontLeft = new CANTalon(RobotMap.FRONT_LEFT);
	public CANTalon backLeft = new CANTalon(RobotMap.BACK_LEFT);
	public CANTalon frontRight = new CANTalon(RobotMap.FRONT_RIGHT);
	public CANTalon backRight = new CANTalon(RobotMap.BACK_RIGHT);

	// Sensors
	private final AnalogGyro GYRO = new AnalogGyro(RobotMap.DRIVETRAIN_HEADING_GYRO);

	// TODO: Tune Ports
	private final Encoder DRIVE_DISTANCE_ENCODER = new Encoder(RobotMap.LEFT_WHEEL_DRIVE_DISTANCE_ENCODER_1, RobotMap.LEFT_WHEEL_DRIVE_DISTANCE_ENCODER_2);

	// Drive
	public RobotDrive drive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);

	// PID
	// TODO: tune these constants
	private static final double P_HEADING = 0;
	private static final double I_HEADING = 0;
	private static final double D_HEADING = 0;

	// TODO: tune these constants
	private static final double P_TURN = 0;
	private static final double I_TURN = 0;
	private static final double D_TURN = 0;
	
	// TODO: tune these constants
	private static final double P_DISTANCE = 0;
	private static final double I_DISTANCE = 0;
	private static final double D_DISTANCE = 0;

	private double heading;
	public final PIDController holdHeading = new PIDController(P_HEADING,
			I_HEADING,
			D_HEADING,
			new GyroWrapper() ,
			new HoldHeadingOutput());
	private double angle;
	public final PIDController turnToAngle = new PIDController(P_TURN,
			I_TURN,
			D_TURN,
			new GyroWrapper(),
			new TurnToAngleOutput());
	private double distance;
	public final PIDController driveDistance = new PIDController(P_DISTANCE,
			I_DISTANCE,
			D_DISTANCE,
			new EncoderWrapper(),
			new DriveDistancePIDOutput());

	/**
	 * Returns the angle, in degrees, away from the initial gyro position.
	 * 
	 * @return angle Angular displacement from the initial gyro position.
	 */
	public double getAngleInDegrees() {
		return this.GYRO.getAngle();
	}

	/**
	 * Returns the rate of the encoder in relation to the setting of the encoder
	 * 
	 * @return Encoder Rate using the .getRate method
	 */
	public double getEncoderRate() {
		return this.DRIVE_DISTANCE_ENCODER.getRate();
	}

	/**
	 * Resets the encoder.
	 */
	public void resetEncoder() {
		this.DRIVE_DISTANCE_ENCODER.reset();

	}

	/**
	 * Resets the gyro.
	 */
	public void resetGyro() {
		this.GYRO.reset();

	}
	
	public void setPercentDrive() {
	    this.frontLeft.changeControlMode(TalonControlMode.PercentVbus);
	    this.backRight.changeControlMode(TalonControlMode.PercentVbus);
	    }
	public void disableBreakMode() {
    	this.frontLeft.enableBrakeMode(false);
    	this.backRight.enableBrakeMode(false);
    }

	public void initDefaultCommand() {
		drive.tankDrive(OI.DRIVER_PAD.getY(), OI.DRIVER_PAD.getX());
	}
	 private class GyroWrapper implements PIDSource {

			@Override
			public PIDSourceType getPIDSourceType() {
				return PIDSourceType.kDisplacement;
			}

			@Override
			public double pidGet() {
				return getAngleInDegrees();
			}

			@Override
			public void setPIDSourceType(PIDSourceType arg0) {

			}
		}
	    
	    private class HoldHeadingOutput implements PIDOutput {

			@Override
			public void pidWrite(double wheel) {
				heading = wheel;
			}
	    }
	    
	    public class TurnToAngleOutput implements PIDOutput {

			@Override
			public void pidWrite(double power) {
				angle = power;
			}
	    }
	   
	   
	    
	    public class EncoderWrapper implements PIDSource {

			@Override
			public PIDSourceType getPIDSourceType() {
				// TODO Auto-generated method stub
				return PIDSourceType.kDisplacement;
			}

			@Override
			public double pidGet() {
				// TODO Auto-generated method stub
				return Robot.DRIVETRAIN.backRight.getPosition();
			}

			@Override
			public void setPIDSourceType(PIDSourceType arg0) {
				// TODO Auto-generated method stub
			}
	    }
	    
	    public class DriveDistancePIDOutput implements PIDOutput {

			@Override
			public void pidWrite(double power) {
				distance = power;
			}
	    	
	    }
}

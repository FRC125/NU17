package com.nutrons.nu17.subsystems.Drivetrain;

import com.nutrons.nu17.OI;
import com.nutrons.nu17.RobotMap;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import lib.EncoderWrapper;
import lib.GyroWrapper;
import lib.HoldPID;

public class Drivetrain extends Subsystem {

	public Drivetrain() {
		// empty
	}

	// Motors
	public Talon frontLeft = new Talon(RobotMap.FRONT_LEFT);
	public Talon backLeft = new Talon(RobotMap.BACK_LEFT);
	public Talon frontRight = new Talon(RobotMap.FRONT_RIGHT);
	public Talon backRight = new Talon(RobotMap.BACK_RIGHT);

	// Sensors
	private final AnalogGyro HEADING_GRYO = new AnalogGyro(RobotMap.HEADING_GYRO);

	// TODO: Tune Ports
	private final Encoder DRIVE_DISTANCE_ENCODER = new Encoder(RobotMap.DRIVE_DISTANCE_ENCODER_P1, RobotMap.DRIVE_DISTANCE_ENCODER_P2);

	// Drive
	public RobotDrive drive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);

	// PID
	// Wrappers
	private EncoderWrapper encWrap = new EncoderWrapper(PIDSourceType.kDisplacement,
			DRIVE_DISTANCE_ENCODER,
			RobotMap.DRIVE_DISTANCE_ENCODER_P1,
			RobotMap.DRIVE_DISTANCE_ENCODER_P2);
	private GyroWrapper gyroWrap = new GyroWrapper(PIDSourceType.kDisplacement,
			HEADING_GRYO,
			RobotMap.HEADING_GYRO);

	// Holders
	private HoldPID distancePIDHolder = new HoldPID();
	private HoldPID headingPIDHolder = new HoldPID();

	// TODO: tune these constants
	private static final double P_DRIVE = 0;
	private static final double I_DRIVE = 0;
	private static final double D_DRIVE = 0;

	// TODO: tune these constants
	private static final double P_HEADING = 0;
	private static final double I_HEADING = 0;
	private static final double D_HEADING = 0;

	public final PIDController DISTANCE_PID = new PIDController(P_DRIVE,
			I_DRIVE,
			D_DRIVE,
			encWrap,
			distancePIDHolder);
	public final PIDController HEADING_PID = new PIDController(P_HEADING,
			I_HEADING,
			D_HEADING,
			gyroWrap,
			headingPIDHolder);

	/**
	 * Returns the angle, in degrees, away from the initial gyro position.
	 * 
	 * @return angle Angular displacement from the initial gyro position.
	 */
	public double getAngleInDegrees() {
		return this.HEADING_GRYO.getAngle();
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
		this.HEADING_GRYO.reset();

	}

	public void initDefaultCommand() {
		drive.tankDrive(OI.DRIVER_PAD.getY(), OI.DRIVER_PAD.getX());
	}
}

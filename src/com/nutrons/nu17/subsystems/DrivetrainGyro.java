package com.nutrons.nu17.subsystems;

import com.nutrons.nu17.Robot;
import com.nutrons.nu17.RobotMap;
import com.nutrons.nu17.commands.TankDriveCmd;
import com.nutrons.nu17.OI;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Drivetrain class
 * 
 * @author Man Nguyen
 */
public class DrivetrainGyro extends Subsystem {

	private Talon frontRight = new Talon(RobotMap.FRONT_RIGHT);
	private Talon frontLeft = new Talon(RobotMap.FRONT_LEFT);
	private Talon backRight = new Talon(RobotMap.BACK_RIGHT);
	private Talon backLeft = new Talon(RobotMap.BACK_LEFT);
	private Encoder driveEncoderA = new Encoder(RobotMap.ENCODERA1, RobotMap.ENCODERA2);
	private Encoder driveEncoderB = new Encoder(RobotMap.ENCODERB1, RobotMap.ENCODERB2);

	private AnalogGyro driveGyro = new AnalogGyro(RobotMap.GYRO);

	public PIDController driveDistanceControl = new PIDController(RobotMap.P_DRIVE, RobotMap.I_DRIVE, RobotMap.D_DRIVE,
			new EncoderWrapper(), new DriveOutput());
	public PIDController holdHeading = new PIDController(RobotMap.P_HEADING, RobotMap.I_HEADING, RobotMap.D_HEADING,
			new GyroWrapper(), new GyroOutput());

	public static double driveOutput;

	public DrivetrainGyro() {
		driveEncoderA.setDistancePerPulse(1);
		driveEncoderB.setDistancePerPulse(1);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new TankDriveCmd());
	}

	public void stop() {
		this.driveLR(0.0, 0.0);
	}

	public void resetEncoder() {
		this.driveEncoderA.reset();
		this.driveEncoderB.reset();
	}

	public void driveLR(double leftPower, double rightPower) {
		this.frontLeft.set(leftPower);
		this.frontRight.set(-rightPower);
		this.backLeft.set(leftPower);
		this.backRight.set(-rightPower);
	}

	private volatile double headingGyro;

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
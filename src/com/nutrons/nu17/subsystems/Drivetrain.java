package com.nutrons.nu17.subsystems;

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

/**
 * Drivetrain code four a 4 wheel drive
 */
public class Drivetrain extends Subsystem {
	
	public Drivetrain() {
		//empty
	}
	
	// Motors
		public Talon leftDriveA = new Talon(RobotMap.LEFT_DRIVE_MOTOR_A);
		public Talon leftDriveB = new Talon(RobotMap.LEFT_DRIVE_MOTOR_B);
		public Talon rightDriveA = new Talon(RobotMap.RIGHT_DRIVE_MOTOR_A);
		public Talon rightDriveB = new Talon(RobotMap.RIGHT_DRIVE_MOTOR_B);
    
	// Sensors
		private final AnalogGyro GYRO = new AnalogGyro(RobotMap.GYRO);
		// Encoder Ports Not FINAL Needs Tuning!
		private final Encoder ENC_A = new Encoder(RobotMap.DT_ENCODER_1, RobotMap.DT_ENCODER_2);
		

    // Drive
		public RobotDrive drive = new RobotDrive(leftDriveA, leftDriveB,
				rightDriveA, rightDriveB);
		
	// PID
		//Wrappers
		private EncoderWrapper encWrap = new EncoderWrapper(PIDSourceType.kDisplacement,
				ENC_A,
				RobotMap.DT_ENCODER_1,
				RobotMap.DT_ENCODER_2);
		private GyroWrapper gyroWrap = new GyroWrapper(PIDSourceType.kDisplacement,
				GYRO,
				RobotMap.GYRO);
		
		//Holders
		private HoldPID driveHoldA = new HoldPID();
		private HoldPID driveHoldB = new HoldPID();
		
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
				encWrap, 
				driveHoldA);
		public final PIDController HEADING_PID = new PIDController(
				P_HEADING, 
				I_HEADING, 
				D_HEADING,
				gyroWrap, 
				driveHoldB);
	
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
		 */public double getEncoderRate() {
			return this.ENC_A.getRate();
		}
		
		/**
		 * Resets the encoder.
		 */
		public void resetEncoder() {
			this.ENC_A.reset();
			
		}
		
		/**
		 * Resets the gyro.
		 */
		public void resetGyro() {
			this.GYRO.reset();
			
		}
		public void initDefaultCommand() {
	 drive.tankDrive(OI.DRIVER_PAD.getY(), OI.DRIVER_PAD.getX());
    }
}


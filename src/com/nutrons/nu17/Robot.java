package com.nutrons.nu17;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


import com.nutrons.nu17.OI;
import com.nutrons.nu17.subsystems.Shooter;
import com.nutrons.nu17.subsystems.TwinShooter;
import com.nutrons.nu17.subsystems.Drivetrain;
import com.nutrons.nu17.subsystems.GroundIntake;

public class Robot extends IterativeRobot {

	public static Shooter shooter = new Shooter(RobotMap.SHOOTER, RobotMap.ENCODER_A, RobotMap.ENCODER_B);
	public static GroundIntake groundIntake = new GroundIntake(RobotMap.ROLLER_A, RobotMap.ROLLER_B); 
	public static OI oi;
	//public static Drivetrain driveTrain = new Drivetrain();
	public static TwinShooter twinShooter = new TwinShooter(RobotMap.TWIN_A, RobotMap.TWIN_B, RobotMap.ENCODER_A, RobotMap.ENCODER_B,  RobotMap.ENCODER_A, RobotMap.ENCODER_B);
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		
}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {

	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}

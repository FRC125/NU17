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
import com.nutrons.nu17.subsystems.DrivetrainGyro;
import com.nutrons.nu17.subsystems.GearPlacer;
import com.nutrons.nu17.subsystems.Climber;
import com.nutrons.nu17.subsystems.Drivetrain;
import com.nutrons.nu17.subsystems.GroundIntake;

public class Robot extends IterativeRobot {

	public static Shooter shooter = new Shooter();
	public static GroundIntake groundIntake = new GroundIntake();
	public static DrivetrainGyro dt = new DrivetrainGyro();
	public static OI oi;
	public static GearPlacer gp = new GearPlacer();
	public static Drivetrain driveTrain = new Drivetrain();
	public static Climber climber = new Climber();

	
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

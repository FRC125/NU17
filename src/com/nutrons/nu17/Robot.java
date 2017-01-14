package com.nutrons.nu17;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.nutrons.nu17.OI;
import com.nutrons.nu17.subsystems.*;

public class Robot extends IterativeRobot {
	
	public static TwinShooter twinShooter = new TwinShooter(
			RobotMap.TWIN_A, 
			RobotMap.TWIN_B, 
			RobotMap.ENCODER_A,
			RobotMap.ENCODER_B, 
			RobotMap.ENCODER_A, 
			RobotMap.ENCODER_B);
	public static Shooter shooter = new Shooter();
	public static GroundIntake groundIntake = new GroundIntake();
	public static DrivetrainGyro dt = new DrivetrainGyro();
	public static GearPlacer gp = new GearPlacer();
	public static Drivetrain driveTrain = new Drivetrain();
	public static Climber climber = new Climber();
	
	public static OI oi;

	@Override
	public void robotInit() {
		//empty
	}

	@Override
	public void disabledInit() {
		//empty
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		//empty
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}

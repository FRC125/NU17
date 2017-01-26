package com.nutrons.nu17;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.nutrons.nu17.OI;
import com.nutrons.nu17.subsystems.*;

public class Robot extends IterativeRobot {
	
	public final static TwinShooter TWIN_SHOOTER = new TwinShooter();
	public static Shooter SHOOTER = new Shooter();
	public final static GroundIntake GROUND_INTAKE = new GroundIntake();
	public final static DrivetrainGyro DT = new DrivetrainGyro();
	public final static GearPlacer GP = new GearPlacer();
	public final static Drivetrain DRIVE_TRAIN = new Drivetrain();
	public final static Climber CLIMBER = new Climber();
	public final static OI OI = new OI();
	Preferences prefs;
	
	Command autonomousCommand;
	SendableChooser <Command> chooser = new SendableChooser<>();

	@Override
	public void robotInit() {
		SmartDashboard.putData("Auto mode", chooser);
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
		autonomousCommand = chooser.getSelected();
		
		if (autonomousCommand !=null)
				autonomousCommand.start();
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		prefs = Preferences.getInstance();
		Shooter.SHOOTER_SPEED = prefs.getDouble("shooter_speed", 1.0);
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		
		SmartDashboard.putNumber("current_shooter_power", Robot.SHOOTER.getRPM());
	}

	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
	
}

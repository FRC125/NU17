
package org.usfirst.frc.team125.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team125.robot.subsystems.DriveTrain;
import org.usfirst.frc.team125.robot.subsystems.Shooter;

public class Robot extends IterativeRobot {
	
	public static OI oi;
	public static Shooter shooter;
	public static DriveTrain dt;
	Preferences prefs;
	public static double motorspeed;
	
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();
	
	@Override
	public void robotInit() {
		shooter = new Shooter();
		dt = new DriveTrain();
		oi = new OI();

		SmartDashboard.putData("Auto mode", chooser);
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
		autonomousCommand = chooser.getSelected();

		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		prefs = Preferences.getInstance();
		motorspeed = prefs.getDouble("motorspeed", 1.0);
		
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();

		SmartDashboard.putNumber("motorSpeed", Robot.shooter.getSpeed());
	}

	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
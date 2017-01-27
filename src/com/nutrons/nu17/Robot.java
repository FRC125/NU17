package com.nutrons.nu17;

import com.nutrons.nu17.subsystems.Climber;
import com.nutrons.nu17.subsystems.Drivetrain;
import com.nutrons.nu17.subsystems.GearPlacer;
import com.nutrons.nu17.subsystems.GroundIntake;
import com.nutrons.nu17.subsystems.Shooter;
import com.nutrons.nu17.subsystems.TwinShooter;

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

  public static final TwinShooter TWIN_SHOOTER = new TwinShooter();
  public static Shooter SHOOTER = new Shooter();
  public static final GroundIntake GROUND_INTAKE = new GroundIntake();
  public static final DrivetrainGyro DT = new DrivetrainGyro();
  public static final GearPlacer GP = new GearPlacer();
  public static final Drivetrain DRIVE_TRAIN = new Drivetrain();
  public static final Climber CLIMBER = new Climber();
  public static final OperatorInterface OI = new OperatorInterface();
  Preferences prefs;

  Command autonomousCommand;
  SendableChooser<Command> chooser = new SendableChooser<>();

  @Override
  public void robotInit() {
    SmartDashboard.putData("Auto mode", chooser);
  }

  @Override
  public void disabledInit() {
    // empty
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    autonomousCommand = chooser.getSelected();

    if (autonomousCommand != null){
      autonomousCommand.start();
    }
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


    SmartDashboard.putNumber("current_shooter_power", Robot.SHOOTER.getRpm());
  }

  @Override
  public void testPeriodic() {
    LiveWindow.run();
  }

}

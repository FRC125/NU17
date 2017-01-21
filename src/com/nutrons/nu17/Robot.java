package com.nutrons.nu17;

import com.nutrons.nu17.OI;
import com.nutrons.nu17.subsystems.Climber;
import com.nutrons.nu17.subsystems.Drivetrain;
import com.nutrons.nu17.subsystems.GearPlacer;
import com.nutrons.nu17.subsystems.GroundIntake;
import com.nutrons.nu17.subsystems.Shooter;
import com.nutrons.nu17.subsystems.TwinShooter;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends IterativeRobot {

  public static final TwinShooter TWIN_SHOOTER = new TwinShooter();
  public static final Shooter SHOOTER = new Shooter();
  public static final GroundIntake GROUND_INTAKE = new GroundIntake();
  public static final GearPlacer GP = new GearPlacer();
  public static final Climber CLIMBER = new Climber();
  public static final Drivetrain DRIVETRAIN = new Drivetrain();

  public static final OI OI = new OI();

  @Override
  public void robotInit() {
    // empty
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
    // empty
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // empty
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

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

  public final static TwinShooter TWIN_SHOOTER = new TwinShooter();
  public final static Shooter SHOOTER = new Shooter();
  public final static GroundIntake GROUND_INTAKE = new GroundIntake();
  public final static GearPlacer GP = new GearPlacer();
  public final static Climber CLIMBER = new Climber();
  public final static Drivetrain DRIVETRAIN = new Drivetrain();

  public final static OI OI = new OI();

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

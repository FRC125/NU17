package com.nutrons.nu17;

public class RobotMap {

  // Ports of wheels
  public static final int FRONT_LEFT = 0;
  public static final int BACK_LEFT = 0;
  public static final int FRONT_RIGHT = 0;
  public static final int BACK_RIGHT = 0;

  // Ports of intake
  public static final int ROLLER_FRONT = 0;
  public static final int ROLLER_BACK = 0;

  // Ports of fly wheels
  public static final int FLY_WHEEL_RIGHT = 0;
  public static final int FLY_WHEEL_LEFT = 0;

  // Ports of Ultrasonics
  public static final int ULTRASONIC_RX = 0;
  public static final int ULTRASONIC_TX = 0;

  // Port of gyro
  public static final int DRIVETRAIN_HEADING_GYRO = 0;

  // Port of gear placer
  public static final int GEAR_PLACER_SERVO = 0;

  // Port of shooter
  public static final int SHOOTER_MOTOR = 0;

  // Port of climber
  public static final int CLIMBER_MOTOR = 0;

  // Port of micro switch
  public static final int CLIMBER_MICRO_SWITCH = 0;

  // Ports of encoders
  public static final int LEFT_WHEEL_DRIVE_DISTANCE_ENCODER_1 = 0;
  public static final int LEFT_WHEEL_DRIVE_DISTANCE_ENCODER_2 = 0;
  public static final int RIGHT_WHEEL_DRIVE_DISTANCE_ENCODER_1 = 0;
  public static final int RIGHT_WHEEL_DRIVE_DISTANCE_ENCODER_2 = 0;
  public static final int FLY_ENCODER_FRONT_RIGHT = 0;
  public static final int FLY_ENCODER_BACK_RIGHT = 0;
  public static final int FLY_ENCODER_FRONT_LEFT = 0;
  public static final int FLY_ENCODER_BACK_LEFT = 0;
  public static final int TWIN_LEFT_ENCODER_1 = 0;
  public static final int TWIN_LEFT_ENCODER_2 = 0;
  public static final int TWIN_RIGHT_ENCODER_1 = 0;
  public static final int TWIN_RIGHT_ENCODER_2 = 0;
  public static final int SHOOT_ENCODER_1 = 0;
  public static final int SHOOT_ENCODER_2 = 0;


  // Port of joysticks
  public static final int JOYSTICK1 = 0;
  public static final int JOYSTICK2 = 0;

  // Buttons
  // TODO: Needs tune testing
  public static final int JOYSTICK_A = 0;
  public static final int JOYSTICK_B = 0;
  public static final int JOYSTICK_X = 0;
  public static final int JOYSTICK_Y = 0;
  public static final int JOYSTICK_LEFT_BUMPER = 0;
  public static final int JOYSTICK_LEFT_TRIGGER = 0;
  public static final int JOYSTICK_RIGHT_BUMPER = 0;
  public static final int JOYSTICK_RIGHT_TRIGGER = 0;
  public static final int JOYSTICK_DPAD_UP = 0;
  public static final int JOYSTICK_DPAD_DOWN = 0;
  public static final int JOYSTICK_DPAD_LEFT = 0;
  public static final int JOYSTICK_DPAD_RIGHT = 0;

  // TODO tune this constant for deadband
  public static final double JOYSTICK_DEADBAND = 0.05;
}

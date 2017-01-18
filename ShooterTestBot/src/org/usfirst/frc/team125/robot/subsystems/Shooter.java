package org.usfirst.frc.team125.robot.subsystems;

import org.usfirst.frc.team125.robot.Robot;
import org.usfirst.frc.team125.robot.RobotMap;
import org.usfirst.frc.team125.robot.commands.ShootCmd;
import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {

	private CANTalon motor1 = new CANTalon(RobotMap.motor1Port);
	private CANTalon motor2 = new CANTalon(RobotMap.motor2Port);
	
	public Shooter(){
		motor1.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		motor2.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		motor1.configEncoderCodesPerRev((int)(256 / 0.14));
		motor2.configEncoderCodesPerRev((int)(256 / 0.14));
		
		motor1.changeControlMode(TalonControlMode.PercentVbus);
		motor2.changeControlMode(TalonControlMode.PercentVbus);
		
		motor1.configNominalOutputVoltage(0.0f, 0.0f);
		motor2.configNominalOutputVoltage(0.0f, 0.0f);
		motor1.configPeakOutputVoltage(12.0f, 12.0f);
		motor2.configPeakOutputVoltage(12.0f, 12.0f);
		
		motor1.setPID(0, 0, 0);
		motor2.setPID(0, 0, 0);
	}

    public void initDefaultCommand() {
        setDefaultCommand(new ShootCmd());
    }
    
    public void fire() {
    	Robot.shooter.motor1.set(Robot.motorspeed);
    	Robot.shooter.motor2.set(Robot.motorspeed);
    }
    
    public void stop(){
    	Robot.shooter.motor1.set(0);
    	Robot.shooter.motor2.set(0);
    }
    
    public double getSpeed(){
    	return Robot.shooter.motor1.getSpeed();
    }
}
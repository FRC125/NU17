package org.usfirst.frc.team125.robot.subsystems;

import org.usfirst.frc.team125.robot.Robot;
import org.usfirst.frc.team125.robot.RobotMap;
import org.usfirst.frc.team125.robot.commands.ShootCmd;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {

	private CANTalon motor1 = new CANTalon(RobotMap.motor1Port);
	private CANTalon motor2 = new CANTalon(RobotMap.motor2Port);

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
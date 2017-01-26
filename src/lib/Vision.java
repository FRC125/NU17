package lib;

import java.io.UnsupportedEncodingException;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Vision {
	private int baudrate = 9600;
	private SerialPort arduino;
	private String raw;
	private double angle;
	private double distance;
	
	public Vision(){
		arduino = new SerialPort(baudrate, SerialPort.Port.kUSB);
		arduino.enableTermination();
	}
	
	/**
	 * Reads and updates current angle and distance to boiler from Arduino 
	 */
	public void update(){
		try {
			raw = new String(arduino.read(10), "UTF-8");
			String[] split = raw.split(":");
			if(split.length == 2){
				this.angle = Double.valueOf(split[0]);
				this.distance = Double.valueOf(split[1]);
			}
		} catch (UnsupportedEncodingException e) {
			SmartDashboard.putString("Serial encoding error", e.getMessage());
		}
	}
	
	/**
	 * @return Returns the angle to the boiler
	 */
	public double getAngle(){
		return this.angle;
	}
	
	/**
	 * 
	 * @return Returns the distance to the boiler
	 */
	public double getDistance(){
		return this.distance;
	}

	/**
	 * For debugging purposes only. Prints everything to the SmartDashboard
	 * 
	 */
	public void printToSmartDB(){
		SmartDashboard.putNumber("bytes received", arduino.getBytesReceived());
		try {
			raw = new String(arduino.read(10), "UTF-8");
			if(raw != null){
				String[] split = raw.split(":");
				SmartDashboard.putNumber("lengthArr", split.length);
				if(split.length == 2){
					SmartDashboard.putString("angle", split[0]);
					SmartDashboard.putString("distance", split[1]);
				}
				
			}
		} catch (UnsupportedEncodingException e) {
			SmartDashboard.putString("Serial error", e.getMessage());
		}
	}
}
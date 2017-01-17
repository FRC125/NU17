package lib;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class GyroWrapper implements PIDSource {
	private PIDSourceType pidSource;
	private AnalogGyro gyro;
	public GyroWrapper() {
		//empty
	}
	/**
	 * Creates a EncoderWrapper PIDSource
	 * @param pidSource The pidSource type
	 * @param enc The encoder used for the PIDSource data
	 * @param encSourceA the first digital port for the encoder
	 * @param encSourceB the second digital port for the encoder
	 */
	public GyroWrapper(PIDSourceType pidSource,AnalogGyro gyro,int gyroSource) {
		setPIDSourceType(pidSource);
		gyro = new AnalogGyro(gyroSource);
	}
	@Override
	/**
	 * Sets the PIDSource type given the param
	 */
	public void setPIDSourceType(PIDSourceType pidSourceType) {
		pidSource = pidSourceType;
	}
	@Override
	/** 
	 * Returns the PIDSourceType
	 */
	public PIDSourceType getPIDSourceType() {
		return pidSource;
	}
	/**
	 * Gets the position of gyro
	 */
	@Override
	public double pidGet() {
		return gyro.getAngle();
	}
	
}

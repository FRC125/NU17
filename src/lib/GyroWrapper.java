package lib;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class GyroWrapper implements PIDSource {
  private PIDSourceType pidSource;
  private AnalogGyro gyro;
  
  /**
   * Creates an EncoderWrapper PIDSource.
   * 
   * @param pidSource The gyro used for the PIDSource data
   * @param gyro The gyro used for the PIDSource data
   * @param gyroSource the port where the gyro is
   */
  public GyroWrapper(PIDSourceType pidSource, AnalogGyro gyro, int gyroSource) {
    setPIDSourceType(pidSource);
    gyro = new AnalogGyro(gyroSource);
  }

  /**
   * Sets the PIDSource type given the param.
   */
  @Override
  public void setPIDSourceType(PIDSourceType pidSourceType) {
    pidSource = pidSourceType;
  }

  /**
   * Returns the PIDSourceType.
   */
  @Override
  public PIDSourceType getPIDSourceType() {
    return pidSource;
  }

  /**
   * Gets the position of gyro.
   */
  @Override
  public double pidGet() {
    return gyro.getAngle();
  }

}

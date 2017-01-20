package lib;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class EncoderWrapper implements PIDSource {
  private PIDSourceType pidSource;
  private Encoder encoder;

  public EncoderWrapper() {
    // empty
  }

  /**
   * Creates a EncoderWrapper PIDSource.
   * 
   * @param pidSource The pidSource type
   * @param enc The encoder used for the PIDSource data
   * @param encSourceA the first digital port for the encoder
   * @param encSourceB the second digital port for the encoder
   */
  public EncoderWrapper(PIDSourceType pidSource, Encoder enc, int encSourceA, int encSourceB) {
    setPIDSourceType(pidSource);
    encoder = new Encoder(encSourceA, encSourceB);
  }

  @Override
  /**
   * Sets the PIDSource type given the param.
   */
  public void setPIDSourceType(PIDSourceType pidSourceType) {
    pidSource = pidSourceType;
  }

  @Override
  /**
   * Returns the PIDSourceType.
   */
  public PIDSourceType getPIDSourceType() {
    return pidSource;
  }

  /**
   * Gets the rate of the encoder.
   */
  @Override
  public double pidGet() {
    return encoder.getRate();
  }

}

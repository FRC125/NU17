package lib;

import edu.wpi.first.wpilibj.PIDOutput;

public class HoldPid implements PIDOutput {

  private double holder;

  public HoldPid() {
    // empty
  }

  /**
   * given a param called output it will write the last PID value to a variable called output.
   */
  @Override
  public void pidWrite(double output) {
    holder = output;
  }

}

package lib;

import edu.wpi.first.wpilibj.PIDOutput;

public class HoldPID implements PIDOutput {
	
	public double holder;
	
	public HoldPID() {
		//empty
	}
	
	/**
	 * given a param called output it will write the last PID value to a variable called output
	 */
	@Override
	public void pidWrite(double output) {
		holder = output;
	}
}

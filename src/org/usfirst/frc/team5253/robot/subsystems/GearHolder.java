package org.usfirst.frc.team5253.robot.subsystems;


import org.usfirst.frc.team5253.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearHolder extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private DoubleSolenoid gearPiston = new DoubleSolenoid(RobotMap.GEAR_HOLDER_PISTON_EXTEND, RobotMap.GEAR_HOLDER_PISTON_RETRACT);

	public GearHolder() {
		gearPiston.set(DoubleSolenoid.Value.kOff);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void drop() {
    	gearPiston.set(DoubleSolenoid.Value.kForward);
    }
    
    public void reset() {
    	gearPiston.set(DoubleSolenoid.Value.kReverse);
    }
}


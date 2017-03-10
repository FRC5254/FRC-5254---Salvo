package org.usfirst.frc.team5253.robot.subsystems;


import org.usfirst.frc.team5253.robot.RobotMap;
import org.usfirst.frc.team5253.robot.commands.GearIntakeIn;
import org.usfirst.frc.team5253.robot.commands.RaiseGear;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearHolder extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	//private DoubleSolenoid gearPiston = new DoubleSolenoid(RobotMap.GEAR_HOLDER_PISTON_EXTEND, RobotMap.GEAR_HOLDER_PISTON_RETRACT);
	private Solenoid gearIntake = new Solenoid(RobotMap.GEAR_INTAKE_PISTION);
	public GearHolder() {
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new RaiseGear());
    }
    
    public void drop() {
    	//gearPiston.set(DoubleSolenoid.Value.kReverse);
    }
    
    
    public void raise() {
    	//gearPiston.set(DoubleSolenoid.Value.kForward);
    }
    
    public void Out() {
    	gearIntake.set(true);
    }
    
    public void In() {
    	gearIntake.set(false);
    }
    public void floorIntakeIn() {
    	
    }
}


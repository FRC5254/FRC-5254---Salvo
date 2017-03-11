package org.usfirst.frc.team5253.robot.subsystems;

import org.usfirst.frc.team5253.robot.RobotMap;
import org.usfirst.frc.team5253.robot.commands.RedBullWingsRetract;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * 
 */
public class FuelTank extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private DoubleSolenoid redBullWingsPistion = new DoubleSolenoid(RobotMap.RED_BULL_WINGS_PISTION_EXTEND, RobotMap.RED_BULL_WINGS_PISTION_RETRACT);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new RedBullWingsRetract());
    	//sets default command to inside the frame perimeter
    }
    
    public void redBullWingsOut() {
    	redBullWingsPistion.set(DoubleSolenoid.Value.kForward);
    }
    
    public void redBullWingsIn() {
    	redBullWingsPistion.set(DoubleSolenoid.Value.kReverse);
    }
}


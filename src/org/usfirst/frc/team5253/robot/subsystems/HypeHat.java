package org.usfirst.frc.team5253.robot.subsystems;

import org.usfirst.frc.team5253.robot.RobotMap;
<<<<<<< HEAD
import org.usfirst.frc.team5253.robot.commands.StopFeedingShooter;
=======
import org.usfirst.frc.team5253.robot.commands.StopSpinning;
>>>>>>> refs/remotes/origin/master

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class HypeHat extends Subsystem {

<<<<<<< HEAD
	 // Put methods for controlling this subsystem
    // here. Call these from Commands.
	CANTalon hypeHatMotor = new CANTalon(RobotMap.HYPE_HAT_MOTOR);
	
	public HypeHat() {
		
		hypeHatMotor.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		hypeHatMotor.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		hypeHatMotor.configNominalOutputVoltage(+0.0f, -0.0f);
		hypeHatMotor.configPeakOutputVoltage(0.0f,-12.0f);
		hypeHatMotor.reverseSensor(false);
		hypeHatMotor.reverseOutput(false);
		hypeHatMotor.setF(0.0);
		hypeHatMotor.setPID(0.0, 0.0, 0.0);
=======
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	CANTalon HatMotor = new CANTalon(RobotMap.HYPE_HAT_MOTOR);
	
	public HypeHat() {
		
		HatMotor.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		HatMotor.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		HatMotor.configNominalOutputVoltage(+0.0f, -0.0f);
		HatMotor.configPeakOutputVoltage(0.0f,-12.0f);
		HatMotor.reverseSensor(false);
		HatMotor.reverseOutput(true);
		HatMotor.setF(0.025);
		HatMotor.setPID(0.0, 0.0, 0.0);
>>>>>>> refs/remotes/origin/master
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
<<<<<<< HEAD
    	setDefaultCommand(new StopFeedingShooter());
    }
    
    public void startFeeding() {
    	hypeHatMotor.set(1.0);
    }
    
    public void stopFeeding() {
    	hypeHatMotor.set(0);
=======
    	setDefaultCommand(new StopSpinning());
    }
    
    public void startSpinning() {
    	HatMotor.set(-0.85);
    }
    
    public void stopSpinning() {
    	HatMotor.set(0);
>>>>>>> refs/remotes/origin/master
    }
}


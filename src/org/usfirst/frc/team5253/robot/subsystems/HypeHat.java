package org.usfirst.frc.team5253.robot.subsystems;

import org.usfirst.frc.team5253.robot.RobotMap;
import org.usfirst.frc.team5253.robot.commands.StopSpinning;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class HypeHat extends Subsystem {

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
		HatMotor.setF(0.0);
		HatMotor.setPID(0.0, 0.0, 0.0);
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new StopSpinning());
    }
    
    public void startSpinning() {
    	HatMotor.set(-1.0);
    }
    
    public void stopSpinning() {
    	HatMotor.set(0);
    }
}


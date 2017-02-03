package org.usfirst.frc.team5253.robot.subsystems;

import org.usfirst.frc.team5253.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Indexer extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	CANTalon indexerMotor = new CANTalon(RobotMap.INDEXER_MOTOR);
	
	public Indexer() {
		
		indexerMotor.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		indexerMotor.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		indexerMotor.configNominalOutputVoltage(+0.0f, -0.0f);
		indexerMotor.configPeakOutputVoltage(0.0f,-12.0f);
		indexerMotor.reverseSensor(false);
		indexerMotor.reverseOutput(true);
		indexerMotor.setF(0.025);
		indexerMotor.setPID(0.0, 0.0, 0.0);
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void startFeeding() {
    	indexerMotor.set(1.0);
    }
    
    public void stopFeeding() {
    	indexerMotor.set(0);
    }
}


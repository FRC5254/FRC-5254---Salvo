package org.usfirst.frc.team5254.robot.subsystems;

import org.usfirst.frc.team5254.robot.RobotMap;
import org.usfirst.frc.team5254.robot.commands.ClimberStopClimbing;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private CANTalon climberMotor = new CANTalon(RobotMap.CLIMBER_MOTOR);
	
	public Climber() {
		
		climberMotor.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		climberMotor.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		climberMotor.configNominalOutputVoltage(+0.0f, -0.0f);
		climberMotor.configPeakOutputVoltage(0.0f,-12.0f);
		climberMotor.reverseSensor(false);
		climberMotor.reverseOutput(true);
	}
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ClimberStopClimbing());
    }
    public void startClimber(double percent) {
    	climberMotor.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	climberMotor.configPeakOutputVoltage(0.0f,-12.0f);
		climberMotor.set(percent);
    }
    
    public void stopClimber() {
    	climberMotor.set(0);
    }
}


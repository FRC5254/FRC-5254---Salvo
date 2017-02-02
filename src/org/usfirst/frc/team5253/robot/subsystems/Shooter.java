package org.usfirst.frc.team5253.robot.subsystems;

import org.usfirst.frc.team5253.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	CANTalon shooterMotorTopLeft = new CANTalon(RobotMap.SHOOTER_MOTOR_TOP_LEFT);
	CANTalon shooterMotorTopRight = new CANTalon(RobotMap.SHOOTER_MOTOR_TOP_RIGHT);
	CANTalon shooterMotorBottom = new CANTalon(RobotMap.SHOOTER_MOTOR_BOTTOM);
	
	public Shooter() {
		
		shooterMotorTopLeft.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		shooterMotorTopLeft.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		shooterMotorTopLeft.configNominalOutputVoltage(+0.0f, -0.0f);
		shooterMotorTopLeft.configPeakOutputVoltage(0.0f,-12.0f);
		shooterMotorTopLeft.reverseSensor(false);
		shooterMotorTopLeft.reverseOutput(false);
		shooterMotorTopLeft.setF(0.025);
		shooterMotorTopLeft.setPID(0.0, 0.0, 0.0);
		
		shooterMotorTopRight.changeControlMode(CANTalon.TalonControlMode.Follower);
		shooterMotorTopRight.set(RobotMap.SHOOTER_MOTOR_TOP_RIGHT);
		shooterMotorTopRight.reverseOutput(true);
		
		shooterMotorBottom.changeControlMode(CANTalon.TalonControlMode.Speed);
		shooterMotorBottom.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		shooterMotorBottom.configNominalOutputVoltage(+0.0f, -0.0f);
		shooterMotorBottom.configPeakOutputVoltage(0.0f,-12.0f);
		shooterMotorBottom.reverseSensor(false);
		shooterMotorBottom.reverseOutput(false);
		shooterMotorBottom.setF(0.025);
		shooterMotorBottom.setPID(0.0, 0.0, 0.0);
		
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void spinUp() {
    	shooterMotorTopLeft.changeControlMode(CANTalon.TalonControlMode.Speed);
		shooterMotorTopLeft.configPeakOutputVoltage(0.0f,-12.0f);
    	shooterMotorTopLeft.set(0.75);
    	
    	shooterMotorBottom.set(0.0);
    }
    
    public void startShooting() {
    	shooterMotorTopLeft.changeControlMode(CANTalon.TalonControlMode.Speed);
		shooterMotorTopLeft.configPeakOutputVoltage(0.0f,-12.0f);
    	shooterMotorTopLeft.set(0.75);
    	
    	shooterMotorBottom.changeControlMode(CANTalon.TalonControlMode.Speed);
    	shooterMotorBottom.configPeakOutputVoltage(0.0f, -12.0f);
    	shooterMotorBottom.set(0.75);
    }
    
    public void stopShooting() {
    	shooterMotorTopLeft.set(0.0);
    	
    	shooterMotorBottom.set(0.0);
    }
}


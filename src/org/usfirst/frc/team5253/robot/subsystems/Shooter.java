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
		
		shooterMotorTopLeft.changeControlMode(CANTalon.TalonControlMode.Speed);
		shooterMotorTopLeft.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		shooterMotorTopLeft.configNominalOutputVoltage(+0.0f, -0.0f);
		shooterMotorTopLeft.configPeakOutputVoltage(0.0f,-12.0f);
		shooterMotorTopLeft.reverseSensor(false);
		shooterMotorTopLeft.reverseOutput(false);
		shooterMotorTopLeft.setF(0.025);
		shooterMotorTopLeft.setPID(0.11, 0.0, 0.0);
		
		shooterMotorTopRight.changeControlMode(CANTalon.TalonControlMode.Follower);
		shooterMotorTopRight.set(RobotMap.SHOOTER_MOTOR_TOP_RIGHT);
		shooterMotorTopRight.reverseOutput(false);
		
		shooterMotorBottom.changeControlMode(CANTalon.TalonControlMode.Follower);
		shooterMotorBottom.set(RobotMap.SHOOTER_MOTOR_BOTTOM);
		shooterMotorBottom.reverseOutput(false);
		
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void startShooting(int RPM) {
    	shooterMotorTopLeft.changeControlMode(CANTalon.TalonControlMode.Speed);
		shooterMotorTopLeft.configPeakOutputVoltage(0.0f,-12.0f);
    	shooterMotorTopLeft.set(-RPM);
    }
    
    public void stopShooting() {
    	shooterMotorTopLeft.set(0);
    }
}


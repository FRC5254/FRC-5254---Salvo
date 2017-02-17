package org.usfirst.frc.team5253.robot.subsystems;

import org.usfirst.frc.team5253.robot.RobotMap;
import org.usfirst.frc.team5253.robot.commands.StopShooting;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
		//shooterMotorTopLeft.enableBrakeMode(true);//TODO test this
		shooterMotorTopLeft.reverseSensor(true);
		shooterMotorTopLeft.reverseOutput(true);
		shooterMotorTopLeft.setProfile(0);
		shooterMotorTopLeft.setF(0.03916);
		shooterMotorTopLeft.setPID(0.128, 0.0, 0.2); //TODO be a good programmer and fing how to do the PID stuff dumb
		
		shooterMotorTopRight.changeControlMode(CANTalon.TalonControlMode.Follower);
		shooterMotorTopRight.set(RobotMap.SHOOTER_MOTOR_TOP_LEFT);
		shooterMotorTopRight.reverseOutput(true);
		
		shooterMotorBottom.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		shooterMotorBottom.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		shooterMotorBottom.configNominalOutputVoltage(+0.0f, -0.0f);
		shooterMotorBottom.configPeakOutputVoltage(0.0f,-12.0f);
		shooterMotorBottom.reverseSensor(false);
		shooterMotorBottom.reverseOutput(false);
		shooterMotorBottom.setF(0.0);
		shooterMotorBottom.setPID(0.0, 0.0, 0.0);
		
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new StopShooting());
    }
    
    public void spinUp(double shooterRpm) {
    	
    	shooterMotorTopLeft.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		shooterMotorTopLeft.configPeakOutputVoltage(+0.0f,-12.0f);
		if(shooterMotorTopLeft.getSpeed() < shooterRpm) {
    		shooterMotorTopLeft.set(1.0);
    	} else {
    		shooterMotorTopLeft.set(0.0);
    	}
		
    	//System.out.format("RPM %f Error %d%n", shooterMotorTopLeft.getSpeed(), shooterMotorTopLeft.getClosedLoopError());
    	shooterMotorBottom.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	shooterMotorBottom.set(0.0);
    }
    
    public void startShooting(double shooterRpm) {
    	
    	shooterMotorTopLeft.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		shooterMotorTopLeft.configPeakOutputVoltage(0.0f,-12.0f);
		if(shooterMotorTopLeft.getSpeed() < shooterRpm) {
    		shooterMotorTopLeft.set(1.0);
    	} else {
    		shooterMotorTopLeft.set(0.0);
    	}
    	System.out.print(shooterMotorTopLeft.getError());
    	
    	shooterMotorBottom.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	shooterMotorBottom.configPeakOutputVoltage(0.0f, -12.0f);
    	shooterMotorBottom.set(0.75);
    }
    
    public void stopShooting(int RPM) {
    	shooterMotorTopLeft.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	shooterMotorTopLeft.configPeakOutputVoltage(0.0f,0.0f);
    	//shooterMotorTopLeft.enableBrakeMode(true);
    	shooterMotorTopLeft.set(0.0);
    	
    	shooterMotorBottom.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	shooterMotorBottom.set(0.0);
    	
    	
    	
    }
}


package org.usfirst.frc.team5253.robot.subsystems;

import org.usfirst.frc.team5253.robot.RobotMap;
import org.usfirst.frc.team5253.robot.commands.StopShooting;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Shooter extends Subsystem {
	
	private static final double ShooterError = Math.abs(20);

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
		shooterMotorTopLeft.reverseSensor(true);
		shooterMotorTopLeft.reverseOutput(true);
		shooterMotorTopLeft.setF(0.0391);
		shooterMotorTopLeft.setPID(0.12, 0.0012, 4.8);
		
		shooterMotorTopRight.changeControlMode(CANTalon.TalonControlMode.Follower);
		shooterMotorTopRight.set(RobotMap.SHOOTER_MOTOR_TOP_LEFT);
		shooterMotorTopRight.reverseOutput(true);
		
		shooterMotorBottom.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		shooterMotorBottom.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		shooterMotorBottom.configNominalOutputVoltage(+0.0f, -0.0f);
		shooterMotorBottom.configPeakOutputVoltage(0.0f,-12.0f);
		shooterMotorBottom.reverseSensor(false);
		shooterMotorBottom.reverseOutput(false);
		
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new StopShooting());
    }
    
    public void spinUp(double shooterRpm) {
    	
    	shooterMotorTopLeft.changeControlMode(CANTalon.TalonControlMode.Speed);
		shooterMotorTopLeft.configPeakOutputVoltage(+0.0f,-12.0f);
		shooterMotorTopLeft.set(shooterRpm);
		System.out.format("Spin Up; RPM %f, Delta %f, Error %D%n",
	    		shooterMotorTopLeft.getSpeed(),
	    		shooterMotorTopLeft.getSpeed() - shooterRpm,
	    		shooterMotorTopLeft.getClosedLoopError());
		
    	shooterMotorBottom.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	shooterMotorBottom.set(0.0);
    	
    	SmartDashboard.putDouble("Spin Up RPM", shooterMotorTopLeft.getSpeed());
    	SmartDashboard.putDouble("Spin Up RPM", shooterMotorTopLeft.getSpeed()-shooterRpm);
    	SmartDashboard.putDouble("Spin Up Error", shooterMotorTopLeft.getClosedLoopError());
    }
    
    
    public void startShooting(double shooterRpm) {
    	
    	shooterMotorTopLeft.changeControlMode(CANTalon.TalonControlMode.Speed);
		shooterMotorTopLeft.configPeakOutputVoltage(0.0f,-12.0f);
		shooterMotorTopLeft.set(shooterRpm);
		System.out.format("Spin Up; RPM %f, Delta %f, Error %D%n",
	    		shooterMotorTopLeft.getSpeed(),
	    		shooterMotorTopLeft.getSpeed() - shooterRpm,
	    		shooterMotorTopLeft.getClosedLoopError());
	    	
    	
    	shooterMotorBottom.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	shooterMotorBottom.configPeakOutputVoltage(0.0f, -12.0f);
    	shooterMotorBottom.set(0.75);
    	
    	SmartDashboard.putDouble("Start Shooting RPM", shooterMotorTopLeft.getSpeed());
    	SmartDashboard.putDouble("Start Shooting RPM", shooterMotorTopLeft.getSpeed()-shooterRpm);
    	SmartDashboard.putDouble("Start Shooting Error", shooterMotorTopLeft.getClosedLoopError());
    }
    
    public void stopShooting(int RPM) {
    	shooterMotorTopLeft.changeControlMode(CANTalon.TalonControlMode.Speed);
    	shooterMotorTopLeft.configPeakOutputVoltage(0.0f,0.0f);
    	shooterMotorTopLeft.set(0.0);
    	
    	shooterMotorBottom.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	shooterMotorBottom.set(0.0);
    	
    }
	public boolean shooterUpToSpeed() {
//		if (RobotBase.isReal()) {
			return shooterMotorTopLeft.getClosedLoopError() < ShooterError;
//	} else {
//		return true;
//		}
	}
}

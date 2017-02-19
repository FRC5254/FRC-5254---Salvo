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
	CANTalon shooterMotorTopRight = new CANTalon(RobotMap.SHOOTER_MOTOR_TOP_RIGHT);
	CANTalon shooterMotorTopLeft = new CANTalon(RobotMap.SHOOTER_MOTOR_TOP_LEFT);
	CANTalon shooterMotorTopLeft2 = new CANTalon(RobotMap.SHOOTER_MOTOR_TOP_LEFT2);
	CANTalon shooterMotorBottom = new CANTalon(RobotMap.SHOOTER_MOTOR_BOTTOM);
	
	int loop, maxError, minError = 10000000;
	
	public Shooter() {
		
		shooterMotorTopRight.changeControlMode(CANTalon.TalonControlMode.Speed);
		shooterMotorTopRight.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		shooterMotorTopRight.configNominalOutputVoltage(+0.0f, -0.0f);
		shooterMotorTopRight.configPeakOutputVoltage(0.0f,-12.0f);
		shooterMotorTopRight.reverseSensor(true);
		shooterMotorTopRight.reverseOutput(true);
		shooterMotorTopRight.setF(0.0391);
		shooterMotorTopRight.setPID(0.12, 0.0012, 4.8);
		
		shooterMotorTopLeft.changeControlMode(CANTalon.TalonControlMode.Follower);
		shooterMotorTopLeft.set(RobotMap.SHOOTER_MOTOR_TOP_RIGHT);
		shooterMotorTopLeft.reverseOutput(false);
		
		shooterMotorTopLeft2.changeControlMode(CANTalon.TalonControlMode.Follower);
		shooterMotorTopLeft2.set(RobotMap.SHOOTER_MOTOR_TOP_RIGHT);
		shooterMotorTopLeft2.reverseOutput(false);
		
		shooterMotorBottom.changeControlMode(CANTalon.TalonControlMode.PercentVbus);;
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
    	
    	shooterMotorTopRight.changeControlMode(CANTalon.TalonControlMode.Speed);
		shooterMotorTopRight.configPeakOutputVoltage(+0.0f,-12.0f);
		shooterMotorTopRight.set(shooterRpm);
		if (loop++ > 10) {
			loop = 0;
			System.out.format("Spin Up; RPM %f Delta %f Error %d%n",  
					shooterMotorTopRight.getSpeed(),
					shooterMotorTopRight.getSpeed() - shooterRpm, 
					shooterMotorTopRight.getClosedLoopError());
		}

    	shooterMotorBottom.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	shooterMotorBottom.set(0.0);
    	
    	SmartDashboard.putDouble("Spin Up RPM", shooterMotorTopLeft.getSpeed());
    	SmartDashboard.putDouble("Spin Up RPM", shooterMotorTopLeft.getSpeed()-shooterRpm);
    	SmartDashboard.putDouble("Spin Up Error", shooterMotorTopLeft.getClosedLoopError());
    }
    
    
    public void startShooting(double shooterRpm) {
    	
    	shooterMotorTopRight.changeControlMode(CANTalon.TalonControlMode.Speed);
		shooterMotorTopRight.configPeakOutputVoltage(0.0f,-12.0f);
		shooterMotorTopRight.set(shooterRpm);
		System.out.format("Spin Up; RPM %f, Delta %f, Error %d%n",
	    		shooterMotorTopRight.getSpeed(),
	    		shooterMotorTopRight.getSpeed() - shooterRpm,
	    		shooterMotorTopRight.getClosedLoopError());
	    	
		double currentRpm = shooterMotorTopRight.getSpeed();
		int closedLoopError = shooterMotorTopRight.getClosedLoopError();
		
		maxError = Math.max(maxError, Math.abs(closedLoopError));
    	minError = Math.min(minError, Math.abs(closedLoopError));
		
		if (loop++ > 10) {
			loop = 0;
			System.out.format("Start Shooting; RPM %f Delta %f Error %d%n", 
					currentRpm,
					currentRpm - shooterRpm, 
					closedLoopError);
		}
    	
    	shooterMotorBottom.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	shooterMotorBottom.configPeakOutputVoltage(0.0f, -12.0f);
    	shooterMotorBottom.set(0.75);
    	
    	SmartDashboard.putNumber("Start Shooting RPM", shooterMotorTopLeft.getSpeed());
    	SmartDashboard.putDouble("Start Shooting RPM", shooterMotorTopLeft.getSpeed()-shooterRpm);
    	SmartDashboard.putDouble("Start Shooting Error", shooterMotorTopLeft.getClosedLoopError());
    }
    
    public void stopShooting(int RPM) {
    	shooterMotorTopRight.changeControlMode(CANTalon.TalonControlMode.Speed);
    	shooterMotorTopRight.configPeakOutputVoltage(0.0f,0.0f);
    	shooterMotorTopRight.set(0.0);
    	
    	if (minError != 10000000 || maxError != 0) {
    		System.out.format("Stop: minError %d maxError %d%n", minError, maxError);
    		minError = 10000000;
    		maxError = 0;
    	}
    	
    	shooterMotorBottom.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	shooterMotorBottom.set(0.0);
    	
    }
	public boolean shooterUpToSpeed() {
//		if (RobotBase.isReal()) {
			return shooterMotorTopRight.getClosedLoopError() < ShooterError;
//	} else {
//		return true;
//		}
	}
}

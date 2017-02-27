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
	
	private static final double ShooterError = Math.abs(20);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	CANTalon shooterMotorTopLeft = new CANTalon(RobotMap.SHOOTER_MOTOR_TOP_LEFT);
	CANTalon shooterMotorTopRight = new CANTalon(RobotMap.SHOOTER_MOTOR_TOP_RIGHT);
	CANTalon shooterMotorBottom = new CANTalon(RobotMap.SHOOTER_MOTOR_BOTTOM);
	
	Boolean shootingSpeedAchieved = false;
	double minShooting  = 1000000.0;
	double maxShooting  = 0;
	
	Boolean idleAchieved = false;
	int loop, maxError, minError = 10000000;
	double minIdle = 10000000.0;
	double maxIdle = 0.0;
	
	
	public Shooter() {
		
		
		shooterMotorTopLeft.changeControlMode(CANTalon.TalonControlMode.Speed);
		shooterMotorTopLeft.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		shooterMotorTopLeft.configNominalOutputVoltage(+0.0f, -0.0f);
		shooterMotorTopLeft.configPeakOutputVoltage(0.0f,-12.0f);
		shooterMotorTopLeft.reverseSensor(true);
		shooterMotorTopLeft.reverseOutput(true);
		shooterMotorTopLeft.setProfile(0);
		shooterMotorTopLeft.setF(0.008);//1023.0 /(RobotMap.SHOOTER_RPM / 600.0 * 4096.0)
		System.out.format("Shooter RPM %f F %f%n", RobotMap.SHOOTER_RPM, shooterMotorTopLeft.getF());
		shooterMotorTopLeft.setPID(0, 0, 0);//0.12, 0.0012, 4.8
		
		shooterMotorTopRight.changeControlMode(CANTalon.TalonControlMode.Follower);
		shooterMotorTopRight.set(RobotMap.SHOOTER_MOTOR_TOP_LEFT);
		shooterMotorTopRight.reverseOutput(false);
		
		shooterMotorBottom.changeControlMode(CANTalon.TalonControlMode.PercentVbus);;
		shooterMotorBottom .configNominalOutputVoltage(+0.0f, -0.0f);
		shooterMotorBottom.configPeakOutputVoltage(0.0f,-12.0f);
		shooterMotorBottom.reverseSensor(false);
	}
    public void initDefaultCommand() {
      	setDefaultCommand(new StopShooting());
    }
    
    public void spinUp(double shooterRpm) {
    	
    	shooterMotorTopLeft.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		shooterMotorTopLeft.configPeakOutputVoltage(+0.0f,-12.0f);
		shooterMotorTopLeft.set(-1);
		
		if (loop++ > 10) {
			loop = 0;
			System.out.format("Spin Up; RPM %f Delta %f Error %d%n",  
					shooterMotorTopLeft.getSpeed() ,//THOUSAND RPM BASED ON RATIO 3.2
					shooterMotorTopLeft.getSpeed() - shooterRpm, 
					shooterMotorTopLeft.getClosedLoopError());
		}

    	shooterMotorBottom.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	shooterMotorBottom.set(0.0);

    	//SmartDashboard.putNumber("Spin Up RPM", shooterMotorTopLeft.getSpeed());
    	//SmartDashboard.putNumber("Spin Up Error", shooterMotorTopLeft.getClosedLoopError());
    	
    	if (shooterMotorTopLeft.getSpeed() >= shooterRpm) {
    		idleAchieved = true;
    	}
    	
    	if (idleAchieved = true) {
    		maxIdle = Math.max(maxIdle, shooterMotorTopLeft.getSpeed());
    		minIdle = Math.min(minIdle, shooterMotorTopLeft.getSpeed());
    		SmartDashboard.putString("DB/String 2", Double.toString(minIdle));
    		SmartDashboard.putString("DB/String 7", Double.toString(maxIdle));
    	}
    	
    }
    
    
    public void startShooting(double shooterRpm) { 
    	
    	shooterMotorTopLeft.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		shooterMotorTopLeft.configPeakOutputVoltage(0.0f,-12.0f);
		shooterMotorTopLeft.set(-0.75);
		
		double currentRpm = shooterMotorTopLeft.getSpeed();
		int closedLoopError = shooterMotorTopLeft.getClosedLoopError();
		
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
    	SmartDashboard.putNumber("Shooter RPM", shooterMotorTopLeft.getSpeed());
    	SmartDashboard.putNumber("Shooter RPM", shooterRpm);
    	//SmartDashboard.putNumber("Start Shooting Error", shooterMotorTopLeft.getClosedLoopError());
    	
    	
    	if (shooterMotorTopLeft.getSpeed() >= shooterRpm){
    		shootingSpeedAchieved = true;
    	}
    	
    	if (shootingSpeedAchieved = true){
    		maxShooting = Math.max(maxShooting, shooterMotorTopLeft.getSpeed());
    		minShooting = Math.min(minShooting, shooterMotorTopLeft.getSpeed());
    	
    		SmartDashboard.putString("DB/String 3", Double.toString(minShooting));
    		SmartDashboard.putString("DB/String 8", Double.toString(maxShooting));
    	}
    }
    
    public void stopShooting(int RPM) {
    	
    	shooterMotorTopLeft.configPeakOutputVoltage(0.0f,0.0f);
    	shooterMotorTopLeft.set(0.0);
    	
    	minIdle = 10000000.0;
    	maxIdle = 0.0;
    	idleAchieved = false;
    	
    	shootingSpeedAchieved = false;
    	minShooting  = 1000000.0;
    	maxShooting  = 0;
    	
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
			return shooterMotorTopLeft.getClosedLoopError() < ShooterError;
//	} else {
//		return true;
//		}
	}
}

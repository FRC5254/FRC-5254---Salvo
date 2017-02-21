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
	
	int loop, maxError, minError = 10000000;
	
	public Shooter() {
		
		shooterMotorTopLeft.changeControlMode(CANTalon.TalonControlMode.Speed);
		shooterMotorTopLeft.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		shooterMotorTopLeft.configNominalOutputVoltage(+0.0f, -0.0f);
		shooterMotorTopLeft.configPeakOutputVoltage(0.0f,-12.0f);
		shooterMotorTopLeft.reverseSensor(true);
		shooterMotorTopLeft.reverseOutput(true);
<<<<<<< HEAD
		shooterMotorTopLeft.setF(0.0391);
=======
		shooterMotorTopLeft.setProfile(0);
<<<<<<< HEAD
		shooterMotorTopLeft.setF(0.0391);
		shooterMotorTopLeft.setPID(0.28, 0.0056, 2.8);
>>>>>>> refs/remotes/origin/Rory
=======
		shooterMotorTopLeft.setF(1023.0 / (RobotMap.SHOOTER_RPM / 600.0 * 4096.0));
		System.out.format("Shooter RPM %f F %f%n", RobotMap.SHOOTER_RPM, 1023.0 / (RobotMap.SHOOTER_RPM / 600.0 * 4096));
>>>>>>> origin/Rory
		shooterMotorTopLeft.setPID(0.12, 0.0012, 4.8);
		
		shooterMotorTopRight.changeControlMode(CANTalon.TalonControlMode.Follower);
		shooterMotorTopRight.set(RobotMap.SHOOTER_MOTOR_TOP_LEFT);
		shooterMotorTopRight.reverseOutput(false);
		
		shooterMotorBottom.changeControlMode(CANTalon.TalonControlMode.PercentVbus);;
		shooterMotorBottom.configNominalOutputVoltage(+0.0f, -0.0f);
		shooterMotorBottom.configPeakOutputVoltage(0.0f,-12.0f);
		shooterMotorBottom.reverseSensor(false);
		shooterMotorBottom.reverseOutput(false);
<<<<<<< HEAD
		
=======
	
>>>>>>> refs/remotes/origin/Rory
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new StopShooting());
    }
    
    public void spinUp(double shooterRpm) {
<<<<<<< HEAD
    	
    	shooterMotorTopLeft.changeControlMode(CANTalon.TalonControlMode.Speed);
		shooterMotorTopLeft.configPeakOutputVoltage(+0.0f,-12.0f);
		shooterMotorTopLeft.set(shooterRpm);
		System.out.format("Spin Up; RPM %f, Delta %f, Error %D%n",
	    		shooterMotorTopLeft.getSpeed(),
	    		shooterMotorTopLeft.getSpeed() - shooterRpm,
	    		shooterMotorTopLeft.getClosedLoopError());
		
=======
    	 	
    	shooterMotorTopLeft.changeControlMode(CANTalon.TalonControlMode.Speed);
		shooterMotorTopLeft.configPeakOutputVoltage(+0.0f,-12.0f);
		shooterMotorTopLeft.set(shooterRpm);
		
		if (loop++ > 10) {
			loop = 0;
			System.out.format("Spin Up; RPM %f Delta %f Error %d%n",  
					shooterMotorTopLeft.getSpeed(),
					shooterMotorTopLeft.getSpeed() - shooterRpm, 
					shooterMotorTopLeft.getClosedLoopError());
		}
    	
>>>>>>> refs/remotes/origin/Rory
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
<<<<<<< HEAD
		System.out.format("Spin Up; RPM %f, Delta %f, Error %D%n",
	    		shooterMotorTopLeft.getSpeed(),
	    		shooterMotorTopLeft.getSpeed() - shooterRpm,
	    		shooterMotorTopLeft.getClosedLoopError());
	    	
=======
		
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
>>>>>>> refs/remotes/origin/Rory
    	
    	shooterMotorBottom.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	shooterMotorBottom.configPeakOutputVoltage(0.0f, -12.0f);
    	shooterMotorBottom.set(0.75);
    	
    	SmartDashboard.putDouble("Start Shooting RPM", shooterMotorTopLeft.getSpeed());
    	SmartDashboard.putDouble("Start Shooting RPM", shooterMotorTopLeft.getSpeed()-shooterRpm);
    	SmartDashboard.putDouble("Start Shooting Error", shooterMotorTopLeft.getClosedLoopError());
    }
    
    public void stopShooting(int RPM) {
<<<<<<< HEAD
    	shooterMotorTopLeft.changeControlMode(CANTalon.TalonControlMode.Speed);
=======
>>>>>>> refs/remotes/origin/Rory
    	shooterMotorTopLeft.configPeakOutputVoltage(0.0f,0.0f);
    	shooterMotorTopLeft.set(0.0);
    	
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

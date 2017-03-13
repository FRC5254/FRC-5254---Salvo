package org.usfirst.frc.team5253.robot.subsystems;

import org.usfirst.frc.team5253.robot.RobotMap;
import org.usfirst.frc.team5253.robot.commands.ShooterStopShooting;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Shooter extends Subsystem {
<<<<<<< HEAD
	
	private static final double ShooterError = Math.abs(20);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	CANTalon shooterMotorTopRight = new CANTalon(RobotMap.SHOOTER_MOTOR_TOP_RIGHT);
	CANTalon shooterMotorTopLeft = new CANTalon(RobotMap.SHOOTER_MOTOR_TOP_LEFT);
	CANTalon shooterMotorTopLeft2 = new CANTalon(RobotMap.SHOOTER_MOTOR_TOP_LEFT2);
	CANTalon shooterMotorBottom = new CANTalon(RobotMap.SHOOTER_MOTOR_BOTTOM);
	
	int loop, maxError, minError = 10000000;
	
	public Shooter() {
		
<<<<<<< HEAD
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
=======

	// private static final double ShooterError = Math.abs(20);

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private CANTalon shooterMotorTopLeft = new CANTalon(RobotMap.SHOOTER_MOTOR_TOP_LEFT);
	private CANTalon shooterMotorTopRight = new CANTalon(RobotMap.SHOOTER_MOTOR_TOP_RIGHT);
	private CANTalon shooterMotorBottom = new CANTalon(RobotMap.SHOOTER_MOTOR_BOTTOM);

	Boolean shootingSpeedAchieved = false;
	double minShooting = 1000000.0;
	double maxShooting = 0;

	Boolean idleAchieved = false;
	double loop, maxError, minError = 10000000;
	double minIdle = 10000000.0;
	double maxIdle = 0.0;

	public Shooter() {

		shooterMotorTopLeft.changeControlMode(CANTalon.TalonControlMode.Speed);
		shooterMotorTopLeft.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		shooterMotorTopLeft.configNominalOutputVoltage(+0.0f, -0.0f);
		shooterMotorTopLeft.configPeakOutputVoltage(0.0f, -12.0f);
		shooterMotorTopLeft.reverseSensor(true);
		shooterMotorTopLeft.reverseOutput(true);
		shooterMotorTopLeft.setProfile(0);
		updatePID();
		System.out.format("Shooter RPM %f F calculated: %f using: %f%n", RobotMap.SHOOTER_RPM,
				1023.0 / (RobotMap.SHOOTER_RPM / 600.0 * 4096.0), shooterMotorTopLeft.getF());

		System.out.format("Shooter P %f I %f D %f%n", shooterMotorTopLeft.getP(), shooterMotorTopLeft.getI(),
				shooterMotorTopLeft.getD());

=======
		shooterMotorTopLeft.changeControlMode(CANTalon.TalonControlMode.Speed);
		shooterMotorTopLeft.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		shooterMotorTopLeft.configNominalOutputVoltage(+0.0f, -0.0f);
		shooterMotorTopLeft.configPeakOutputVoltage(0.0f,-12.0f);
		shooterMotorTopLeft.reverseSensor(true);
		shooterMotorTopLeft.reverseOutput(true);
		shooterMotorTopLeft.setProfile(0);
		shooterMotorTopLeft.setF(0.03916);
		shooterMotorTopLeft.setPID(0.128, 0.0, 0.2);
>>>>>>> refs/remotes/origin/Shooter-PID-Tuning
		shooterMotorTopRight.changeControlMode(CANTalon.TalonControlMode.Follower);
		shooterMotorTopRight.set(RobotMap.SHOOTER_MOTOR_TOP_LEFT);
		shooterMotorTopRight.reverseOutput(false);

		shooterMotorBottom.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		;
>>>>>>> refs/remotes/origin/master
		shooterMotorBottom.configNominalOutputVoltage(+0.0f, -0.0f);
		shooterMotorBottom.configPeakOutputVoltage(0.0f, -12.0f);
		shooterMotorBottom.reverseSensor(false);
<<<<<<< HEAD
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
		
=======
	}

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new ShooterStopShooting());
	}

	public void resetData() {
		minIdle = 10000000.0;
		maxIdle = 0.0;
		minShooting = 10000000.0;
		maxShooting = 0.0;
		maxError = 0.0;
		minError = 1000000000.0;
	}

	// public boolean shooterUpToSpeed() {
	//// if (RobotBase.isReal()) {
	// return shooterMotorTopLeft.getClosedLoopError() < ShooterError;
	//// } else {
	//// return true;
	//// }
	// }
	public void ResetMinMaxRpmValues() {

	}

	public void spinUp(double shooterRpm) {

		shooterMotorTopLeft.changeControlMode(CANTalon.TalonControlMode.Speed);
		shooterMotorTopLeft.configPeakOutputVoltage(+0.0f, -12.0f);
		// updatePID();
		shooterMotorTopLeft.set(shooterRpm);// SmartDashboard.getNumber("DB/Slider
											// 0", -0.75)

		if (loop++ > 10) {
			loop = 0;
			System.out.format("Spin Up; RPM %f Delta %f Error %d%n", shooterMotorTopLeft.getSpeed(),
					shooterMotorTopLeft.getSpeed() - shooterRpm, shooterMotorTopLeft.getClosedLoopError());
		}

		shooterMotorBottom.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		shooterMotorBottom.set(0.0);

		SmartDashboard.putNumber("Spin Up RPM", shooterMotorTopLeft.getSpeed());
		// SmartDashboard.putNumber("Spin Up Error",
		// shooterMotorTopLeft.getClosedLoopError());

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

		shooterMotorTopLeft.changeControlMode(CANTalon.TalonControlMode.Speed);
		shooterMotorTopLeft.configPeakOutputVoltage(0.0f, -12.0f);
		// updatePID();
		shooterMotorTopLeft.set(shooterRpm);// SmartDashboard.getNumber("DB/Slider
											// 1", -0.75)

		double currentRpm = shooterMotorTopLeft.getSpeed();
		int closedLoopError = shooterMotorTopLeft.getClosedLoopError();

		maxError = Math.max(maxError, Math.abs(currentRpm));
		minError = Math.min(minError, Math.abs(currentRpm));

>>>>>>> refs/remotes/origin/master
		if (loop++ > 10) {
			loop = 0;
			System.out.format("Start Shooting; RPM %f Delta %f Error %d%n", currentRpm, currentRpm - shooterRpm,
					closedLoopError);
		}
<<<<<<< HEAD
    	
    	shooterMotorBottom.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	shooterMotorBottom.configPeakOutputVoltage(0.0f, -12.0f);
    	shooterMotorBottom.set(0.75);
    	
    	SmartDashboard.putNumber("Start Shooting RPM", shooterMotorTopLeft.getSpeed());
    	SmartDashboard.putDouble("Start Shooting RPM", shooterMotorTopLeft.getSpeed()-shooterRpm);
    	SmartDashboard.putDouble("Start Shooting Error", shooterMotorTopLeft.getClosedLoopError());
    }
    
    public void stopShooting(int RPM) {
<<<<<<< HEAD
    	shooterMotorTopRight.changeControlMode(CANTalon.TalonControlMode.Speed);
    	shooterMotorTopRight.configPeakOutputVoltage(0.0f,0.0f);
    	shooterMotorTopRight.set(0.0);
    	
    	if (minError != 10000000 || maxError != 0) {
    		System.out.format("Stop: minError %d maxError %d%n", minError, maxError);
    		minError = 10000000;
    		maxError = 0;
    	}
=======
    	shooterMotorTopLeft.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	shooterMotorTopLeft.configPeakOutputVoltage(0.0f,0.0f);
    	shooterMotorTopLeft.set(0.0);
>>>>>>> refs/remotes/origin/Shooter-PID-Tuning
    	
    	shooterMotorBottom.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	shooterMotorBottom.set(0.0);
    	
    }
	public boolean shooterUpToSpeed() {
//		if (RobotBase.isReal()) {
			return shooterMotorTopRight.getClosedLoopError() < ShooterError;
//	} else {
//		return true;
//		}
=======

		shooterMotorBottom.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		shooterMotorBottom.configPeakOutputVoltage(0.0f, -12.0f);
		shooterMotorBottom.set(0.75);

		SmartDashboard.putNumber("Start Shooting RPM", shooterMotorTopLeft.getSpeed());
		SmartDashboard.putNumber("Shooter RPM", shooterMotorTopLeft.getSpeed());
		// SmartDashboard.putNumber("Shooter RPM", shooterRpm);
		// SmartDashboard.putNumber("Start Shooting Error",
		// shooterMotorTopLeft.getClosedLoopError());

		if (shooterMotorTopLeft.getSpeed() >= shooterRpm) {
			shootingSpeedAchieved = true;
		}

		if (shootingSpeedAchieved = true) {
			maxShooting = Math.max(maxShooting, shooterMotorTopLeft.getSpeed());
			minShooting = Math.min(minShooting, shooterMotorTopLeft.getSpeed());

			SmartDashboard.putString("DB/String 3", Double.toString(minShooting));
			SmartDashboard.putString("DB/String 8", Double.toString(maxShooting));
		}
	}

	public void stopShooting(int ShooterRpm) {

		shooterMotorTopLeft.configPeakOutputVoltage(0.0f, 0.0f);
		shooterMotorTopLeft.set(0.0);

		minIdle = 10000000.0;
		maxIdle = 0.0;
		idleAchieved = false;

		shootingSpeedAchieved = false;
		minShooting = 1000000.0;
		maxShooting = 0;

		if (minError != 10000000 || maxError != 0) {
			System.out.format("Stop: minError %f maxError %f%n", minError, maxError);
			minError = 10000000;
			maxError = 0;
		}

		shooterMotorBottom.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		shooterMotorBottom.set(0.0);

	}

	public void updatePID() {
		shooterMotorTopLeft.setF(RobotMap.SHOOTER_PID_F);
		shooterMotorTopLeft.setP(RobotMap.SHOOTER_PID_P);
		shooterMotorTopLeft.setI(RobotMap.SHOOTER_PID_I);
		shooterMotorTopLeft.setD(RobotMap.SHOOTER_PID_D);
>>>>>>> refs/remotes/origin/master
	}
}

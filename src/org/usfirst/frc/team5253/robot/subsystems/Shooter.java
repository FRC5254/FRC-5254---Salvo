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

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	CANTalon shooterMotorTopLeft = new CANTalon(RobotMap.SHOOTER_MOTOR_TOP_LEFT);
	CANTalon shooterMotorTopRight = new CANTalon(RobotMap.SHOOTER_MOTOR_TOP_RIGHT);
	CANTalon shooterMotorBottom = new CANTalon(RobotMap.SHOOTER_MOTOR_BOTTOM);

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
		shooterMotorTopLeft.setF(RobotMap.SHOOTER_PID_F_SHORT);
		System.out.format("Shooter RPM %f F calculated: %f using: %f%n", RobotMap.SHOOTER_RPM_SHORT,
				1023.0 / (RobotMap.SHOOTER_RPM_SHORT / 600.0 * 4096.0), shooterMotorTopLeft.getF());
		shooterMotorTopLeft.setP(RobotMap.SHOOTER_PID_P_SHORT);
		shooterMotorTopLeft.setI(RobotMap.SHOOTER_PID_I_SHORT);
		shooterMotorTopLeft.setD(RobotMap.SHOOTER_PID_D_SHORT);
		System.out.format("Shooter P %f I %f D %f%n", shooterMotorTopLeft.getP(), shooterMotorTopLeft.getI(),
				shooterMotorTopLeft.getD());

		shooterMotorTopRight.changeControlMode(CANTalon.TalonControlMode.Follower);
		shooterMotorTopRight.set(RobotMap.SHOOTER_MOTOR_TOP_LEFT);
		shooterMotorTopRight.reverseOutput(false);

		shooterMotorBottom.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		shooterMotorBottom.configNominalOutputVoltage(+0.0f, -0.0f);
		shooterMotorBottom.configPeakOutputVoltage(0.0f, -12.0f);
		shooterMotorBottom.reverseSensor(false);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new ShooterStopShooting());
	}

	public void spinUp(boolean longshot) {
		if (longshot) {
			
			shooterMotorTopLeft.changeControlMode(CANTalon.TalonControlMode.Speed);
			shooterMotorTopLeft.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
			shooterMotorTopLeft.configNominalOutputVoltage(+0.0f, -0.0f);
			shooterMotorTopLeft.configPeakOutputVoltage(0.0f, -12.0f);
			shooterMotorTopLeft.reverseSensor(true);
			shooterMotorTopLeft.reverseOutput(true);
			shooterMotorTopLeft.setProfile(0);
			shooterMotorTopLeft.setF(RobotMap.SHOOTER_PID_F_LONG);
			shooterMotorTopLeft.setP(RobotMap.SHOOTER_PID_P_LONG);
			shooterMotorTopLeft.setI(RobotMap.SHOOTER_PID_I_LONG);
			shooterMotorTopLeft.setD(RobotMap.SHOOTER_PID_D_LONG);
			
			shooterMotorTopLeft.changeControlMode(CANTalon.TalonControlMode.Speed);
			shooterMotorTopLeft.configPeakOutputVoltage(0.0f, -12.0f);
			shooterMotorTopLeft.set(RobotMap.SHOOTER_RPM_LONG);
			
			if (loop++ > 10) {
				loop = 0;
				// System.out.format("Spin Up; RPM %f Delta %f Error %d%n",
				// shooterMotorTopLeft.getSpeed(),
				// shooterMotorTopLeft.getSpeed() - shooterRpm,
				// shooterMotorTopLeft.getClosedLoopError());

				System.out.format("Spin Up; RPM %f Delta %f%n", shooterMotorTopLeft.getSpeed(),
						shooterMotorTopLeft.getSpeed() - RobotMap.SHOOTER_RPM_LONG);
			}
			
			if (shooterMotorTopLeft.getSpeed() >= RobotMap.SHOOTER_RPM_LONG) {
				idleAchieved = true;
			}
			
		} else {
			
			shooterMotorTopLeft.changeControlMode(CANTalon.TalonControlMode.Speed);
			shooterMotorTopLeft.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
			shooterMotorTopLeft.configNominalOutputVoltage(+0.0f, -0.0f);
			shooterMotorTopLeft.configPeakOutputVoltage(0.0f, -12.0f);
			shooterMotorTopLeft.reverseSensor(true);
			shooterMotorTopLeft.reverseOutput(true);
			shooterMotorTopLeft.setProfile(0);
//			shooterMotorTopLeft.setF(RobotMap.SHOOTER_PID_F_SHORT);
//			shooterMotorTopLeft.setP(RobotMap.SHOOTER_PID_P_SHORT);
//			shooterMotorTopLeft.setI(RobotMap.SHOOTER_PID_I_SHORT);
//			shooterMotorTopLeft.setD(RobotMap.SHOOTER_PID_D_SHORT);
			
			shooterMotorTopLeft.changeControlMode(CANTalon.TalonControlMode.Speed);
			shooterMotorTopLeft.configPeakOutputVoltage(0.0f, -12.0f);
			shooterMotorTopLeft.set(RobotMap.SHOOTER_RPM_SHORT);
			
			if (loop++ > 10) {
				loop = 0;
				// System.out.format("Spin Up; RPM %f Delta %f Error %d%n",
				// shooterMotorTopLeft.getSpeed(),
				// shooterMotorTopLeft.getSpeed() - shooterRpm,
				// shooterMotorTopLeft.getClosedLoopError());

				System.out.format("Spin Up; RPM %.2f Delta %.2f Voltage %.2f%n.", shooterMotorTopLeft.getSpeed(),
						shooterMotorTopLeft.getSpeed() - RobotMap.SHOOTER_RPM_SHORT, shooterMotorTopLeft.getOutputVoltage());
			}
			
			if (shooterMotorTopLeft.getSpeed() >= RobotMap.SHOOTER_RPM_SHORT) {
				idleAchieved = true;
			}
		}

		shooterMotorBottom.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		shooterMotorBottom.set(0.0);

		SmartDashboard.putNumber("Spin Up RPM", shooterMotorTopLeft.getSpeed());
		// SmartDashboard.putNumber("Spin Up Error",
		// shooterMotorTopLeft.getClosedLoopError());

	}

	public void startShooting(boolean longshot) {
		
		double currentRpm = shooterMotorTopLeft.getSpeed();
		int closedLoopError = shooterMotorTopLeft.getClosedLoopError();
		
		if (longshot) {
			
			shooterMotorTopLeft.changeControlMode(CANTalon.TalonControlMode.Speed);
			shooterMotorTopLeft.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
			shooterMotorTopLeft.configNominalOutputVoltage(+0.0f, -0.0f);
			shooterMotorTopLeft.configPeakOutputVoltage(0.0f, -12.0f);
			shooterMotorTopLeft.reverseSensor(true);
			shooterMotorTopLeft.reverseOutput(true);
			shooterMotorTopLeft.setProfile(0);
			//shooterMotorTopLeft.setF(RobotMap.SHOOTER_PID_F_LONG);
			//shooterMotorTopLeft.setP(RobotMap.SHOOTER_PID_P_LONG);
			//shooterMotorTopLeft.setI(RobotMap.SHOOTER_PID_I_LONG);
			//shooterMotorTopLeft.setD(RobotMap.SHOOTER_PID_D_LONG);
			
			shooterMotorTopLeft.changeControlMode(CANTalon.TalonControlMode.Speed);
			shooterMotorTopLeft.configPeakOutputVoltage(0.0f, -12.0f);
			//shooterMotorTopLeft.set(RobotMap.SHOOTER_RPM_LONG);
			
			if (loop++ > 10) {
				loop = 0;
				System.out.format("Start Shooting; RPM %f Delta %f Error %d%n", currentRpm, currentRpm - RobotMap.SHOOTER_RPM_LONG,
						closedLoopError);
			}
			
			if (shooterMotorTopLeft.getSpeed() >= RobotMap.SHOOTER_RPM_LONG) {
				shootingSpeedAchieved = true;
			}
			
		} else {
			
			shooterMotorTopLeft.changeControlMode(CANTalon.TalonControlMode.Speed);
			shooterMotorTopLeft.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
			shooterMotorTopLeft.configNominalOutputVoltage(+0.0f, -0.0f);
			shooterMotorTopLeft.configPeakOutputVoltage(0.0f, -12.0f);
			shooterMotorTopLeft.reverseSensor(true);
			shooterMotorTopLeft.reverseOutput(true);
			shooterMotorTopLeft.setProfile(0);
			//shooterMotorTopLeft.setF(RobotMap.SHOOTER_PID_F_SHORT);
			//System.out.format("Shooter RPM %f F calculated: %f using: %f%n", RobotMap.SHOOTER_RPM_SHORT,
			//		1023.0 / (RobotMap.SHOOTER_RPM_SHORT / 600.0 * 4096.0), shooterMotorTopLeft.getF());
			//shooterMotorTopLeft.setP(RobotMap.SHOOTER_PID_P_SHORT);
			//shooterMotorTopLeft.setI(RobotMap.SHOOTER_PID_I_SHORT);
			//shooterMotorTopLeft.setD(RobotMap.SHOOTER_PID_D_SHORT);
			
			shooterMotorTopLeft.changeControlMode(CANTalon.TalonControlMode.Speed);
			shooterMotorTopLeft.configPeakOutputVoltage(0.0f, -12.0f);
			shooterMotorTopLeft.set(RobotMap.SHOOTER_RPM_SHORT);
			/*
			if (loop++ > 10) {
				loop = 0;
				System.out.format("Start Shooting; RPM %f Delta %f Error %d%n", currentRpm, currentRpm - RobotMap.SHOOTER_RPM_SHORT,
						closedLoopError);
				
				if (shooterMotorTopLeft.getSpeed() >= RobotMap.SHOOTER_RPM_SHORT) {
					shootingSpeedAchieved = true;
				}
			}
			
			*/
		
		}

		

		maxError = Math.max(maxError, Math.abs(currentRpm));
		minError = Math.min(minError, Math.abs(currentRpm));

		shooterMotorBottom.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		shooterMotorBottom.configPeakOutputVoltage(0.0f, -12.0f);
		shooterMotorBottom.set(0.75);

		SmartDashboard.putNumber("Start Shooting RPM", shooterMotorTopLeft.getSpeed());
		SmartDashboard.putNumber("Shooter RPM", shooterMotorTopLeft.getSpeed());
		// SmartDashboard.putNumber("Shooter RPM", shooterRpm);
		// SmartDashboard.putNumber("Start Shooting Error",
		// shooterMotorTopLeft.getClosedLoopError());

		if (shootingSpeedAchieved = true) {
			maxShooting = Math.max(maxShooting, shooterMotorTopLeft.getSpeed());
			minShooting = Math.min(minShooting, shooterMotorTopLeft.getSpeed());

			SmartDashboard.putString("DB/String 3", Double.toString(minShooting));
			SmartDashboard.putString("DB/String 8", Double.toString(maxShooting));
		}
	}

	public void stopShooting() {

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

	// public boolean shooterUpToSpeed() {
	//// if (RobotBase.isReal()) {
	// return shooterMotorTopLeft.getClosedLoopError() < ShooterError;
	//// } else {
	//// return true;
	//// }
	// }
}

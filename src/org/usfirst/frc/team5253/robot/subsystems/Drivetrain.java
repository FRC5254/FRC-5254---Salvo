package org.usfirst.frc.team5253.robot.subsystems;

import org.usfirst.frc.team5253.robot.Robot;
import org.usfirst.frc.team5253.robot.RobotMap;
import org.usfirst.frc.team5253.robot.commands.DriveWithJoystick;
import org.usfirst.frc.team5253.robot.commands.ShiftDown;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Encoder;

public class Drivetrain extends Subsystem{
	
	static ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	public static RobotDrive myRobot = new RobotDrive(2, 3, 0, 1);
	public static Solenoid shiftingPiston = new Solenoid(RobotMap.SHIFTING_PISTON);
	public static Encoder encoder = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
	
	double angle;
	public double DKp = 0.07;
	public double TKp = 0.3;
	public boolean shiftState = false;
	private static double finalModifier;
	private static double distance;
	private static double turnSpeed;
	//private static double camera = 0;
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new DriveWithJoystick());
	}
	
	public void drive(double Throttle, double Turn){
		myRobot.arcadeDrive(Throttle, Turn);
		
	}
	public void slowTrun(double Throttle, double Turn) {
		myRobot.arcadeDrive(Throttle, 0.5 * Turn);
	}
	
	public void shiftDown() {
		shiftingPiston.set(true);
		shiftState = true;
	}
	
	public void shiftUp() {
		shiftingPiston.set(false);
		shiftState = true;
	}

	
	public void resetGyro() {
		gyro.reset();
	}
	
	public double getAngle() {
		return gyro.getAngle();
	}
	
	public void initEncoder() {
		encoder.reset();
		encoder.setMaxPeriod(0.1);
		encoder.setMinRate(1);
		encoder.setDistancePerPulse(1);
		encoder.setReverseDirection(true);
		encoder.setSamplesToAverage(7);
	}
	
	public void autoDrive(double Throttle, double Turn, double distance) {
		double wheelDiameter = RobotMap.WHEEL_DIAMETER;
		double gearRatio = RobotMap.GEAR_RATIO;
		double encoderTicks = 256;
		finalModifier = (Math.abs(distance)/(wheelDiameter * Math.PI))  * encoderTicks * gearRatio ;
		
		double remaining = finalModifier - Math.abs(encoder.get());
		double finalThrottle;
		double sign = Throttle/Math.abs(Throttle);
		if (Throttle > 0){
			finalThrottle = remaining/3000;
		}else{
			finalThrottle = sign * (-remaining/3000);
		}
		
		this.distance = distance;
		
		if (Math.abs(finalThrottle) < 0.25){
			if (encoder.get() <= finalModifier) {
				myRobot.drive(-finalThrottle, Turn);
				System.out.println(finalThrottle);
			}
		}else if (Math.abs(finalThrottle) > 0.25){
			myRobot.drive((sign*0.25), Turn);
		}
	}
	
	public void autoTurn(double angle) {
		turnSpeed = angle - gyro.getAngle();
		if (gyro.getAngle() >= angle) {
			drive(0.0, turnSpeed / 50);
		} else if (gyro.getAngle() <= angle + 1) {
			drive(0.0, turnSpeed / 50);
		} else {
			drive(0.0, 0.0);
		}
		
	}
	
	public boolean driveAutoIsFinished() {
		return Math.abs(encoder.get()) >= Math.abs(finalModifier);
	}

	public void stop() {
		myRobot.arcadeDrive(0.0, 0.0);
		
	}
}
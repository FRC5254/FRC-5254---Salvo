package org.usfirst.frc.team5253.robot.subsystems;

import org.usfirst.frc.team5253.robot.RobotMap;
import org.usfirst.frc.team5253.robot.commands.DriveWithJoystick;


import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;

public class Drivetrain extends Subsystem{
	
	static ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	static RobotDrive myRobot = new RobotDrive(2, 3, 0, 1);
	static Solenoid shiftingPiston = new Solenoid(RobotMap.SHIFTING_PISTON);
	static Encoder encoder = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
	

	public double angle = gyro.getAngle();
	public double Kp = 0.65;

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new DriveWithJoystick());
	}
	
	public void drive(double Throttle, double Turn){
		myRobot.arcadeDrive(Throttle, Turn);
		
	}
	
	public static void shiftUp() {
		shiftingPiston.set(true);
	}
	
	public static void shiftDown() {
		shiftingPiston.set(false);
	}
	
	public void resetGyro() {
		gyro.reset();
	}
	
	public void getAngle() {
		gyro.getAngle();
	}
	
	public void initEncoder() {
		encoder.reset();
		encoder.setMaxPeriod(0.1);
		encoder.setMinRate(1);
		encoder.setDistancePerPulse(1);
		encoder.setReverseDirection(false);
		encoder.setSamplesToAverage(7);
	}
	
	public void autoDrive(double Throttle, double Turn, double distance) {
		
		double wheelDiameter = 6;
		double gearRatio = 9;
		final double pi = 3.1415926535;
		double encoderTicks = 256;
		double finalModifier =(distance/(wheelDiameter * pi))  * encoderTicks * gearRatio ;
		if (encoder.get() < finalModifier) {
			myRobot.drive(Throttle, Turn);
		}
	}

	public void stop() {
		myRobot.arcadeDrive(0.0, 0.0);
	}
}
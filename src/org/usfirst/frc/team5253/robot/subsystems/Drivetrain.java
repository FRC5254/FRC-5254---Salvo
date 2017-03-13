package org.usfirst.frc.team5253.robot.subsystems;

import org.usfirst.frc.team5253.robot.RobotMap;
import org.usfirst.frc.team5253.robot.commands.DrivetrainDriveWithJoystick;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class Drivetrain extends PIDSubsystem {
<<<<<<< HEAD
	
=======

>>>>>>> refs/remotes/origin/master
	static ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	public static RobotDrive myRobot = new RobotDrive(2, 3, 0, 1);
	public static Solenoid shiftingPiston = new Solenoid(RobotMap.SHIFTING_PISTON);
	public static Encoder encoder = new Encoder(2, 3, false, Encoder.EncodingType.k4X);

	private static int finalTicks;
	double angle;
	public double DKp = 0.035;
	public double TKp = 0.3;
<<<<<<< HEAD
	private int remainingTicks;
	private double Throttle;
	private double distance;
	// private static double camera = 0;

	public Drivetrain() {
		super("DriveTrain", .02, .002, .2);
		setAbsoluteTolerance(3.0);
		getPIDController().setContinuous(true);
=======
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
		
>>>>>>> refs/remotes/origin/Shooter-PID-Tuning
	}

	public void autoDrive() {
		double sign = Math.signum(distance);
		double Turn = -sign * getAngle() * DKp;
		remainingTicks = (int) (sign * (Math.abs(finalTicks) - Math.abs(encoder.get())));
		double finalThrottle;

		// finalThrottle = 0.4;
		if (Math.abs(remainingTicks) < 1000) {
			Throttle = Math.abs(remainingTicks) / 1000;
			if (Throttle < 0.2) {
				Throttle = 0.2;
			}
		}
		Throttle = -Throttle * sign;

		// System.out.format("autoDrive: finalThrottle %f, Turn %f, remaining
		// %d, ticks %d%n", finalThrottle, Turn, remainingTicks, encoder.get());
		myRobot.drive(Throttle, Turn);
	}

	public void autoDriveInitialize(double Throttle, double distance) {
		this.distance = distance;
		this.Throttle = Throttle;
		finalTicks = (int) ((distance / (RobotMap.WHEEL_DIAMETER * Math.PI)) * RobotMap.WHEEL_TICKS
				* RobotMap.GEAR_RATIO);
		initEncoder();
		resetGyro();
	}

	public void drive(double Throttle, double Turn) {
		myRobot.arcadeDrive(Throttle, Turn);

	}

	public boolean driveAutoIsFinished() {
		return Math.abs(remainingTicks) < 20; // ~ 1/2 "
	}

	public double getAngle() {
		return gyro.getAngle();
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new DrivetrainDriveWithJoystick());
	}

	public void initEncoder() {
		encoder.reset();
		encoder.setMaxPeriod(0.1);
		encoder.setMinRate(1);
		encoder.setDistancePerPulse(1);
		encoder.setReverseDirection(true);
		encoder.setSamplesToAverage(7);
	}

	public void resetGyro() {
		gyro.reset();
	}

	@Override
	protected double returnPIDInput() {
		// Return your input value for the PID loop
		// e.g. a sensor, like a potentiometer:
		// yourPot.getAverageVoltage() / kYourMaxVoltage
		return getAngle();
	}

	public void shiftDown() {
		shiftingPiston.set(true);
	}

	public void shiftUp() {
		shiftingPiston.set(false);
	}

	public void slowTrun(double Throttle, double Turn) {
		myRobot.arcadeDrive(Throttle, 0.5 * Turn);
	}

	public void stop() {
		myRobot.arcadeDrive(0.0, 0.0);

	}

	public void Turn(double outputMagnitude, double curve) {
		myRobot.drive(outputMagnitude, curve);
	}

	@Override
	protected void usePIDOutput(double output) {
		// Use output to drive your system, like a motor
		// e.g. yourMotor.set(output);
		drive(0.0, output);
	}
}
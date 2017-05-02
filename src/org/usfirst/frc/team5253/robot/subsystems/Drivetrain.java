package org.usfirst.frc.team5253.robot.subsystems;

import org.usfirst.frc.team5253.robot.RobotMap;
import org.usfirst.frc.team5253.robot.commands.DrivetrainDriveWithJoystick;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class Drivetrain extends PIDSubsystem {

	static ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	public static RobotDrive myRobot = new RobotDrive(2, 3, 0, 1);
	public static Solenoid shiftingPiston = new Solenoid(RobotMap.SHIFTING_PISTON);
	public static Encoder encoder = new Encoder(2, 3, true, Encoder.EncodingType.k4X);
	public static Timer timer = new Timer();

	double angle;
	public double DKp = 0.3; // TODO confirm setting for competition robot
	public double TKp = 0.3;
	public double GTKp = 0.2;
	private static int finalTicks;
	private int remainingTicks;
	private double Throttle;
	private double remainingDistance;
	private double finalThrottle;

	public Drivetrain() {
		super("DriveTrain", .02, .002, .2);
		setAbsoluteTolerance(3.0);
		getPIDController().setContinuous(true);
	}

	protected void initDefaultCommand() {
		setDefaultCommand(new DrivetrainDriveWithJoystick());
	}

	public void drive(double Throttle, double Turn) {
		myRobot.arcadeDrive(Throttle, Turn);

	}

	public void slowTrun(double Throttle, double Turn) {
		myRobot.arcadeDrive(Throttle, 0.5 * Turn);
	}

	public void shiftDown() {
		shiftingPiston.set(true);
	}

	public void shiftUp() {
		shiftingPiston.set(false);
	}

	public void resetGyro() {
		gyro.reset();
	}

	public double getAngle() {
		return gyro.getAngle();
	}

	public void initEncoder(boolean direction) {
		encoder.reset();
		encoder.setMaxPeriod(0.1);
		encoder.setMinRate(1);
		encoder.setDistancePerPulse(1);
		encoder.setReverseDirection(direction);
		encoder.setSamplesToAverage(7);
	}

	public void autoDriveInitialize(double Throttle, double distance) {
		this.Throttle = Throttle;
		finalTicks = (int) ((distance / (RobotMap.WHEEL_DIAMETER * Math.PI)) * RobotMap.ENCODER_TICKS
				* RobotMap.GEAR_RATIO);
		if (Throttle > 0) {
			initEncoder(true);
		} else {
			initEncoder(false);
		}
		gyro.reset();
		timer.reset();
		timer.start();
	}

	public void autoDrive() {
		remainingTicks = Math.abs(finalTicks) - Math.abs(encoder.get());
		remainingDistance = (Math.abs(remainingTicks) / (RobotMap.ENCODER_TICKS * RobotMap.GEAR_RATIO))
				* (RobotMap.WHEEL_DIAMETER * Math.PI);

		if (Throttle > 0) {
			if (remainingDistance < Throttle * 15) {
				finalThrottle = remainingDistance / 15;// TODO time these values
			} else {
				finalThrottle = Throttle;
			}

			if (timer.get() < 0.25 && remainingDistance > 10.0) {
				finalThrottle = timer.get() * 4.0;
			}

			if (finalThrottle > Throttle) {
				finalThrottle = Throttle;
			}

			if (finalThrottle < 0.35) {
				finalThrottle = 0.35;
			}
		} else {
			if (remainingDistance < Math.abs(Throttle) * 15) {
				finalThrottle = -remainingDistance / 15;
			} else {
				finalThrottle = Throttle;

			}

			if (timer.get() < 0.25 && remainingDistance > 10.0) {
				finalThrottle = -timer.get() * 4.0;
			}

			if (finalThrottle < Throttle) {
				finalThrottle = Throttle;
			}

			if (finalThrottle > -0.35) {
				finalThrottle = -0.35;
			}
		}

		drive(-finalThrottle, -getAngle() * DKp);
		 System.out.println(gyro.getAngle() + " " + Throttle + " " +
		 remainingDistance + " " + finalThrottle + " " + encoder.get() + " " +
		 remainingTicks);
	}

	protected double returnPIDInput() {
		// Return your input value for the PID loop
		// e.g. a sensor, like a potentiometer:
		// yourPot.getAverageVoltage() / kYourMaxVoltage
		return getAngle();
	}

	protected void usePIDOutput(double output) {
		// Use output to drive your system, like a motor
		// e.g. yourMotor.set(output);
		drive(0.0, output);
	}

	public boolean driveAutoIsFinished() {
		return Math.abs(remainingTicks) < 21; // ~ 1/2 "
	}

	public void stop() {
		myRobot.arcadeDrive(0.0, 0.0);

	}

}
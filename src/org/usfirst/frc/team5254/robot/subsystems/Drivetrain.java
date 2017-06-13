package org.usfirst.frc.team5254.robot.subsystems;

import org.usfirst.frc.team5254.robot.Robot;
import org.usfirst.frc.team5254.robot.RobotMap;
import org.usfirst.frc.team5254.robot.commands.DrivetrainDriveWithJoystick;

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
	private static int finalTicks;
	private int remainingTicks;
	private double Throttle;
	private double remainingDistance;
	private double finalThrottle;

	public Drivetrain() {
		super("DriveTrain", RobotMap.TURN_P, RobotMap.TURN_I, RobotMap.TURN_D);
		setAbsoluteTolerance(3.0);
		getPIDController().setContinuous(true);
	}
	
	//Utilities
	
	public void drive(double Throttle, double Turn) {
		myRobot.arcadeDrive(Throttle, Turn);

	}
	
	public void stop() {
		myRobot.arcadeDrive(0.0, 0.0);

	}
	
	//Teleop
	
	protected void initDefaultCommand() {
		setDefaultCommand(new DrivetrainDriveWithJoystick());
	}

	public void slowTurn(double Throttle, double Turn) {
		myRobot.arcadeDrive(Throttle, 0.5 * Turn);
	}

	public void shiftDown() {
		shiftingPiston.set(true);
	}

	public void shiftUp() {
		shiftingPiston.set(false);
	}

	//Autonomous
	
	public void initEncoder(boolean direction) {
		encoder.reset();
		encoder.setMaxPeriod(0.1);
		encoder.setMinRate(1);
		encoder.setDistancePerPulse(1);
		encoder.setReverseDirection(direction);
		encoder.setSamplesToAverage(7);
	}

	public void autoDistanceDriveInit(double Throttle, double distance) {
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

	public void autoDriveToDistance() {
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

		drive(-finalThrottle, -gyro.getAngle() * RobotMap.Kp);
		 System.out.println(gyro.getAngle() + " " + Throttle + " " +
		 remainingDistance + " " + finalThrottle + " " + encoder.get() + " " +
		 remainingTicks);
	}
	
	public void autoDistanceDriveFast(){
		remainingTicks = Math.abs(finalTicks) - Math.abs(encoder.get());
		drive(-Throttle,-gyro.getAngle() * RobotMap.Kp);
	}
	
	public void PIDTurnInit() {
		Robot.Drivetrain.setSetpoint(gyro.getAngle() + this.angle);
		Robot.Drivetrain.enable();
	}

	protected double returnPIDInput() {
		// Return your input value for the PID loop
		// e.g. a sensor, like a potentiometer:
		// yourPot.getAverageVoltage() / kYourMaxVoltage
		return gyro.getAngle();
	}

	protected void usePIDOutput(double output) {
		// Use output to drive your system, like a motor
		// e.g. yourMotor.set(output);
		drive(0.0, output);
	}

	public boolean driveAutoIsFinished() {
		return remainingTicks < 21; // ~ 1/2 "
	}

	

	
}
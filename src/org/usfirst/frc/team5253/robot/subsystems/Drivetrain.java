package org.usfirst.frc.team5253.robot.subsystems;

import org.usfirst.frc.team5253.robot.RobotMap;
import org.usfirst.frc.team5253.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem{
	
	static RobotDrive myRobot = new RobotDrive(2, 3, 0, 1);
	static Solenoid shiftingPiston = new Solenoid(RobotMap.SHIFTING_PISTON);

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
	
	public void driveForward() {
		myRobot.arcadeDrive(1.0, 0.0);
	}
	
	public void driveBackwards() {
		myRobot.arcadeDrive(-1.0, 0.0);
	}
	
	public void stop() {
		myRobot.arcadeDrive(0.0, 0.0);
	}
	
	public void turnRight() {
		myRobot.arcadeDrive(0.0, 1.0);
	}
	
	public void turnLeft() {
		myRobot.arcadeDrive(0.0, -1.0);
	}
}
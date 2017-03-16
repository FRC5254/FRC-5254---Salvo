package org.usfirst.frc.team5253.robot.commands;

import org.usfirst.frc.team5253.robot.Robot;
import org.usfirst.frc.team5253.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DrivetrainDriveWithJoystick extends Command {

	public DrivetrainDriveWithJoystick() {

		requires(Robot.Drivetrain);

		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.Drivetrain.shiftDown();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		System.out.println(
				"Right Trigger " + Robot.oi.driver.getRawAxis(3) + "    Left Trigger " + Robot.oi.driver.getRawAxis(2));
		// TODO
		// if (Robot.oi.driver.getRawAxis(3) >= .9 ||
		// Robot.oi.driver.getRawAxis(2) >= .9) {
		// Robot.Drivetrain.slowTrun(Robot.oi.driver.getRawAxis(RobotMap.DRIVER_THROTTLE_AXIS),
		// Robot.oi.driver.getRawAxis(RobotMap.DRIVER_TURN_AXIS) * 0.5);
		// } else {
		// Robot.Drivetrain.drive(Robot.oi.driver.getRawAxis(RobotMap.DRIVER_THROTTLE_AXIS),
		// Robot.oi.driver.getRawAxis(RobotMap.DRIVER_TURN_AXIS));
		// }
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.Drivetrain.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}

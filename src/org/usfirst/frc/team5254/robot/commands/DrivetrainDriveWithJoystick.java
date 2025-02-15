package org.usfirst.frc.team5254.robot.commands;

import org.usfirst.frc.team5254.robot.Robot;
import org.usfirst.frc.team5254.robot.RobotMap;

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
		Robot.Drivetrain.drive(Robot.oi.driver.getRawAxis(RobotMap.DRIVER_THROTTLE_AXIS),
				Robot.oi.driver.getRawAxis(RobotMap.DRIVER_TURN_AXIS));
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

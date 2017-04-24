package org.usfirst.frc.team5253.robot.autocommands;

import org.usfirst.frc.team5253.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDriveToDistance extends Command {

	double Throttle;
	double Distance;

	public AutoDriveToDistance(double Throttle, double Distance) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		this.Throttle = Throttle; // TODO ask Rorster if this works that it gets
									// the throttle
		this.Distance = Distance;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.Drivetrain.autoDriveInitialize(Throttle, Distance);
		// System.out.format("DriveToDistance(%f,%f)%n", this.Throttle, this.Distance);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.Drivetrain.autoDrive();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		 
		return Robot.Drivetrain.driveAutoIsFinished();
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

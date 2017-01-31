package org.usfirst.frc.team5253.robot.commands;

import org.usfirst.frc.team5253.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveToDistance extends Command {

    double Throttle;
    double Distance;
    
	public DriveToDistance(double Throttle, double Distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.Drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.Drivetrain.resetGyro();
    	Robot.Drivetrain.getAngle();
    	Robot.Drivetrain.initEncoder();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.Drivetrain.autoDrive(Throttle, -Robot.Drivetrain.angle * Robot.Drivetrain.Kp, Distance);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}

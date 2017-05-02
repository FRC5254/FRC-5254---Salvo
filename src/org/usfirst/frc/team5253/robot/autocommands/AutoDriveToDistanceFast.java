package org.usfirst.frc.team5253.robot.autocommands;

import org.usfirst.frc.team5253.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDriveToDistanceFast extends Command {
	
	double throttle;
	double distance;
	
    public AutoDriveToDistanceFast(double throttle, double distance) {
    	
    	this.throttle = throttle;
    	this.distance = distance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.Drivetrain.autoDriveInitialize(throttle, distance);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.Drivetrain.autoDriveFast();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.Drivetrain.driveAutoIsFinished();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.Drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}

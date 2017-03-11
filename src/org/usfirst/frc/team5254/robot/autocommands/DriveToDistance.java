package org.usfirst.frc.team5254.robot.autocommands;

import org.usfirst.frc.team5254.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveToDistance extends Command {

    double Throttle;
    double Turn;
    double Distance;
    
	public DriveToDistance(double Throttle, double Distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.Drivetrain);
    	this.Throttle = Throttle;
    	this.Distance = Distance;
    } 

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.Drivetrain.autoDriveInitialize(Throttle, Distance);
    	System.out.format("DriveToDistance(%f,%f)%n", this.Throttle, this.Distance);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.Drivetrain.autoDrive();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Robot.Drivetrain.driveAutoIsFinished();
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("End");
      }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}

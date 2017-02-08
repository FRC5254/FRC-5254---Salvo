package org.usfirst.frc.team5253.robot.autocommands;

import org.usfirst.frc.team5253.robot.Robot;

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
       	System.out.format("DriveToDistance(%f,%f)%n", this.Throttle, this.Distance);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.Drivetrain.resetGyro();
    	Robot.Drivetrain.getAngle();
    	Robot.Drivetrain.initEncoder();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    if (Throttle > 0) {
    	Robot.Drivetrain.autoDrive(Throttle, Robot.Drivetrain.getAngle() * Robot.Drivetrain.DKp, Distance);
    } else {
    	Robot.Drivetrain.autoDrive(-Throttle, Robot.Drivetrain.getAngle() * Robot.Drivetrain.DKp, Distance);
    }
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

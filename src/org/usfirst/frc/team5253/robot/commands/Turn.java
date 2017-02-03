package org.usfirst.frc.team5253.robot.commands;

import org.usfirst.frc.team5253.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Turn extends Command {
	

    double turnSpeed;
    double angle;

    public Turn(double turnSpeed, double angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.Drivetrain);
    	this.turnSpeed = turnSpeed;
    	this.angle = angle;
      	System.out.format("Turn(%f,%f)%n", this.turnSpeed, this.angle);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.Drivetrain.resetGyro();
    	Robot.Drivetrain.getAngle();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.Drivetrain.autoTurn(turnSpeed, angle);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Robot.Drivetrain.turnAutoIsFinished();    	
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

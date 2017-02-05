package org.usfirst.frc.team5253.robot.autocommands;

import org.usfirst.frc.team5253.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoTurn extends Command {
	

    double angle;

    public AutoTurn(double angle) {
    	requires(Robot.Drivetrain);
    	this.angle = angle;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.Drivetrain.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.Drivetrain.autoTurn(angle);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (Robot.Drivetrain.getAngle() >= angle && Robot.Drivetrain.getAngle() <= angle + 1 );
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

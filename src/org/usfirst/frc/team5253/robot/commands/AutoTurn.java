package org.usfirst.frc.team5253.robot.commands;

import org.usfirst.frc.team5253.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoTurn extends Command {
	

    double angle;

    public AutoTurn(double angle) {
    	System.out.format("Turn Init");
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.Drivetrain);
    	this.angle = angle;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.Drivetrain.resetGyro();
    	System.out.format("Turn(%f):", this.angle);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println(Robot.Drivetrain.getAngle());
		System.out.println(angle);
    	System.out.print("I'm working! excute");
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

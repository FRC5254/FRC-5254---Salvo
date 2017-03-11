package org.usfirst.frc.team5254.robot.commands;

import org.usfirst.frc.team5254.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public class ClimberStartClimbing extends Command {

	double climberSpeed;
	
    public ClimberStartClimbing(boolean direction) {
    	// accept direction of climber direction. true = forward, false = backward
       
    	requires(Robot.Climber);
    	
    	   
    	//if climb direction is forward
    	if (direction == true){
    		//set speed to full forward
    		climberSpeed = -1.0;
    	}else {
    		//set speed to full backward
    		climberSpeed = 1.0;
    	}
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.Climber.startClimber(climberSpeed);
    	
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

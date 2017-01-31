package org.usfirst.frc.team5253.robot.commands;

import org.usfirst.frc.team5253.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DropGear extends Command {

    public DropGear() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.GearHolder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.GearHolder.drop();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.GearHolder.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}

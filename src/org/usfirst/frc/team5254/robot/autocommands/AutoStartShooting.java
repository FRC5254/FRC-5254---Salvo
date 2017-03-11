package org.usfirst.frc.team5254.robot.autocommands;

import org.usfirst.frc.team5254.robot.Robot;
import org.usfirst.frc.team5254.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoStartShooting extends Command {
	
	Timer timer = new Timer();


    public AutoStartShooting() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.Shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.reset();
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.Shooter.startShooting(RobotMap.SHOOTER_RPM);
    	Robot.HypeHat.startSpinning();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get() > 20;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.Shooter.stopShooting(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}

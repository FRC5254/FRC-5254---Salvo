
package org.usfirst.frc.team5253.robot.commands;

import org.usfirst.frc.team5253.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StartSpinning extends Command {

    public StartSpinning() {
        // Use requires() here to declare subsystem dependencies
<<<<<<< HEAD:src/org/usfirst/frc/team5253/robot/commands/StartFeedingShooter.java
        // eg. requires(chassis);
    	requires(Robot.HypeHat);
=======
        requires(Robot.HypeHat);
>>>>>>> refs/remotes/origin/master:src/org/usfirst/frc/team5253/robot/commands/StartSpinning.java
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
<<<<<<< HEAD:src/org/usfirst/frc/team5253/robot/commands/StartFeedingShooter.java
    	Robot.HypeHat.startFeeding();
=======
    	Robot.HypeHat.startSpinning();
>>>>>>> refs/remotes/origin/master:src/org/usfirst/frc/team5253/robot/commands/StartSpinning.java
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

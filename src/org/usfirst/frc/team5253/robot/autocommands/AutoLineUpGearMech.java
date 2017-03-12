package org.usfirst.frc.team5253.robot.autocommands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoLineUpGearMech extends Command {

<<<<<<< HEAD:src/org/usfirst/frc/team5253/robot/autocommands/AutoLineUpGearMech.java
    public AutoLineUpGearMech() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
    }
=======
	public LineUpGearMech() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}
>>>>>>> origin/master:src/org/usfirst/frc/team5253/robot/autocommands/LineUpGearMech.java
}

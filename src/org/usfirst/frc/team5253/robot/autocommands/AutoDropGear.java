package org.usfirst.frc.team5253.robot.autocommands;

import org.usfirst.frc.team5253.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDropGear extends Command {
	Timer timer = new Timer();

<<<<<<< HEAD:src/org/usfirst/frc/team5253/robot/autocommands/AutoDropGear.java
    public AutoDropGear() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	requires(Robot.GearHolder);
      	System.out.format("DropGearAuto()%n");
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.reset();
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.GearHolder.drop();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get() >= 1.0;
    }
    
    // Called once after isFinished returns true
    protected void end() {
    	timer.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
=======
	public DropGearAuto() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);

		requires(Robot.GearHolder);
		System.out.format("DropGearAuto()%n");
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		timer.stop();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.GearHolder.drop();
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		timer.reset();
		timer.start();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return timer.get() >= 1.0;
	}
>>>>>>> origin/master:src/org/usfirst/frc/team5253/robot/autocommands/DropGearAuto.java
}

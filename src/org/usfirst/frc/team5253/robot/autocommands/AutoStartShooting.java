package org.usfirst.frc.team5253.robot.autocommands;

import org.usfirst.frc.team5253.robot.Robot;
import org.usfirst.frc.team5253.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoStartShooting extends Command {

<<<<<<< HEAD
	Timer timer = new Timer();
=======
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.Shooter.startShooting(RobotMap.SHOOTER_RPM);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get() > 6;
    }
>>>>>>> refs/remotes/origin/Shooter-PID-Tuning


	public AutoStartShooting() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.Shooter);
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.Shooter.stopShooting(0);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.Shooter.startShooting(RobotMap.SHOOTER_RPM);
		Robot.HypeHat.startSpinning();
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
		return timer.get() > 20;
	}
}

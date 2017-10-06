package org.usfirst.frc.team5254.robot.autocommands;

import org.usfirst.frc.team5254.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoStartShooting extends Command {

	Timer timer = new Timer();
	double time;

	public AutoStartShooting(double time) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		this.time = time;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		timer.reset();
		timer.start();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.Shooter.startShooting();
		Robot.HypeHat.on();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return timer.get() > time;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.Shooter.stopShooting();
		Robot.HypeHat.off();
		timer.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}

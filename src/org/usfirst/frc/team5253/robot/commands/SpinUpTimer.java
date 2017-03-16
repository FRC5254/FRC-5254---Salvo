package org.usfirst.frc.team5253.robot.commands;

import org.usfirst.frc.team5253.robot.Robot;
import org.usfirst.frc.team5253.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SpinUpTimer extends Command {

	Timer timer = new Timer();

	public SpinUpTimer() {
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
		Robot.Shooter.spinUp(RobotMap.SHOOTER_RPM);// TODO put the
													// RobotMap.SHOOTER_RPM in
													// the shooter subsysytem
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return timer.get() > .5;
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
}

package org.usfirst.frc.team5253.robot.autocommands;

import org.usfirst.frc.team5253.robot.Robot;
import org.usfirst.frc.team5253.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoSpinUp extends Command {

	Timer timer = new Timer();
	double time;

<<<<<<< HEAD
	public AutoSpinUp() {
=======
	public AutoSpinUp(double time) {
>>>>>>> refs/remotes/origin/Comp-Bot
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.Shooter);

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
		Robot.Shooter.spinUp(RobotMap.SHOOTER_RPM);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return timer.get() >= time;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		timer.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}

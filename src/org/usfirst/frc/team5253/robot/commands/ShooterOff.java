package org.usfirst.frc.team5253.robot.commands;

import org.usfirst.frc.team5253.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShooterOff extends Command {

	public ShooterOff() {
		requires(Robot.Shooter);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.Shooter.stopShooting();
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.Shooter.stopShooting();
	}

	protected void interrupted() {
		end();
	}
}

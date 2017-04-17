package org.usfirst.frc.team5253.robot.commands;

import org.usfirst.frc.team5253.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShooterOn extends Command {

	public ShooterOn() {
		requires(Robot.Shooter);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.Shooter.startShooting();
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
		end();
	}
}

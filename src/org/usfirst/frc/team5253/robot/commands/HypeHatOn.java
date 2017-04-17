package org.usfirst.frc.team5253.robot.commands;

import org.usfirst.frc.team5253.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class HypeHatOn extends Command {

	boolean HypeHatDirection;

	public HypeHatOn(boolean clockwise) {
		requires(Robot.HypeHat);

		this.HypeHatDirection = clockwise;
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.HypeHat.on(HypeHatDirection);
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

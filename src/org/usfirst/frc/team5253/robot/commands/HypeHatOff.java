package org.usfirst.frc.team5253.robot.commands;

import org.usfirst.frc.team5253.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class HypeHatOff extends Command {

	public HypeHatOff() {
		requires(Robot.HypeHat);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.HypeHat.off();
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

package org.usfirst.frc.team5253.robot.commands;

import org.usfirst.frc.team5253.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimberOn extends Command {

	boolean climberDirection;

	public ClimberOn(boolean clockwise) {
		requires(Robot.Climber);

		this.climberDirection = clockwise;
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.Climber.on(climberDirection);
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

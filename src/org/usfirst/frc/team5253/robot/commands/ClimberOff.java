package org.usfirst.frc.team5253.robot.commands;

import org.usfirst.frc.team5253.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimberOff extends Command {

	public ClimberOff() {
		requires(Robot.Climber);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.Climber.off();
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

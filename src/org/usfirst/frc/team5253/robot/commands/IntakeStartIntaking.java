package org.usfirst.frc.team5253.robot.commands;

import org.usfirst.frc.team5253.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeStartIntaking extends Command {

	double intakeSpeed;

	public IntakeStartIntaking(boolean direction) {

		requires(Robot.Intake);

		if (direction == true) {
			intakeSpeed = 1;
		} else {
			intakeSpeed = -1;
		}

	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.Intake.startIntake(intakeSpeed);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}

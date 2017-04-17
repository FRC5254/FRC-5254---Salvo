package org.usfirst.frc.team5253.robot.commands;

import org.usfirst.frc.team5253.robot.Robot;
import org.usfirst.frc.team5253.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DrivetrainSlowTurn extends Command {

	public DrivetrainSlowTurn() {
		requires(Robot.Drivetrain);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.Drivetrain.slowTurn(Robot.oi.driver.getRawAxis(RobotMap.DRIVER_THROTTLE_AXIS),
				Robot.oi.driver.getRawAxis(RobotMap.DRIVER_TURN_AXIS));
		// TODO is there an easier way to call these?
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

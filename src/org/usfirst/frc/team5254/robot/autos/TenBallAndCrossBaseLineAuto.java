package org.usfirst.frc.team5254.robot.autos;

import org.usfirst.frc.team5254.robot.Robot;
import org.usfirst.frc.team5254.robot.autocommands.*;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Works RW Ceertified
 */
public class TenBallAndCrossBaseLineAuto extends CommandGroup {

	public TenBallAndCrossBaseLineAuto() {
		requires(Robot.Drivetrain);
		requires(Robot.Shooter);
		requires(Robot.HypeHat);

		double turn = 60;
		if (DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Red) {
			turn = -turn;
		}

		addSequential(new AutoSpinUp(3));
		addSequential(new AutoStartShooting(6));
		addSequential(new AutoGyroTurn(turn));
		addSequential(new AutoTimerWait(0.5));
		addSequential(new AutoDriveToDistance(1.0, 80.0));
	}
}

package org.usfirst.frc.team5254.robot.autos;

import org.usfirst.frc.team5254.robot.Robot;
import org.usfirst.frc.team5254.robot.autocommands.*;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Works RW Ceertified
 */
public class TenBallAndCrossBaseLineAuto extends CommandGroup {

	public TenBallAndCrossBaseLineAuto() {
		Timer timer = new Timer();
		requires(Robot.Drivetrain);
		requires(Robot.Shooter);
		requires(Robot.HypeHat);

		double turn = 60;
		if (DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Red) {
			turn = -turn;
		}
		timer.reset();
		timer.start();
		addSequential(new AutoSpinUp(3, false));
		addSequential(new AutoStartShooting(6, false));
		addSequential(new AutoTurnRobot(turn));
		addSequential(new AutoSecondWait(0.5));
		addSequential(new AutoDriveToDistance(1.0, 80.0));
		System.out.println(timer.get());
	}
}

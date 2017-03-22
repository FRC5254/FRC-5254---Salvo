package org.usfirst.frc.team5253.robot.autos;

import org.usfirst.frc.team5253.robot.autocommands.*;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class OPAuto extends CommandGroup {

	public OPAuto() {
		// Add Commands here:
		// e.g. addSequential(new Command1());
		// addSequential(new Command2());
		// these will run in order.

		// To run multiple commands at the same time,
		// use addParallel()
		// e.g. addParallel(new Command1());
		// addSequential(new Command2());
		// Command1 and Command2 will run in parallel.

		// A command group will require all of the subsystems that each member
		// would require.
		// e.g. if Command1 requires chassis, and Command2 requires arm,
		// a CommandGroup containing them would require both the chassis and the
		// arm.

		// TODO this is good right? -1 was the turn we were using at the cafe
		double turn = 1;
		if (DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Red) {
			turn = -turn;
		}

		addSequential(new AutoDriveToDistance(-1.0, 128.5));// 0.6 OG
		// TODO do the thing atat makeds the thing take he abosolute value of he encuder

		addSequential(new AutoRedBullWingsExtend());
		addParallel(new AutoSpinUpThenShoot());

		addSequential(new AutoTimerTurn(turn, 0.35)); // 0.2 OG\

		addSequential(new AutoStopRobot());
	}
}

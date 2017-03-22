package org.ufirst.frc.team5253.robot.autos;

import org.usfirst.frc.team5253.robot.Robot;
import org.usfirst.frc.team5253.robot.autocommands.AutoSpinUp;
import org.usfirst.frc.team5253.robot.autocommands.AutoStartShooting;
import org.usfirst.frc.team5253.robot.autocommands.AutoTurnRobot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GearAndTenBallAuto extends CommandGroup {

	public GearAndTenBallAuto() {

		requires(Robot.Drivetrain);
		requires(Robot.Shooter);
		requires(Robot.GearMech);
		requires(Robot.HypeHat);
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

		// TODO do the driver allaince color code shit here an logic it out
		double turn = 1;
		if (DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Red) {
			turn = -turn;
		}

		addSequential(new AutoSpinUp(2));
		addSequential(new AutoStartShooting(3));
		addSequential(new AutoTurnRobot(90));
		// TODO figure out his line up mang
		// addSequential(new AutoDriveToDistance(fuck(Throttle), you(Distance));
		addSequential(new GearCenterAuto());
	}
}

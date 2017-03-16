package org.usfirst.frc.team5253.robot.autocommands;

import org.usfirst.frc.team5253.robot.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * TODO this auto is wrong
 */
public class GearAndTenBallAuto extends CommandGroup {

	public GearAndTenBallAuto() {

		requires(Robot.Drivetrain);
		requires(Robot.Shooter);
		requires(Robot.GearHolder);
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
		// TODO these values are WRONG
		addSequential(new GearCenterAuto());
		addSequential(new AutoTurnRobot(90));
		addSequential(new AutoSpinUp(1));
		addSequential(new AutoStartShooting(20));
	}
}

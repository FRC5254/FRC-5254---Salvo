package org.usfirst.frc.team5253.robot.autocommands;

import org.usfirst.frc.team5253.robot.Robot;
<<<<<<< HEAD:src/org/usfirst/frc/team5253/robot/autocommands/GearTenBallAndCrossAuto.java

=======
>>>>>>> refs/remotes/origin/Comp-Bot:src/org/usfirst/frc/team5253/robot/autocommands/GearAndTenBallAuto.java
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * TODO this auto is wrong
 */
public class GearAndTenBallAuto extends CommandGroup {

	public GearAndTenBallAuto() {

		requires(Robot.Drivetrain);
<<<<<<< HEAD:src/org/usfirst/frc/team5253/robot/autocommands/GearTenBallAndCrossAuto.java
		requires(Robot.GearMech);
=======
		requires(Robot.Shooter);
		requires(Robot.GearHolder);
>>>>>>> refs/remotes/origin/Comp-Bot:src/org/usfirst/frc/team5253/robot/autocommands/GearAndTenBallAuto.java
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
<<<<<<< HEAD:src/org/usfirst/frc/team5253/robot/autocommands/GearTenBallAndCrossAuto.java
		addSequential(new AutoDriveToDistance(-1.0, 54));
		addSequential(new AutoDropGear());
		addParallel(new AutoDriveToDistance(1.0, 54));
=======
		// TODO these values are WRONG
		addSequential(new GearCenterAuto());
>>>>>>> refs/remotes/origin/Comp-Bot:src/org/usfirst/frc/team5253/robot/autocommands/GearAndTenBallAuto.java
		addSequential(new AutoTurnRobot(90));
		addSequential(new AutoSpinUp(1));
		addSequential(new AutoStartShooting(20));
	}
}

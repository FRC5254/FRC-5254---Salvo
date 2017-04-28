package org.usfirst.frc.team5253.robot.autos;

import org.usfirst.frc.team5253.robot.Robot;
import org.usfirst.frc.team5253.robot.autocommands.AutoDriveToDistance;
import org.usfirst.frc.team5253.robot.autocommands.AutoDropGear;
import org.usfirst.frc.team5253.robot.autocommands.AutoSecondWait;
import org.usfirst.frc.team5253.robot.autocommands.AutoSpinUp;
import org.usfirst.frc.team5253.robot.autocommands.AutoStartShooting;
import org.usfirst.frc.team5253.robot.autocommands.AutoTurnRobot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TenBallAndGearAuto extends CommandGroup {

	public TenBallAndGearAuto() {

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
		double turn1 = 59;
		if (DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Red) {
			turn1 = -turn1;
		}
		double turn2 = 90;
		if (DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Red) {
			turn2 = -turn2;
		}
		
		addSequential(new AutoSpinUp(3, false));
		addSequential(new AutoStartShooting(2, false));
		addSequential(new AutoTurnRobot(turn1));
		addSequential(new AutoSecondWait(0.25));
		addSequential(new AutoDriveToDistance(1.0, 82.5));
		addSequential(new AutoTurnRobot(turn2));
		addSequential(new AutoSecondWait(0.25));
		addSequential(new AutoDriveToDistance(1.0, 46.0));
		addSequential(new AutoDropGear());
		addSequential(new AutoDriveToDistance(-1.0, 34.5));
	}
}

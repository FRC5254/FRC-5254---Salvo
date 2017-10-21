package org.usfirst.frc.team5254.robot.autos;

import org.usfirst.frc.team5254.robot.Robot;
import org.usfirst.frc.team5254.robot.autocommands.AutoDriveToDistance;
import org.usfirst.frc.team5254.robot.autocommands.AutoDropGear;
import org.usfirst.frc.team5254.robot.autocommands.AutoGyroTurn;
import org.usfirst.frc.team5254.robot.autocommands.AutoSpinUp;
import org.usfirst.frc.team5254.robot.autocommands.AutoStartShooting;
import org.usfirst.frc.team5254.robot.autocommands.AutoTimerWait;

import edu.wpi.first.wpilibj.DriverStation;
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

		double turn1 = 59;
		if (DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Red) {
			turn1 = -turn1;
		}
		double turn2 = 90;
		if (DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Red) {
			turn2 = -turn2;
		}
		
		double turn3 = -60;
		if (DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Red) {
			turn3 = -turn3;
		}
		double turn4 = 45;
		if (DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Red){
			turn4 = -turn4;
		}
		
		//to shoot and place the gear
		addSequential(new AutoSpinUp(3));
		addSequential(new AutoStartShooting(2));
		addSequential(new AutoGyroTurn(turn1));
		addSequential(new AutoTimerWait(0.25));
		addSequential(new AutoDriveToDistance(1.0, 82.5));
		addSequential(new AutoGyroTurn(turn2));
		addSequential(new AutoTimerWait(0.25));
		addSequential(new AutoDriveToDistance(1.0, 46.0));
		addSequential(new AutoDropGear());
		addSequential(new AutoDriveToDistance(-1.0, 34.5));
		
		//to cross the field after placing the gear
		addSequential(new AutoGyroTurn(turn3));
		addSequential(new AutoDriveToDistance(1.0, 150.0));
		addSequential(new AutoGyroTurn(turn4));
		addSequential(new AutoDriveToDistance(1.0, 254.0));
		
	}
}

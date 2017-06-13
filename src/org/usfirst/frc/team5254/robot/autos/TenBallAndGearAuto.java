package org.usfirst.frc.team5254.robot.autos;

import org.usfirst.frc.team5254.robot.Robot;
import org.usfirst.frc.team5254.robot.autocommands.AutoDriveToDistance;
import org.usfirst.frc.team5254.robot.autocommands.AutoDropGear;
import org.usfirst.frc.team5254.robot.autocommands.AutoSecondWait;
import org.usfirst.frc.team5254.robot.autocommands.AutoSpinUp;
import org.usfirst.frc.team5254.robot.autocommands.AutoStartShooting;
import org.usfirst.frc.team5254.robot.autocommands.AutoTurnRobot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TenBallAndGearAuto extends CommandGroup {

	public TenBallAndGearAuto() {
		Timer timer = new Timer();
		requires(Robot.Drivetrain);
		requires(Robot.Shooter);
		requires(Robot.GearMech);
		requires(Robot.HypeHat);
		
		double turn1 = 59;
		if (DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Red) {
			turn1 = -turn1;
		}
		double turn2 = 90;
		if (DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Red) {
			turn2 = -turn2;
		}
		
		timer.reset();
		timer.start();
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
		System.out.println(timer.get());
	}
}

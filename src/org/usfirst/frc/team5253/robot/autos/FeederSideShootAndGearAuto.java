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
public class FeederSideShootAndGearAuto extends CommandGroup {

    public FeederSideShootAndGearAuto() {
        Timer timer = new Timer();
    	requires(Robot.Drivetrain);
		requires(Robot.Shooter);
		requires(Robot.GearMech);
		requires(Robot.HypeHat);

		double turn1 = -60;
		if (DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Red) {
			turn1 = -(turn1);
		}
		double turn2 = 90;
		if (DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Red) {
			turn2 = -(turn2);
		}
		
		timer.reset();
		timer.start();
		addSequential(new AutoSpinUp(1.5, true));
		addSequential(new AutoStartShooting(2, true));
		addSequential(new AutoTurnRobot(turn1));
		addSequential(new AutoSecondWait(0.25));
		addSequential(new AutoDriveToDistance(-1.0, 84));
		addSequential(new AutoTurnRobot(turn2));
		addSequential(new AutoSecondWait(0.25));
		addSequential(new AutoDriveToDistance(1.0, 19.0));
		addSequential(new AutoDropGear());
		addSequential(new AutoDriveToDistance(-1.0, 21));
		System.out.println(timer.get());
    }
}

package org.usfirst.frc.team5254.robot.autos;

import org.usfirst.frc.team5254.robot.Robot;
import org.usfirst.frc.team5254.robot.autocommands.AutoDriveToDistance;
import org.usfirst.frc.team5254.robot.autocommands.AutoDropGear;
import org.usfirst.frc.team5254.robot.autocommands.AutoPrintTimer;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class GearCenterAuto extends CommandGroup {

	public GearCenterAuto() {

		requires(Robot.Drivetrain);
		requires(Robot.GearMech);
		addSequential(new AutoDriveToDistance(1.0, 67));// throttle .75
		addSequential(new AutoDropGear());
		addSequential(new AutoDriveToDistance(-0.75, 34.5));
		addSequential(new AutoPrintTimer());

	}
}

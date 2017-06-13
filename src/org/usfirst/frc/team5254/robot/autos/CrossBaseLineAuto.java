package org.usfirst.frc.team5254.robot.autos;

import org.usfirst.frc.team5254.robot.Robot;
import org.usfirst.frc.team5254.robot.autocommands.AutoDriveToDistance;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CrossBaseLineAuto extends CommandGroup {

	public CrossBaseLineAuto() {

		System.out.format("Crossbaseline");
		requires(Robot.Drivetrain);
		
		addSequential(new AutoDriveToDistance(1.0, 100));

	}
}

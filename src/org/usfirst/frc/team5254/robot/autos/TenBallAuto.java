package org.usfirst.frc.team5254.robot.autos;

import org.usfirst.frc.team5254.robot.Robot;
import org.usfirst.frc.team5254.robot.autocommands.AutoSpinUp;
import org.usfirst.frc.team5254.robot.autocommands.AutoStartShooting;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * RW Certified
 */
public class TenBallAuto extends CommandGroup {

	public TenBallAuto() {

		requires(Robot.Drivetrain);
		requires(Robot.Shooter);
		requires(Robot.HypeHat);

		addSequential(new AutoSpinUp(3, false));
		addSequential(new AutoStartShooting(10, false));
	}
}

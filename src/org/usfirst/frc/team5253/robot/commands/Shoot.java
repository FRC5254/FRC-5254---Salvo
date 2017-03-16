package org.usfirst.frc.team5253.robot.commands;

import org.usfirst.frc.team5253.robot.autocommands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Shoot extends CommandGroup {

	public Shoot() {
		// TODO get this to work? does it?
		addSequential(new AutoSpinUp(5));
		addSequential(new ShooterStartShooting());

	}
}

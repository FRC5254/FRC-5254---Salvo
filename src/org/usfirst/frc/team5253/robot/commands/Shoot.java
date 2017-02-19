package org.usfirst.frc.team5253.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Shoot extends CommandGroup {

    public Shoot() {
        addSequential(new GetToSpeed());
        addSequential(new StartShooting());
    }
}

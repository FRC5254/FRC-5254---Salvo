package org.usfirst.frc.team5253.robot.commands;

import org.usfirst.frc.team5253.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GetToSpeed extends Command {

    public GetToSpeed() {
    	requires(Robot.Shooter);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return Robot.Shooter.shooterUpToSpeed();
    }
}

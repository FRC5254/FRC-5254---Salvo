package org.usfirst.frc.team5253.robot.autocommands;

import org.usfirst.frc.team5253.robot.Robot;
import org.usfirst.frc.team5253.robot.commands.DropGear;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GearTenBallAndCrossAuto extends CommandGroup {

    public GearTenBallAndCrossAuto() {
    	
    	requires(Robot.Drivetrain);
    	requires(Robot.GearHolder);
    	requires(Robot.HypeHat);
    	requires(Robot.Shooter);
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential(new DriveToDistance(1.0, 16));
    	addSequential(new DropGear());
    	addParallel(new DriveToDistance(-1.0, 16));
    	addSequential(new AutoTurn(90));
    	addSequential(new AutoSpinUp());
    	addSequential(new AutoStartShooting());
    	addSequential(new AutoTurn(-45));
    	addSequential(new DriveToDistance(1.0, 84));
    }
}

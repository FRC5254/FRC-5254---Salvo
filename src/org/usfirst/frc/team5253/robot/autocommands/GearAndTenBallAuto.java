package org.usfirst.frc.team5253.robot.autocommands;

import org.usfirst.frc.team5253.robot.Robot;
import org.usfirst.frc.team5253.robot.commands.DropGear;
import org.usfirst.frc.team5253.robot.commands.StartShooting;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GearAndTenBallAuto extends CommandGroup {

    public GearAndTenBallAuto() {
    	
    	requires(Robot.Drivetrain);
    	requires(Robot.Shooter);
    	requires(Robot.GearHolder);
    	requires(Robot.HypeHat);
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
    	
//    	addSequential(new DriveToDistance(1.0, 54));
//    	addSequential(new DropGear());
//    	addParallel(new DriveToDistance(1.0, 54));
    	addSequential(new GearCenterAuto());
    	addSequential(new TurnRobot(90));
    	addSequential(new AutoSpinUp());
    	addSequential(new StartShooting());
    }
}

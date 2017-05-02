package org.usfirst.frc.team5253.robot.autos;

import org.usfirst.frc.team5253.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TestAuto extends CommandGroup {

    public TestAuto() {
    	requires(Robot.Drivetrain);
    	requires(Robot.Shooter);
    	requires(Robot.HypeHat);
    	requires(Robot.GearMech);
    	requires(Robot.FuelTank);//just in case
    	requires(Robot.Climber);//you never know...
    	
    	 Timer timer = new Timer();
    	 
    	 timer.reset();
    	 timer.start();
    	 
    	 //auto goes here
    	 
    	 System.out.println(timer.get());
    	
    }
}

package org.usfirst.frc.team5253.robot.autocommands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
<<<<<<< HEAD:src/org/usfirst/frc/team5253/robot/autocommands/AutoLineUpBoilerShot.java
public class AutoLineUpBoilerShot extends Command {
	
=======
public class LineUpBoilerShot extends Command {

>>>>>>> origin/master:src/org/usfirst/frc/team5253/robot/autocommands/LineUpBoilerShot.java
	double BoilerDistance = SmartDashboard.getDouble("Boiler Distance");
	double BoilerX = SmartDashboard.getDouble("Boiler Vision X");
	double BoilerY = SmartDashboard.getDouble("Boiler Vision Y");
	double ScaledBoilerX = SmartDashboard.getDouble("Scaled Boiler Vision X");
<<<<<<< HEAD:src/org/usfirst/frc/team5253/robot/autocommands/AutoLineUpBoilerShot.java
	
    public AutoLineUpBoilerShot() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	if (BoilerDistance < 15) { 
//    		Robot.Drivetrain.autoDriveInitialize(.125, 2);
//    		Robot.Drivetrain.autoDrive();
//    	} else if {
//    		
//    } else {
//    	//Do Nothing
//    	//end(); 
//    }
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
=======

	public LineUpBoilerShot() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		// if (BoilerDistance < 15) {
		// Robot.Drivetrain.autoDriveInitialize(.125, 2);
		// Robot.Drivetrain.autoDrive();
		// } else if {
		//
		// } else {
		// //Do Nothing
		// //end();
		// }

	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}
>>>>>>> origin/master:src/org/usfirst/frc/team5253/robot/autocommands/LineUpBoilerShot.java
}

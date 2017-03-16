 
package org.usfirst.frc.team5253.robot;


import org.ufirst.frc.team5253.robot.autos.*;
import org.usfirst.frc.team5253.robot.autocommands.*;
import org.usfirst.frc.team5253.robot.subsystems.*;


import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.CANTalon;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;

	public static Drivetrain Drivetrain = new Drivetrain();
	public static GearHolder GearHolder = new GearHolder();
	public static HypeHat HypeHat = new HypeHat();
	public static Shooter Shooter = new Shooter();
	public static Intake Intake = new Intake();

	public static FuelTank FuelTank = new FuelTank();
	public static Climber Climber = new Climber();
	CANTalon shooterMotorTopLeft = new CANTalon(RobotMap.SHOOTER_MOTOR_TOP_LEFT);
	NetworkTable table;

	// Auto modes
	private final String NothingAuto = "Nothing";
	private final String CrossBaseLine = "Cross Base Line";
	private final String AutoCenterGear = "Center Gear";
	private final String AutoRightGear = "Right Gear";
	private final String AutoLeftGear = "Left Gear";
	private final String TenBall = "Shoot Ten Balls";
	private final String GearTenBall = "Center Gear and Ten Ball Shot";
	private final String OPRedAlliance = "Auto Bots Assemble (Red Alliance)";
	private final String OPBlueAlliance = "Auto Botsd Assemble (Blue Alliance)";



	private final String[] AutoModes = {

			NothingAuto, CrossBaseLine, AutoCenterGear, AutoRightGear, AutoLeftGear, TenBall, GearTenBall, OPRedAlliance,
			OPBlueAlliance

	};

	Command autonomousCommand;

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	
	public void autonomousInit() {

		String autoSelected = SmartDashboard.getString("Auto Selector", NothingAuto);


		switch (autoSelected) {
		/*
		 * TenBall, GearBaseLine, GearTenBall, GearTenBallAndCross, OP
		 */

		case CrossBaseLine:
			autonomousCommand = new CrossBaseLineAuto();
			break;

		case AutoCenterGear:
			autonomousCommand = new GearCenterAuto();
			break;

		case AutoRightGear:
			autonomousCommand = new SideGearAuto(false);
			break;

		case AutoLeftGear:
			autonomousCommand = new SideGearAuto(true);
			break;

		case TenBall:
			autonomousCommand = new TenBallAuto();
			break;

		case GearTenBall:
			autonomousCommand = new GearAndTenBallAuto();
			break;

		case OPRedAlliance:
			autonomousCommand = new OPAuto(true);
			break;

		case OPBlueAlliance: 
		autonomousCommand = new OPAuto(false);
			
		default:
			break;
		}


		// schedule the autonomous command (example)
		if (autonomousCommand != null) {
			SmartDashboard.putString("DB/String 0", autoSelected);
			autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous
	 */
	
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	
	public void disabledInit() {

	}

	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	
	public void robotInit() {
		oi = new OI();

		// Send auto modes
		NetworkTable table = NetworkTable.getTable("SmartDashboard");
		table.putStringArray("Auto List", AutoModes);

		// Initialize cameras
		CameraServer.getInstance().startAutomaticCapture(0);
		// CameraServer.getInstance().startAutomaticCapture(1);
		// SmartDashboard.putNumber("Shooter RPM",
		// shooterMotorTopLeft.getSpeed());
	}

	
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		SmartDashboard.putNumber("Shooter RPM", shooterMotorTopLeft.getSpeed());
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		// if the right trigger is pressed down use slowturn
	}

	/**
	 * This function is called periodically during test mode
	 */
	
	public void testPeriodic() {
		LiveWindow.run();
	}
}

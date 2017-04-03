
package org.usfirst.frc.team5254.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5254.robot.autos.*;
import org.usfirst.frc.team5254.robot.subsystems.*;

import com.ctre.CANTalon;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	CANTalon shooterMotorTopLeft = new CANTalon(RobotMap.SHOOTER_MOTOR_TOP_LEFT);

	NetworkTable table;
	public static OI oi;
	public static Drivetrain Drivetrain = new Drivetrain();
	public static GearMech GearMech = new GearMech();
	public static HypeHat HypeHat = new HypeHat();
	public static Shooter Shooter = new Shooter();
	public static Climber Climber = new Climber();

	// Auto modes
	private final String NothingAuto = "Nothing";
	private final String CrossBaseLine = "Cross Base Line";
	private final String AutoCenterGear = "Center Gear";
	private final String TenBall = "Shoot Ten Balls";
	private final String TenBallGear = "Ten Ball Shot and Center Gear";
	private final String TenBallAndCross = "Ten Ball and Cross Base Line";

	private final String[] AutoModes = {

			NothingAuto, 
			CrossBaseLine, 
			AutoCenterGear, 
			TenBallAndCross, 
			TenBall,
			TenBallGear,

	};

	Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();

		// Send auto modes
		NetworkTable table = NetworkTable.getTable("SmartDashboard");
		table.putStringArray("Auto List", AutoModes);

		// Initialize cameras
		CameraServer.getInstance().startAutomaticCapture(1);
		CameraServer.getInstance().startAutomaticCapture(0);

	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

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

	@Override
	public void autonomousInit() {
		String autoSelected = SmartDashboard.getString("Auto Selector", NothingAuto);

		System.out.format("Auto: %s '%s'%n", m_ds.getAlliance(), autoSelected);

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


		case TenBall:
			autonomousCommand = new TenBallAuto();
			break;

		case TenBallGear:
			autonomousCommand = new TenBallAndGearAuto();
			break;


		case TenBallAndCross:
			autonomousCommand = new TenBallAndCrossBaseLineAuto();
			break;

		default:
			autonomousCommand = new NothingAuto();
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
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
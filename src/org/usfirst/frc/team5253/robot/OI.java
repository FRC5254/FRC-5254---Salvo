package org.usfirst.frc.team5253.robot;

import org.usfirst.frc.team5253.robot.commands.*;
import org.usfirst.frc.team5253.robot.autocommands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/** 
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
	
public class OI {
	
	public Joystick driver = new Joystick(RobotMap.DRIVER_JOYSTICK);
	public Joystick operator = new Joystick(RobotMap.OPERATOR_JOYSTICK);
	
	public OI() {
		
		Button DriverButtonA = new JoystickButton(driver, 1);
		Button DriverButtonB = new JoystickButton(driver, 2);
		Button DriverButtonX = new JoystickButton(driver, 3);
		Button DriverButtonY = new JoystickButton(driver, 4);
		Button DriverButtonBumperLeft = new JoystickButton(driver, 5);
		Button DriverButtonBumperRight = new JoystickButton(driver, 6);
		Button DriverButtonBack = new JoystickButton(driver, 7);
		Button DriverButtonStart = new JoystickButton(driver, 8);
		Button DriverButtonLeftJoystickPress = new JoystickButton(driver, 9);
		Button DriverButtonRightJoystickPress = new JoystickButton(driver, 10);
		
		
		Button OperatorButtonA = new JoystickButton(operator, 1);
		Button OperatorButtonB = new JoystickButton(operator, 2);
		Button OperatorButtonX = new JoystickButton(operator, 3);
		Button OperatorButtonY = new JoystickButton(operator, 4);
		Button OperatorButtonBumperLeft = new JoystickButton(operator, 5);
		Button OperatorButtonBumperRight = new JoystickButton(operator, 6);
		Button OperatorButtonBack = new JoystickButton(operator, 7);
		Button OperatorButtonStart = new JoystickButton(operator, 8);
		Button OperatorButtonLeftJoystickPress = new JoystickButton(operator, 9);
		Button OperatorButtonRightJoystickPress = new JoystickButton(operator, 10);

	
		DriverButtonA.whenPressed(new StartFeedingShooter());
		DriverButtonA.whenPressed(new StartShooting());
		DriverButtonB.whenPressed(new StopFeedingShooter());
		DriverButtonB.whenPressed(new StopShooting());
		DriverButtonX.whenPressed(new SpinUp());
		DriverButtonY.whenPressed(new StartFeedingShooter());
		//DriverButtonBumperLeft.whenPressed(command);
		//DriverButtonBumperRight.whenPressed(command);
		DriverButtonBack.whenActive(new ShiftUp());
		//DriverButtonStart.whenPressed(command);
		//DriverButtonLeftJoystickPress.whenPressed(command);
		//DriverButtonRightJoystickPress.whenPressed(command);
		
		
		OperatorButtonA.whenPressed(new StartIntaking());
		OperatorButtonB.whenPressed(new StopIntaking());
		OperatorButtonX.whenPressed(new RedBullWingsExtend());
		OperatorButtonY.whileHeld(new DropGear());
		OperatorButtonBack.whenPressed(new RedBullWingsRetract());
		//OperatorButtonStart.whenPressed(command);
		OperatorButtonBumperLeft.whenPressed(new GearIntakeOut());
		OperatorButtonBumperRight.whenPressed(new GearIntakeIn());
		//OperatorButtonLeftJoystickPress.whenPressed(command);
		//OperatorButtonRightJoystickPress.whenPressed(command);
	}
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);
	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

}

package org.usfirst.frc.team5253.robot;

import org.usfirst.frc.team5253.robot.commands.DropGear;
import org.usfirst.frc.team5253.robot.commands.FeedShooter;
import org.usfirst.frc.team5253.robot.commands.StopFeedingShooter;
import org.usfirst.frc.team5253.robot.commands.StartShooting;
import org.usfirst.frc.team5253.robot.commands.StopShooting;
import org.usfirst.frc.team5253.robot.commands.StartIntaking;
import org.usfirst.frc.team5253.robot.commands.StopIntaking;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/** 
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public Joystick driver = new Joystick(RobotMap.DRIVER_JOYSTICK);
	public Joystick operator = new Joystick(RobotMap.OPERATOR_JOYSTICK);
	
	public OI() {
		
		Button OperatorButtonA = new JoystickButton(operator, 1);
		Button OperatorButtonY = new JoystickButton(operator, 3);
		Button OperatorButtonB = new JoystickButton(operator, 2);
		Button DriverButtonA = new JoystickButton(driver, 1);
		Button DriverButtonB = new JoystickButton(driver, 2);
		
		
		OperatorButtonY.whenPressed(new DropGear());
		DriverButtonA.whenPressed(new FeedShooter());
		DriverButtonA.whenPressed(new StartShooting());
		DriverButtonB.whenPressed(new StopFeedingShooter());
		DriverButtonB.whenPressed(new StopShooting());
		OperatorButtonA.whenPressed(new StartIntaking());
		OperatorButtonB.whenPressed(new StopIntaking());
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

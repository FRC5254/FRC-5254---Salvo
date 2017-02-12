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

	
		DriverButtonA.whenPressed(new StartSpinning());
		DriverButtonA.whenPressed(new StartShooting());
		DriverButtonB.whenPressed(new StopSpinning());
		DriverButtonB.whenPressed(new StopShooting());
		DriverButtonX.whenPressed(new SpinUp());
		DriverButtonY.whenPressed(new StartSpinning());
		DriverButtonBumperLeft.whenPressed(new ShiftUp());
		DriverButtonBumperLeft.whenInactive(new ShiftDown());
		DriverButtonBumperRight.whenPressed(new ShiftUp());
		DriverButtonBumperRight.whenInactive(new ShiftDown());
		//DriverButtonBack.whenActive(new ShiftUp());
		//DriverButtonBack.whenInactive(new ShiftDown());
		//DriverButtonStart.whenPressed(command);
		//DriverButtonLeftJoystickPress.whenPressed(command);
		//DriverButtonRightJoystickPress.whenPressed(command);
		
		
		OperatorButtonA.whenPressed(new StartIntaking());
		OperatorButtonB.whenPressed(new StopIntaking());
		//OperatorButtonX.whenPressed();
		OperatorButtonY.whenActive(new DropGear());
		OperatorButtonY.whenInactive(new RaiseGear());
		OperatorButtonBack.whenPressed(new GearIntakeIn());
		OperatorButtonStart.whenPressed(new GearIntakeOut());
		OperatorButtonBumperLeft.whenPressed(new RedBullWingsRetract());
		OperatorButtonBumperRight.whenPressed(new RedBullWingsExtend());
		//OperatorButtonLeftJoystickPress.whenPressed(command);
		//OperatorButtonRightJoystickPress.whenPressed(command);
	}

}
  
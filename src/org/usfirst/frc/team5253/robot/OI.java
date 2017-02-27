package org.usfirst.frc.team5253.robot;

import org.usfirst.frc.team5253.robot.commands.*;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 *	In this class the driver joystick and operator joystick are created and defined.
 * The buttons on the joysticks are assigned a command. The OI class is called in the
 * Robot.java class.
 */
	
public class OI {
	
	public XboxController driver = new XboxController(RobotMap.DRIVER_JOYSTICK);
	public XboxController operator = new XboxController(RobotMap.OPERATOR_JOYSTICK);
	
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

	
		DriverButtonA.whenPressed(new StartShooting());
		DriverButtonA.whenPressed(new StartSpinning());
		DriverButtonB.whenPressed(new StopShooting());
		DriverButtonB.whenPressed(new StopSpinning());
		DriverButtonX.whenPressed(new SpinUp());
		DriverButtonY.whenPressed(new StartSpinning());
		DriverButtonBumperLeft.whenPressed(new ShiftUp());
		DriverButtonBumperLeft.whenInactive(new ShiftDown());
		DriverButtonBumperRight.whenPressed(new ShiftUp());
		DriverButtonBumperRight.whenInactive(new ShiftDown());
		DriverButtonBack.whenActive(new SlowTrun());
		DriverButtonBack.whenInactive(new DriveWithJoystick());
		//DriverButtonStart.whenPressed(command);
		//DriverButtonLeftJoystickPress.whenPressed(command);
		//DriverButtonRightJoystickPress.whenPressed(command);
		
		OperatorButtonA.whenPressed(new StartIntaking());
		OperatorButtonB.whenPressed(new StopIntaking());
		OperatorButtonB.whenPressed(new StopClimbing());
		OperatorButtonX.whenPressed(new StartClimbing());
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

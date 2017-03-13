package org.usfirst.frc.team5253.robot;

import org.usfirst.frc.team5253.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {
	
	// defining the controllers for the driver and operator
	public Joystick driver = new Joystick(RobotMap.DRIVER_JOYSTICK);
	public XboxController operator = new XboxController(RobotMap.OPERATOR_JOYSTICK);

	public OI() {
		
		
		//defining driver buttons
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
		
		//defining operator buttons
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

		DriverButtonA.whenPressed(new ShooterStartShooting());
		DriverButtonA.whenPressed(new HypeHatStartSpinning());
		DriverButtonB.whenPressed(new ShooterStopShooting());
		DriverButtonB.whenPressed(new HypeHatStopSpinning());
		DriverButtonX.whenPressed(new ShooterSpinUp());
		DriverButtonY.whenPressed(new HypeHatStartSpinning());
		DriverButtonBumperLeft.whenPressed(new DrivetrainShiftUp());
		DriverButtonBumperLeft.whenInactive(new DrivetrainShiftDown());
		DriverButtonBumperRight.whenPressed(new DrivetrainShiftUp());
		DriverButtonBumperRight.whenInactive(new DrivetrainShiftDown());
		DriverButtonStart.whenPressed(new ShooterResetPIDData());

		
		
		
		/*
		 * set operator buttons to activate commands
		 * A = start intaking balls
		 * X = start climber (forwards)
		 * Start = lowers gear mech and intakes to collect gear
		 * Back = outtakes and lowers to place gear
		 * Right Bumper = extend wings
		 * Left Bumper = retract wings
		 * Y = raises the gear mech
		 * B = stop intaking balls & stop climbing & stop gear motor
		 */
		OperatorButtonA.whenPressed(new IntakeStartIntaking(true));
		OperatorButtonB.whenPressed(new IntakeStopIntaking());
		OperatorButtonB.whenPressed(new ClimberStopClimbing());
		OperatorButtonB.whenPressed(new GearMechMotorOff());
		OperatorButtonX.whenPressed(new ClimberStartClimbing(true));
		OperatorButtonY.whenActive(new GearHolderDropGear());
		OperatorButtonY.whenInactive(new GearHolderRaiseGear());
		OperatorButtonStart.whenPressed(new GearHolderIntakeOut());
		OperatorButtonBack.whenPressed(new GearHolderIntakeIn());
		OperatorButtonBumperLeft.whenPressed(new RedBullWingsRetract());
		OperatorButtonBumperRight.whenPressed(new RedBullWingsExtend());
		// OperatorButtonLeftJoystickPress.whenPressed(command);
		// OperatorButtonRightJoystickPress.whenPressed(command);
	}

}
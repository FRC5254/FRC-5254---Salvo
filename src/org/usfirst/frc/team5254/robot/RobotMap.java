
package org.usfirst.frc.team5254.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;

	// Solenoids
	public static final int SHIFTING_PISTON = 0;
	public static final int GEAR_PICK_UP_PISTON_EXTEND = 2;
	public static final int GEAR_PICK_UP_PISTON_RETRACT = 3;
	// TODO remove the GearHolder code
	// public static final int GEAR_HOLDER_PISTON_EXTEND = 2;
	// public static final int GEAR_HOLDER_PISTON_RETRACT = 3;
	public static final int RED_BULL_WINGS_PISTION_EXTEND = 4;
	public static final int RED_BULL_WINGS_PISTION_RETRACT = 5;
	public static final int GEAR_INTAKE_PISTION = 6;

	// Sensors
	public static final int DRIVE_ENCODER_LEFT1 = 0;
	public static final int DRIVE_ENCODER_RIGHT1 = 2;
	public static final int DRIVE_ENCODER_LEFT2 = 1;
	public static final int DRIVE_ENCODER_RIGHT2 = 3;

	// Joysticks
	public static final int DRIVER_JOYSTICK = 0;
	public static final int OPERATOR_JOYSTICK = 1;
	public static final int DRIVER_THROTTLE_AXIS = 1;
	public static final int DRIVER_TURN_AXIS = 4;

	// Gyro
	public static final int GYRO = 1;

	// PDP
	public static final int DRIVE_MOTOR_LEFT1 = 0;
	public static final int DRIVE_MOTOR_LEFT2 = 1;
	public static final int DRIVE_MOTOR_RIGHT1 = 2;// 14
	public static final int DRIVE_MOTOR_RIGHT2 = 3;// 15

	// CAN Talons
	public static final int SHOOTER_MOTOR_TOP_LEFT = 6;
	public static final int SHOOTER_MOTOR_TOP_RIGHT = 7;
	public static final int SHOOTER_MOTOR_BOTTOM = 4;// TODO was 8
	public static final int HYPE_HAT_MOTOR = 3;// 9
	public static final int INTAKE_MOTOR = 5;// 10
	public static final int CLIMBER_MOTOR = 1;
	public static final int GEAR_MECH_MOTOR = 12;

	// Shooter tuning values
	public static final double SHOOTER_RPM = 3325;// RPM is the RPM of the
													// encoder, not the motors
													// (old 3500)
	public static final double SHOOTER_PID_F = 0.0267;
	public static final double SHOOTER_PID_P = 0.04;
	public static final double SHOOTER_PID_I = 0.0;
	public static final double SHOOTER_PID_D = 0.4;

	// Misc
	public static final int WHEEL_DIAMETER = 4;
	public static final int WHEEL_TICKS = 256;
	public static final double GEAR_RATIO = 25.0 / 6.0;
}

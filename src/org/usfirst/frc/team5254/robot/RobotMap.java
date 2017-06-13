
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
	public static final int GEAR_MECH_PISTON_EXTEND = 2;
	public static final int GEAR_MECH_PISTON_RETRACT = 3;
	public static final int RED_BULL_WINGS_PISTION_EXTEND = 4;
	public static final int RED_BULL_WINGS_PISTION_RETRACT = 5;
	public static final int GEAR_FLAP_PISTION = 6;

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

	// CAN Talons
	public static final int SHOOTER_MOTOR_TOP_LEFT = 6;
	public static final int SHOOTER_MOTOR_TOP_RIGHT = 7;
	public static final int SHOOTER_MOTOR_BOTTOM = 4;
	public static final int HYPE_HAT_MOTOR = 9;
	public static final int CLIMBER_MOTOR = 1;
	public static final int CLIMBER_MOTOR_2 = 12;
	public static final int GEAR_MECH_MOTOR = 2;

	// Shooter tuning values
	public static final double SHOOTER_RPM_SHORT = 3250; //TODO get these tuned to the new weights
	public static final double SHOOTER_PID_F_SHORT = 0.0267;
	public static final double SHOOTER_PID_P_SHORT = 0.04;
	public static final double SHOOTER_PID_I_SHORT = 0.0;
	public static final double SHOOTER_PID_D_SHORT = 0.4;
	
	public static final double SHOOTER_RPM_LONG = 4150;// OLD 4100
	public static final double SHOOTER_PID_F_LONG = 0.0245;
	public static final double SHOOTER_PID_P_LONG = 0.09;
	public static final double SHOOTER_PID_I_LONG = 0.0;
	public static final double SHOOTER_PID_D_LONG = 5.0;

	// Drivetrain
	public static final int WHEEL_DIAMETER = 4;
	public static final int ENCODER_TICKS = 256;
	public static final double GEAR_RATIO = ((25.0 / 6.0) * (100.0 / 91.0));
	public static final double Kp = .3;
	public static final double  TURN_P = .02;
	public static final double  TURN_I = .002;
	public static final double  TURN_D = .2;
	
	
}
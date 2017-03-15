package org.usfirst.frc.team5253.robot.subsystems;

import org.usfirst.frc.team5253.robot.RobotMap;
import org.usfirst.frc.team5253.robot.commands.IntakeStopIntaking;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {

<<<<<<< HEAD
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private CANTalon intakeMotor = new CANTalon(RobotMap.INTAKE_MOTOR);

=======
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	CANTalon intakeMotor = new CANTalon(RobotMap.INTAKE_MOTOR);
	
>>>>>>> refs/heads/Comp-Bot
	public Intake() {
		intakeMotor.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		intakeMotor.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		intakeMotor.configNominalOutputVoltage(+0.0f, -0.0f);
		intakeMotor.configPeakOutputVoltage(0.0f, -12.0f);
		intakeMotor.reverseSensor(false);
		intakeMotor.reverseOutput(true);
	}

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new IntakeStopIntaking());
	}

	public void startIntake(double Percent) {
		intakeMotor.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		intakeMotor.configPeakOutputVoltage(0.0f, -12.0f);
		intakeMotor.set(Percent);
	}

	public void stopIntake() {
		intakeMotor.set(0);
	}

}


package org.usfirst.frc.team5253.robot.subsystems;

import org.usfirst.frc.team5253.robot.RobotMap;
import org.usfirst.frc.team5253.robot.commands.ClimberStopClimbing;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private CANTalon climberMotor = new CANTalon(RobotMap.CLIMBER_MOTOR);
	private CANTalon climberMotor2 = new CANTalon(RobotMap.CLIMBER_MOTOR_2);
	double climerSpeed;

	public Climber() {

		climberMotor.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		climberMotor.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		climberMotor.configNominalOutputVoltage(+0.0f, -0.0f);
		climberMotor.configPeakOutputVoltage(0.0f, -12.0f);
		climberMotor.reverseSensor(false);
		climberMotor.reverseOutput(true);

		climberMotor2.changeControlMode(CANTalon.TalonControlMode.Follower);
		climberMotor2.set(RobotMap.CLIMBER_MOTOR);
		climberMotor2.reverseOutput(false);
	}

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new ClimberStopClimbing());
	}

	public void on(boolean direction) {
		double climberSpeed;
		
		// if climb direction is forward
				if (direction == true) {
					// set speed to full forward
					climberSpeed = -1.0;
				} else {
					// set speed to full backward
					climberSpeed = 1.0;
				}
		
		climberMotor.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		climberMotor.configPeakOutputVoltage(0.0f, -12.0f);
		climberMotor.set(climberSpeed);
	}

	public void off() {
		climberMotor.set(0);
	}
}
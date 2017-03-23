package org.usfirst.frc.team5253.robot.subsystems;

import org.usfirst.frc.team5253.robot.RobotMap;
import org.usfirst.frc.team5253.robot.commands.GearMechUp;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearMech extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private DoubleSolenoid gearPiston = new DoubleSolenoid(RobotMap.GEAR_MECH_PISTON_EXTEND,
			RobotMap.GEAR_MECH_PISTON_RETRACT);
	private CANTalon gearMotor = new CANTalon(RobotMap.GEAR_MECH_MOTOR);

	public GearMech() {
		 gearMotor.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		 gearMotor.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		 gearMotor.configNominalOutputVoltage(+0.0f, -0.0f);
		 gearMotor.configPeakOutputVoltage(0.0f,-12.0f);
		 gearMotor.reverseSensor(false);
		 gearMotor.reverseOutput(true);
	}

	public void down() {
		gearPiston.set(DoubleSolenoid.Value.kForward);
	}

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new GearMechUp());
	}

	public void off() {
		gearMotor.set(0.0);
	}

	public void on(double percent) {
		gearMotor.set(percent);
	}

	public void up() {
		gearPiston.set(DoubleSolenoid.Value.kReverse);
	}

}

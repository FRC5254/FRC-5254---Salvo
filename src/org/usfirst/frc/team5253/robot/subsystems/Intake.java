package org.usfirst.frc.team5253.robot.subsystems;

import org.usfirst.frc.team5253.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	CANTalon intakeMotor = new CANTalon(RobotMap.INTAKE_MOTOR);
	
	public Intake() {
		
		intakeMotor.changeControlMode(CANTalon.TalonControlMode.Speed);
		intakeMotor.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		intakeMotor.configNominalOutputVoltage(+0.0f, -0.0f);
		intakeMotor.configPeakOutputVoltage(0.0f,-12.0f);
		intakeMotor.reverseSensor(false);
		intakeMotor.reverseOutput(false);
		intakeMotor.setF(0.025);
		intakeMotor.setPID(0.11, 0.0, 0.0);
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void startIntake(int RPM) {
    	intakeMotor.changeControlMode(CANTalon.TalonControlMode.Speed);
		intakeMotor.configPeakOutputVoltage(0.0f,-12.0f);
		intakeMotor.set(-RPM);
    }
    
    public void stopIntake() {
    	intakeMotor.set(0);
    }
}


package org.usfirst.frc.team5253.robot.subsystems;

import org.usfirst.frc.team5253.robot.RobotMap;
import org.usfirst.frc.team5253.robot.commands.StopIntaking;

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
		
		intakeMotor.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		intakeMotor.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		intakeMotor.configNominalOutputVoltage(+0.0f, -0.0f);
		intakeMotor.configPeakOutputVoltage(0.0f,-12.0f);
		intakeMotor.reverseSensor(false);
		intakeMotor.reverseOutput(true);
		intakeMotor.setF(0.025);
		intakeMotor.setPID(0.11, 0.0, 0.0);
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new StopIntaking());
    }
    
    public void startIntake() {
    	intakeMotor.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		intakeMotor.configPeakOutputVoltage(0.0f,-12.0f);
		intakeMotor.set(-1);
    }
    
    public void stopIntake() {
    	intakeMotor.set(0);
    }
}


package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
    private final TalonSRX firstElevatorMotor = new TalonSRX(22);
    private final TalonSRX secondELevatorMotor = new TalonSRX(21);
    private DigitalInput topHeightLimitSwitch = new DigitalInput(0);

    public void activate(double kLeftY) {
        // on joystick, positive is down
        if (kLeftY > 0) {
            firstElevatorMotor.set(ControlMode.PercentOutput, -kLeftY);
            secondELevatorMotor.set(ControlMode.PercentOutput, kLeftY);
        // on joystick, negative is up  
        } else if (kLeftY < 0 && (topHeightLimitSwitch.get())) { 
            firstElevatorMotor.set(ControlMode.PercentOutput, -kLeftY);
            secondELevatorMotor.set(ControlMode.PercentOutput, kLeftY);
        } else {
            firstElevatorMotor.set(ControlMode.PercentOutput, 0);
            secondELevatorMotor.set(ControlMode.PercentOutput, 0);
        }
    }
}
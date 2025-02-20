package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
    private final TalonSRX firstElevatorMotor = new TalonSRX(0);
    private final TalonSRX secondELevatorMotor = new TalonSRX(1);
    
    private double fullSpeed = 1;

    public void activate(boolean kLeftStick) {
        if (kLeftStick) {
            firstElevatorMotor.set(ControlMode.PercentOutput, fullSpeed);
            secondELevatorMotor.set(ControlMode.PercentOutput, fullSpeed);
        } else if (!kLeftStick) {
            firstElevatorMotor.set(ControlMode.PercentOutput, 0);
            secondELevatorMotor.set(ControlMode.PercentOutput, 0);
        }
    }
}
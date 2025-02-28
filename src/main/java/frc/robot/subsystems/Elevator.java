package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
    private final TalonSRX firstElevatorMotor = new TalonSRX(22);
    private final TalonSRX secondELevatorMotor = new TalonSRX(21);
    
    private double fullSpeed = 1;
    private double halfSpeed = -0.5;

    public void activate(double kLeftY) {
        if (kLeftY > 0.5) {
            firstElevatorMotor.set(ControlMode.PercentOutput, fullSpeed);
            secondELevatorMotor.set(ControlMode.PercentOutput, fullSpeed);
        } else if (kLeftY > 0 && kLeftY <= 0.5) {
            firstElevatorMotor.set(ControlMode.PercentOutput, halfSpeed);
            secondELevatorMotor.set(ControlMode.PercentOutput, halfSpeed);
        } else if (kLeftY == 0) {
            firstElevatorMotor.set(ControlMode.PercentOutput, 0);
            secondELevatorMotor.set(ControlMode.PercentOutput, 0);
        } else if (kLeftY < 0 && kLeftY >= -0.5) {
            firstElevatorMotor.set(ControlMode.PercentOutput, -halfSpeed);
            secondELevatorMotor.set(ControlMode.PercentOutput, -halfSpeed);
        } else if (kLeftY > -1 && kLeftY < -0.5) {
            firstElevatorMotor.set(ControlMode.PercentOutput, -fullSpeed);
            secondELevatorMotor.set(ControlMode.PercentOutput, -fullSpeed);
        }
    }
}
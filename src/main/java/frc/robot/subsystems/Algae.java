package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Algae extends SubsystemBase {
    private final TalonSRX algaeMotor = new TalonSRX(25);

    public void activate(double kRightY) {
        if (kRightY > 0) {
            algaeMotor.set(ControlMode.PercentOutput, kRightY);
        } else if (kRightY < 0) {
            algaeMotor.set(ControlMode.PercentOutput, kRightY);
        } else {
            algaeMotor.set(ControlMode.PercentOutput, 0);
        }
    }
}
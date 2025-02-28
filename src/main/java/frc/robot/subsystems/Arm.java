package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
    private final TalonSRX armMotor = new TalonSRX(24);

    private double fullSpeed = -1;
    private double halfSpeed = -0.5;

    public void activate(boolean kRightBumper) {
        if (kRightBumper) {
            armMotor.set(ControlMode.PercentOutput, halfSpeed);
        } else if (!kRightBumper) {
            armMotor.set(ControlMode.PercentOutput, 0);
        }
    }
}

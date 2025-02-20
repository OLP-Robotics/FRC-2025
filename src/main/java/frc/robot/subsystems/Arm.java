package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
    private final TalonSRX armMotor = new TalonSRX(1);

    private double fullSpeed = 1;

    public void activate(boolean kRightTrigger) {
        if (kRightTrigger) {
            armMotor.set(ControlMode.PercentOutput, fullSpeed);
        } else if (!kRightTrigger) {
            armMotor.set(ControlMode.PercentOutput, 0);
        }
    }
}

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Funnel extends SubsystemBase {
    private final TalonSRX firstFunnelMotor = new TalonSRX(0);
    private final TalonSRX secondFunnelMotor = new TalonSRX(1);
    
    private double fullSpeed = 1;

    public void activate(boolean xButtonPressed) {
        if (xButtonPressed) {
            firstFunnelMotor.set(ControlMode.PercentOutput, fullSpeed);
            secondFunnelMotor.set(ControlMode.PercentOutput, fullSpeed);
        } else if (!xButtonPressed) {
            firstFunnelMotor.set(ControlMode.PercentOutput, 0);
            secondFunnelMotor.set(ControlMode.PercentOutput, 0);
        }
    }
}

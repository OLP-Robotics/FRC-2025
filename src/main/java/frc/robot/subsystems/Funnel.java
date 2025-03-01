package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Funnel extends SubsystemBase {
    private final VictorSPX funnelMotor = new VictorSPX(23);
    
    private double fullSpeed = 0.25;

    public void activate(boolean xButtonPressed, boolean bButtonPressed) {
        if (xButtonPressed) {
            funnelMotor.set(ControlMode.PercentOutput, -fullSpeed);
        } else if (!xButtonPressed && !bButtonPressed) {
            funnelMotor.set(ControlMode.PercentOutput, 0);
        } else if (bButtonPressed) {
            funnelMotor.set(ControlMode.PercentOutput, fullSpeed);
        }
    }
}

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Funnel extends SubsystemBase {
    private final VictorSPX funnelMotor = new VictorSPX(23);
    
    private double fullSpeed = 1;

    public void activate(boolean xButtonPressed) {
        if (xButtonPressed) {
            funnelMotor.set(ControlMode.PercentOutput, -fullSpeed);
        } else if (!xButtonPressed) {
            funnelMotor.set(ControlMode.PercentOutput, 0);
        }
    }
}

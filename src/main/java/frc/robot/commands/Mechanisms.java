package frc.robot.commands;
import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Funnel;


public class Mechanisms extends Command{
    private Funnel s_Funnel;
    private BooleanSupplier funnelSup;



    public Mechanisms(Funnel s_Funnel, BooleanSupplier funnelSup){
        this.s_Funnel = s_Funnel;
        this.funnelSup = funnelSup;
    }

    @Override
    public void execute() {
        s_Funnel.activate(
            funnelSup.getAsBoolean()
        );
    }
}

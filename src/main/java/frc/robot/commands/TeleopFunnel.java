package frc.robot.commands;
import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Funnel;


public class TeleopFunnel extends Command{
    private Funnel s_Funnel;
    private BooleanSupplier funnelSupForward;
    private BooleanSupplier funnelSupReverse;

    public TeleopFunnel(Funnel s_Funnel, BooleanSupplier funnelSupForward, BooleanSupplier funnelSupReverse){
        this.s_Funnel = s_Funnel;

        addRequirements(s_Funnel);

        this.funnelSupForward = funnelSupForward;
        this.funnelSupReverse = funnelSupReverse;
    }

    @Override
    public void execute() {
        s_Funnel.activate(
            funnelSupForward.getAsBoolean(),
            funnelSupReverse.getAsBoolean()
        );
    }
}

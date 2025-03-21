package frc.robot.commands;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Algae;


public class TeleopAlgae extends Command{
    private Algae s_Algae;
    private DoubleSupplier algaeSup;


    public TeleopAlgae(Algae s_Algae, DoubleSupplier algaeSup){
        this.s_Algae = s_Algae;

        addRequirements(s_Algae);

        this.algaeSup = algaeSup;
    }

    @Override
    public void execute() {
        s_Algae.activate(
            algaeSup.getAsDouble()
        );
    }
}

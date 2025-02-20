package frc.robot.commands;
import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Arm;


public class TeleopArm extends Command{

    private Arm s_Arm;
    private BooleanSupplier armSup;

    public TeleopArm(Arm s_Arm, BooleanSupplier armSup){
        this.s_Arm = s_Arm;

        addRequirements(s_Arm);

        this.armSup = armSup;
    }

    @Override
    public void execute() {
        s_Arm.activate(
            armSup.getAsBoolean()
        );
    }
}

package frc.robot.commands;
import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Arm;


public class TeleopArm extends Command{

    private Arm s_Arm;
    private BooleanSupplier armSupForward;
    private BooleanSupplier armSupReverse;

    public TeleopArm(Arm s_Arm, BooleanSupplier armSupForward, BooleanSupplier armSupReverse){
        this.s_Arm = s_Arm;

        addRequirements(s_Arm);

        this.armSupForward = armSupForward;
        this.armSupReverse = armSupReverse;
    }

    @Override
    public void execute() {
        s_Arm.activate(
            this.armSupForward.getAsBoolean(),
            this.armSupReverse.getAsBoolean()
        );
    }
}

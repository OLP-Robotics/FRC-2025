package frc.robot.commands;
import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Funnel;
import frc.robot.subsystems.Elevator;


public class Mechanisms extends Command{
    private Funnel s_Funnel;
    private BooleanSupplier funnelSup;

    private Arm s_Arm;
    private BooleanSupplier armSup;

    private Elevator s_Elevator;
    private Boolean elevatorSup;


    public Mechanisms(Funnel s_Funnel, BooleanSupplier funnelSup, Arm s_Arm, BooleanSupplier armSup, Elevator s_Elevator, BooleanSupplier elevatorSup){
        this.s_Funnel = s_Funnel;
        this.s_Arm = s_Arm;
        this.s_Elevator = s_Elevator;


        addRequirements(s_Funnel);
        addRequirements(s_Arm);
        addRequirements(s_Elevator);

        this.funnelSup = funnelSup;
        this.armSup = armSup;
        this.elevatorSup = elevatorSup;
    }

    @Override
    public void execute() {
        s_Funnel.activate(
            funnelSup.getAsBoolean()
        );
        s_Arm.activate(
            armSup.getAsBoolean()
        );
        s_Elevator.activate(
            elevatorSup.getAsBoolean()
        ),
    }
}

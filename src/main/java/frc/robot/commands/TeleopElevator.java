package frc.robot.commands;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Elevator;


public class TeleopElevator extends Command{
    private Elevator s_Elevator;
    private DoubleSupplier elevatorSup;


    public TeleopElevator(Elevator s_Elevator, DoubleSupplier elevatorSup){
        this.s_Elevator = s_Elevator;

        addRequirements(s_Elevator);

        this.elevatorSup = elevatorSup;
    }

    @Override
    public void execute() {
        s_Elevator.activate(
            elevatorSup.getAsDouble()
        );
    }
}

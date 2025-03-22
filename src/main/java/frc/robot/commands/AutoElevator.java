package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj.Timer;

public class AutoElevator extends Command{
    private Elevator s_Elevator;
    private Arm s_Arm;
    private Timer moveTimer;


    public AutoElevator(Elevator s_Elevator, Arm s_Arm, Timer moveTimer){
        this.s_Elevator = s_Elevator;
        this.s_Arm = s_Arm;

        addRequirements(s_Elevator, s_Arm);

        this.moveTimer = moveTimer;
    }

    @Override
    public void execute() {
        if (moveTimer.get() > 5 && moveTimer.get() < 8) {
            s_Elevator.activate(-1.0);
        } else if (moveTimer.get() > 8 && moveTimer.get() < 14 ){
            s_Elevator.activate(0);
            s_Arm.activate(true, false);
        } else {
            s_Elevator.activate(0);
            s_Arm.activate(false, false);
        }
    }
}

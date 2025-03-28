package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.autos.*;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    /* Controllers */
    private final Joystick driver = new Joystick(0);
    private final Joystick co_driver = new Joystick(1);

    /* Drive Controls */
    private final int translationAxis = XboxController.Axis.kLeftY.value;
    private final int strafeAxis = XboxController.Axis.kLeftX.value;
    private final int rotationAxis = XboxController.Axis.kRightX.value;

    /* Driver Buttons */
    private final JoystickButton zeroGyro = new JoystickButton(driver, XboxController.Button.kY.value);
    private final JoystickButton robotCentric = new JoystickButton(driver, XboxController.Button.kLeftBumper.value);
    
    /* Co_Driver Buttons */
    private final JoystickButton controlFunnel = new JoystickButton(co_driver, XboxController.Button.kX.value);
    private final JoystickButton revreseFunnel = new JoystickButton(co_driver, XboxController.Button.kB.value);
    private final JoystickButton controlIntake = new JoystickButton(co_driver, XboxController.Button.kRightBumper.value);
    private final JoystickButton reverseIntake = new JoystickButton(co_driver, XboxController.Button.kLeftBumper.value);
    // private final JoystickButton controlIntake2 = new JoystickButton(co_driver, XboxController.Axis.kLeftTrigger.value);


    /* Co_Driver Controls */
    private final int controlElevator = XboxController.Axis.kLeftY.value;
    private final int controlAlgae = XboxController.Axis.kRightY.value;



    /* Subsystems */
    private final Swerve s_Swerve = new Swerve();
    private final Funnel s_Funnel = new Funnel();
    private final Arm s_Arm = new Arm();
    private final Elevator s_Elevator = new Elevator();
    private final Algae s_Algae = new Algae();


    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {
        s_Swerve.setDefaultCommand(
            new TeleopSwerve(
                s_Swerve, 
                () -> -driver.getRawAxis(translationAxis), 
                () -> -driver.getRawAxis(strafeAxis), 
                () -> -driver.getRawAxis(rotationAxis), 
                () -> robotCentric.getAsBoolean()
            )
        );

        s_Funnel.setDefaultCommand(
            new TeleopFunnel(
                s_Funnel,
                () -> controlFunnel.getAsBoolean(),
                () -> revreseFunnel.getAsBoolean()
            )
        );

        s_Arm.setDefaultCommand(
            new TeleopArm(
             s_Arm,
                () -> controlIntake.getAsBoolean(),
                () -> reverseIntake.getAsBoolean()
            )
        );

        s_Elevator.setDefaultCommand(
            new TeleopElevator(
            s_Elevator,
             () -> co_driver.getRawAxis(controlElevator)
            )
        );

        s_Algae.setDefaultCommand(
            new TeleopAlgae(
            s_Algae,
            () -> co_driver.getRawAxis(controlAlgae)
            )
        );

        // Configure the button bindings
        configureButtonBindings();
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
     * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
        /* Driver Buttons */
        zeroGyro.onTrue(new InstantCommand(() -> s_Swerve.zeroHeading()));
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        // An ExampleCommand will run in autonomous
        return new exampleAuto(s_Swerve, s_Elevator, s_Arm);
    }
}

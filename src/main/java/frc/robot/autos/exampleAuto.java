package frc.robot.autos;

import frc.robot.Constants;
import frc.robot.commands.AutoElevator;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Swerve;
import edu.wpi.first.wpilibj.Timer;

import java.util.List;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.SwerveControllerCommand;

public class exampleAuto extends SequentialCommandGroup {
    private final Timer moveTimer = new Timer();

    public exampleAuto(Swerve s_Swerve, Elevator s_Elevator, Arm s_Arm){
        moveTimer.start();
        TrajectoryConfig config =
            new TrajectoryConfig(
                    Constants.AutoConstants.kMaxSpeedMetersPerSecond,
                    Constants.AutoConstants.kMaxAccelerationMetersPerSecondSquared)
                //.setReversed() allows the user to go in the negative direction...
                .setKinematics(Constants.Swerve.swerveKinematics).setReversed(true);

        // An example trajectory to follow.  All units in meters.
        Trajectory exampleTrajectory =
            TrajectoryGenerator.generateTrajectory(
                // Start at the origin facing the +X direction
                new Pose2d(0, 0, new Rotation2d(0)),
                // Pass through these two interior waypoints, making a straight line backwards
                List.of(new Translation2d(-1, 0), new Translation2d(-2, 0)),
                // End 3 meters behind of where we started, facing forward
                new Pose2d(-3, 0, new Rotation2d(0)),
                config);        

        var thetaController =
            new ProfiledPIDController(
                Constants.AutoConstants.kPThetaController, 0, 0, Constants.AutoConstants.kThetaControllerConstraints);
        thetaController.enableContinuousInput(-Math.PI, Math.PI);

        SwerveControllerCommand swerveControllerCommand =
            new SwerveControllerCommand(
                exampleTrajectory,
                s_Swerve::getPose,
                Constants.Swerve.swerveKinematics,
                new PIDController(Constants.AutoConstants.kPXController, 0, 0),
                new PIDController(Constants.AutoConstants.kPYController, 0, 0),
                thetaController,
                s_Swerve::setModuleStates,
                s_Swerve);
        
        AutoElevator autoScoreCommand =
            new AutoElevator(s_Elevator, s_Arm, moveTimer);

        addCommands(
            new InstantCommand(() -> s_Swerve.setPose(exampleTrajectory.getInitialPose())),
            swerveControllerCommand
            // autoScoreCommand
        );
    }
}
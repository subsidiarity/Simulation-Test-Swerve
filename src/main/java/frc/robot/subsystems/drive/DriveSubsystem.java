package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.TeleopCommand;

public class DriveSubsystem extends SubsystemBase {
    private final DriveSubsystemIO io;

    public DriveSubsystem(DriveSubsystemIO io) {
        this.io = io;
    }

    @Override
    public void periodic() {
        // TODO: Implement the real logging system.
        Logger.recordOutput("SwerveStates", this.io.getSwerveStates());
        Logger.recordOutput("Robot Rotation", this.io.getRotation());
    }

    public void drive(double x, double y, double omega) {
        this.io.drive(ChassisSpeeds.fromFieldRelativeSpeeds(x * 10, y * 10, omega * 10, io.getRotation()));
    }
    
    public Command teleopCommand() {
        return new TeleopCommand(this);
    }
}

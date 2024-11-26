package frc.robot.subsystems.drive;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveModuleState;

import java.io.File;
import java.io.IOException;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj.Filesystem;
import swervelib.parser.SwerveParser;
import swervelib.SwerveDrive;
import edu.wpi.first.math.util.Units;
import swervelib.telemetry.SwerveDriveTelemetry;
import swervelib.telemetry.SwerveDriveTelemetry.TelemetryVerbosity;

public class DriveSubsystemIOSwerve implements DriveSubsystemIO {
    private SwerveDrive swerveDrive;

    public DriveSubsystemIOSwerve() {
        try {
            File swerveJsonDirectory = new File(Filesystem.getDeployDirectory(), "swerve");
            swerveDrive = new SwerveParser(swerveJsonDirectory).createSwerveDrive(Units.feetToMeters(12.5));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // swerveDrive.setHeadingCorrection(true);
    }

    public void drive(ChassisSpeeds speeds) {
        Logger.recordOutput("ChassisSpeeds", speeds);
        swerveDrive.drive(speeds);
    }

    public Rotation2d getRotation() {
        return swerveDrive.getPose().getRotation();
    }

    public SwerveModuleState[] getSwerveStates() {
        return swerveDrive.getStates();
    }
}
package frc.robot.subsystems.drive;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveModuleState;

public interface DriveSubsystemIO {
    public void drive(ChassisSpeeds speeds);
    public SwerveModuleState[] getSwerveStates();
    public Rotation2d getRotation();
}
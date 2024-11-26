package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.drive.DriveSubsystem;

public class TeleopCommand extends Command {
    private final DriveSubsystem m_subsystem;
    XboxController controller;

    public TeleopCommand(DriveSubsystem driveSubsystem) {
        addRequirements(driveSubsystem);

        this.m_subsystem = driveSubsystem;
        controller = new XboxController(0);
    }

    @Override
    public void execute() {
        this.m_subsystem.drive(
                controller.getRawAxis(0),
                controller.getRawAxis(1),
                controller.getRawAxis(2));
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}

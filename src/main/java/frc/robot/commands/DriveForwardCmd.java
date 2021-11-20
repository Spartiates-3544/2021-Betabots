package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

public class DriveForwardCmd extends CommandBase{
    private final Drivetrain drivetrain;
    private final double distance;
    private double targetAngle;

    public DriveForwardCmd(Drivetrain drivetrain, double distanceMeters) {
        this.drivetrain = drivetrain;
        this.distance = drivetrain.getEncoderMeters() + distanceMeters;
        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        targetAngle = drivetrain.getGyroAngle();
        System.out.println("DriveForwardCmd started!");
    }

    @Override
    public void execute() {
        //TODO Check if this works and if the right direction is reversed
        //Compensates for deviations with the gyroscope
        if (drivetrain.getGyroAngle() > targetAngle + 0.5) {
            drivetrain.arcadeDrive(Constants.DriveConstants.kAutoDriveForwardSpeed, Constants.DriveConstants.kAutoDriveTurnSpeed);
        } else if (drivetrain.getGyroAngle() < targetAngle - 0.5) {
            drivetrain.arcadeDrive(Constants.DriveConstants.kAutoDriveForwardSpeed, -Constants.DriveConstants.kAutoDriveTurnSpeed);
        }
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.setMotors(0, 0);
        System.out.println("DriveForwardCmd ended!");
    }

    @Override
    public boolean isFinished() {
        if (drivetrain.getEncoderMeters() > distance)
            return true;
        else
            return false;
    }
}

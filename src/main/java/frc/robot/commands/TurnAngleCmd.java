package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

public class TurnAngleCmd extends CommandBase{
    private final Drivetrain drivetrain;
    private final double angle;

    public TurnAngleCmd(Drivetrain drivetrain, double angle) {
        this.drivetrain = drivetrain;
        this.angle = angle;
        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        drivetrain.resetGyro();
        System.out.println("TurnAngleCmd started!");
    }

    @Override
    public void execute() {
        //Turn in the right direction
        if (angle > 0) {
            drivetrain.setMotors(Constants.DriveConstants.kAutoDriveForwardSpeed, -Constants.DriveConstants.kAutoDriveForwardSpeed);
        } else if (angle < 0) {
            drivetrain.setMotors(-Constants.DriveConstants.kAutoDriveForwardSpeed, Constants.DriveConstants.kAutoDriveForwardSpeed);
        }
    }

    @Override
    public void end(boolean interrupted) {
        System.out.println("TurnAngleCmd started!");
    }

    @Override
    public boolean isFinished() {
        //Returns true if the gyro angle is good enough (e.g Bigger or equal to the setpoint minus 0.5 degrees, or Smaller or equal to the setpoint plus 0.5 degrees)
        if (drivetrain.getGyroAngle() <= angle - 0.5 || drivetrain.getGyroAngle() >= angle + 0.5) {
            return true;
        }
        return false;
    }
}

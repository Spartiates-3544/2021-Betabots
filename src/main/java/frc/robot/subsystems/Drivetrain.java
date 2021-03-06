// RobotBuilder Version: 3.1
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

public class Drivetrain extends SubsystemBase {

private WPI_TalonFX left1;
private WPI_TalonFX left2;
private WPI_TalonFX left3;
private WPI_TalonFX right1;
private WPI_TalonFX right2;
private WPI_TalonFX right3;

private final SpeedControllerGroup m_rightmotors;
private final SpeedControllerGroup m_leftmotors;
private final DifferentialDrive m_drive;
private final AHRS m_gyro;


    public Drivetrain() {

    left1 = new WPI_TalonFX(Constants.DriveConstants.kLeftMotor1Port);
    left2 = new WPI_TalonFX(Constants.DriveConstants.kLeftMotor2Port);
    left3 = new WPI_TalonFX(Constants.DriveConstants.kLeftMotor3Port);
    right1 = new WPI_TalonFX(Constants.DriveConstants.kRightMotor1Port);
    right2 = new WPI_TalonFX(Constants.DriveConstants.kRightMotor2Port);
    right3 = new WPI_TalonFX(Constants.DriveConstants.kRightMotor3Port);
    m_leftmotors = new SpeedControllerGroup(left1, left2, left3);
    m_rightmotors = new SpeedControllerGroup(right1, right2, right3);
    m_drive = new DifferentialDrive(m_leftmotors, m_rightmotors);
    m_gyro = new AHRS(SPI.Port.kMXP);
    m_drive.setDeadband(0.1); //Deadzone
    
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

    }

    public void arcadeDrive(double fwd, double rot) {
        m_drive.arcadeDrive(fwd, rot);
    }

    public void setMaxOutput(double maxOutput) {
        m_drive.setMaxOutput(maxOutput);
      }

    public double getTurnRate() {
        return m_gyro.getRate() * (Constants.DriveConstants.kGyroReversed ? -1.0 : 1.0);
      }

    public void setMotors(double leftSpeed, double rightSpeed) {
        m_leftmotors.set(leftSpeed);
        m_rightmotors.set(rightSpeed);
    }

    public double getEncoderMeters() {
        return left1.getSelectedSensorPosition() + -right1.getSelectedSensorPosition() /2 * Constants.DriveConstants.kEncoderTick2Meter;
    }

    public double getGyroAngle() {
        return m_gyro.getAngle();
    }

    public void resetGyro() {
        m_gyro.reset();
    }

}


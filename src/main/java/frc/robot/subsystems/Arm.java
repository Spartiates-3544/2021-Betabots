package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase{
    private TalonFX arm;

    public Arm() {
        arm = new TalonFX(Constants.ArmConstants.kArmMotorPort);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

/*
    public void openClaw() {
        if (isTopLimitSwitchPressed()) {
            claw.set(ControlMode.PercentOutput, 0);
        } else {
            claw.set(ControlMode.PercentOutput, Constants.ArmConstants.kClawOpenSpeed);
        }
    }

    public void closeClaw() {
        if (isBottomLimitSwitchPressed()) {
            claw.set(ControlMode.PercentOutput, 0);
        } else {
            claw.set(ControlMode.PercentOutput, Constants.ArmConstants.kClawCloseSpeed);
        }
    }
*/

    public void setArm(double armMotorOutput) {
        arm.set(TalonFXControlMode.PercentOutput, armMotorOutput);
    }

}

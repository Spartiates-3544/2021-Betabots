package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Claw extends SubsystemBase{
    private TalonSRX claw;
    DigitalInput topLimitSwitch;
    DigitalInput bottomLimitSwitch;

    public Claw() {
        claw = new TalonSRX(Constants.ArmConstants.kClawMotorPort);
        topLimitSwitch = new DigitalInput(Constants.ArmConstants.kTopLimitSwitchPort);
        bottomLimitSwitch = new DigitalInput(Constants.ArmConstants.kBottomLimitSwitchPort);
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

    public void setClaw(double clawMotorOutput) {
        claw.set(ControlMode.PercentOutput, clawMotorOutput);
    }

    public boolean isTopLimitSwitchPressed() {
        return topLimitSwitch.get();
    }

    public boolean isBottomLimitSwitchPressed() {
        return bottomLimitSwitch.get();
    }

}

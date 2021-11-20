package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase{
    private TalonFX arm;
    private TalonSRX claw;

    public Arm() {
        arm = new TalonFX(Constants.ArmConstants.kArmMotorPort);
        claw = new TalonSRX(Constants.ArmConstants.kClawMotorPort);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    public void clawState(boolean openclose) {
        if (openclose) {
            claw.set(TalonSRXControlMode.PercentOutput, 0.1);
        }
    }
}

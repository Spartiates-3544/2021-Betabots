package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Claw;

public class OpenClawCmd extends CommandBase {
    private final Claw claw;

    public OpenClawCmd(Claw claw) {
        this.claw = claw;
        addRequirements(claw);
    }

    @Override
    public void initialize() {
        System.out.println("OpenClawCmd started!");
    }

    //pain

    @Override
    public void execute() {
        claw.setClaw(Constants.ArmConstants.kClawOpenSpeed);
    }

    @Override
    public void end(boolean interrupted) {
        System.out.println("OpenClawCmd ended!");
        if (interrupted) {
            claw.setClaw(0);
        }
    }

    @Override
    public boolean isFinished() {
        if (claw.isTopLimitSwitchPressed()) {
            return true;
        }
        return false;
    }
}
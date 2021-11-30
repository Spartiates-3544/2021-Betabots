package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Claw;

public class CloseClawCmd extends CommandBase {
    private final Claw claw;

    public CloseClawCmd(Claw claw) {
        this.claw = claw;
        addRequirements(claw);
    }

    @Override
    public void initialize() {
        System.out.println("CloseClawCmd started!");
    }

    //pain 2: Electric boogaloo

    @Override
    public void execute() {
        claw.setClaw(Constants.ArmConstants.kClawCloseSpeed);
    }

    @Override
    public void end(boolean interrupted) {
        System.out.println("CloseClawdCmd ended!");
        if (interrupted) {
            claw.setClaw(0);
        }
    }

    @Override
    public boolean isFinished() {
        if (claw.isBottomLimitSwitchPressed()) {
            return true;
        }
        return false;
    }
}
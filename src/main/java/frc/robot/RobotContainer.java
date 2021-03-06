// RobotBuilder Version: 3.1
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.controller.PIDController;



/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();

// The robot's subsystems
    public final Drivetrain m_drivetrain = new Drivetrain();
    public final Arm m_arm = new Arm();
    public final Claw m_claw = new Claw();

// Joysticks
private final XboxController xboxController1 = new XboxController(0);
private final Joystick joystick = new Joystick(1);

  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
  private RobotContainer() {
    // Smartdashboard Subsystems

    // SmartDashboard Buttons
    SmartDashboard.putData("Autonomous Command", new AutonomousCommand());

    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
    m_drivetrain.setDefaultCommand(new RunCommand( () -> m_drivetrain.arcadeDrive(-xboxController1.getRawAxis(XboxController.Axis.kLeftY.value), xboxController1.getRawAxis(XboxController.Axis.kLeftTrigger.value) - xboxController1.getRawAxis(XboxController.Axis.kRightTrigger.value)), m_drivetrain));
    m_arm.setDefaultCommand(new RunCommand( () -> m_arm.setArm(joystick.getRawAxis(Constants.ArmConstants.kVerticalAxisJoystick)), m_arm));
}

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    // Drive at 50% speed when right bumper is held
    new JoystickButton(xboxController1, Button.kBumperRight.value)
    .whenPressed(() -> m_drivetrain.setMaxOutput(0.5))
    .whenReleased(() -> m_drivetrain.setMaxOutput(1));

    
    // Stabilize robot to drive straight with gyro when left bumper is held
    new JoystickButton(xboxController1, Button.kBumperLeft.value)
        .whenHeld(
            new PIDCommand(
                new PIDController(
                    Constants.DriveConstants.kStabilizationP,
                    Constants.DriveConstants.kStabilizationI,
                    Constants.DriveConstants.kStabilizationD),
                // Close the loop on the turn rate
                m_drivetrain::getTurnRate,
                // Setpoint is 0
                0,
                // Pipe the output to the turning controls
                output -> m_drivetrain.arcadeDrive(xboxController1.getRawAxis(XboxController.Axis.kLeftY.value), output),
                // Require the robot drive
                m_drivetrain));

    new JoystickButton(xboxController1, Button.kA.value).whileActiveOnce(new DriveForwardCmd(m_drivetrain, 10)); //TODO Remove, temporary (this is an autonomous command)

    new JoystickButton(xboxController1, Button.kB.value).whenPressed(new OpenClawCmd(m_claw));
    new JoystickButton(xboxController1, Button.kX.value).whenPressed(new CloseClawCmd(m_claw));
  }

public XboxController getXboxController1() {
      return xboxController1;
    }

public Joystick getJoystick() {
  return joystick;
}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return m_chooser.getSelected();
  }
  

}


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

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public class Constants {

     public static final class DriveConstants {
       public static final int kLeftMotor1Port = 0;
       public static final int kLeftMotor2Port = 1;
       public static final int kLeftMotor3Port = 2;
       public static final int kRightMotor1Port = 3;
       public static final int kRightMotor2Port = 4;
       public static final int kRightMotor3Port = 5; 
       public static final boolean kGyroReversed = false;
       public static final double kStabilizationP = 0.2;
       public static final double kStabilizationI = 0.2; //TODO Tune these values for the robot
       public static final double kStabilizationD = 0.2;
       public static final double kEncoderTick2Inches = 0.001227184630; //Distance per tick in inches //10240 ticks = 1 rotation of the wheels (1/5 reduction, 2048CPR encoder)
       public static final double kEncoderTick2Meter = 0.000029765625; //Distance per tick in meters //10240 ticks = 1 rotation of the wheels (1/5 reduction, 2048CPR encoder)
       public static final double kAutoDriveForwardSpeed = 0.5;
       public static final double kAutoDriveTurnSpeed = 0.2;
     }


     //TODO GODDAMMIT CHECK EVERYTHING
    public static final class ArmConstants {
      public static final int kArmMotorPort = 6;
      public static final int kClawMotorPort = 7;
      public static final int kTopLimitSwitchPort = 0; //TODO Change
      public static final int kBottomLimitSwitchPort = 1; //TODO Change
      public static final double kClawOpenSpeed = -0.1; //10% reversed
      public static final double kClawCloseSpeed = 0.1; //10% forward
      public static final int kVerticalAxisJoystick = 1; //TODO Change/make sure that this is the right axis number
    }
}


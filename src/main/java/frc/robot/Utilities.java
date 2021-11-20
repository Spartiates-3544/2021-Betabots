package frc.robot;

public class Utilities {
    public static double createRotation(double leftTrigger, double rightTrigger) {
        return (rightTrigger - leftTrigger);
    }
}
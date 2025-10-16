package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.Constants.OperatorConstants;

import java.util.function.Supplier;

import com.revrobotics.spark.SparkMax;

import com.revrobotics.spark.SparkLowLevel.MotorType;


public class Drivetrain extends SubsystemBase {
    
    private final SparkMax frontLeft = new SparkMax(OperatorConstants.frontLeftId, MotorType.kBrushless);
    private final SparkMax frontRight = new SparkMax(OperatorConstants.frontRightId, MotorType.kBrushless);
    private final SparkMax backLeft = new SparkMax(OperatorConstants.backLeftId, MotorType.kBrushless);
    private final SparkMax backRight = new SparkMax(OperatorConstants.backRightId, MotorType.kBrushless);

    public Drivetrain() {}

    public void setSpeeds(double[] speeds) {
        frontLeft.set(speeds[0]);
        frontRight.set(speeds[1]);
        backLeft.set(speeds[2]);
        backRight.set(speeds[3]);
    }

    public Command driveJoystick(Supplier<Double> driveSpd, Supplier<Double> turnSpd) {
        double left = driveSpd.get() + turnSpd.get();
        double right = driveSpd.get() - turnSpd.get();
        double[] motorSpeeds = {left, 0, -0, 0};
        return this.runOnce(() -> this.setSpeeds(motorSpeeds));
    }

}

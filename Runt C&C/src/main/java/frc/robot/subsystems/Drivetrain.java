package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.OperatorConstants;

public class Drivetrain extends SubsystemBase{
    private final CANSparkMax frontLeft = new CANSparkMax(OperatorConstants.frontLeftID, MotorType.kBrushless);
    private final CANSparkMax backLeft = new CANSparkMax(OperatorConstants.backLeftID, MotorType.kBrushless);
    private final CANSparkMax frontRight = new CANSparkMax(OperatorConstants.frontRightID, MotorType.kBrushless);
    private final CANSparkMax backRight = new CANSparkMax(OperatorConstants.backRightID, MotorType.kBrushless);

    public Drivetrain() {}

    public void stop() {
        frontRight.set(0);
        backRight.set(0);
        frontLeft.set(0);
        backLeft.set(0);
    }
    
    public void setMotors(double[] motorSpeeds) {
        frontLeft.set(motorSpeeds[0]);
        backLeft.set(motorSpeeds[1]);
        frontRight.set(motorSpeeds[2]);
        backRight.set(motorSpeeds[3]);
    }
}

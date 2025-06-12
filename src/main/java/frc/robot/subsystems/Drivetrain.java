package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.Constants.OperatorConstants;


public class Drivetrain extends SubsystemBase {   
    private final CANSparkMax frontLeft = new CANSparkMax(OperatorConstants.frontLeftID , MotorType.kBrushless);
    private final CANSparkMax frontRight = new CANSparkMax(OperatorConstants.frontRightID , MotorType.kBrushless);
    private final CANSparkMax backLeft = new CANSparkMax(OperatorConstants.backLeftID , MotorType.kBrushless);
    private final CANSparkMax backRight = new CANSparkMax(OperatorConstants.backRightID , MotorType.kBrushless);

    public Drivetrain(){}

    public void stop(){
        frontLeft.set(0);
        frontRight.set(0);
        backLeft.set(0);
        backRight.set(0);
    }

    public void setSpeeds(double[] speed){
        frontLeft.set(speed[0]);
        frontRight.set(speed[1]);
        backLeft.set(speed[2]);
        backRight.set(speed[3]);
    }

    public Command driveJoystick(double left, double right) {
        double[] speed = {left, left, right, -right};
        return this.runOnce(() -> this.setSpeeds(speed));
    }
}

package frc.robot.commands;
import java.util.function.Supplier;

import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DrivetrainJoystickCMD extends CommandBase {
    private Drivetrain runt;
    private Supplier<Double> driveSpd, turnSpd;

    public DrivetrainJoystickCMD(Drivetrain runt, Supplier<Double> driveSpd, Supplier<Double> turnSpd) {
        this.runt = runt;
        this.driveSpd = driveSpd;
        this.turnSpd = turnSpd;
        addRequirements(runt);
    }

    public void initialize() {}

    @Override
    public void execute() {
        double left = driveSpd.get() + turnSpd.get();
        double right = driveSpd.get() - turnSpd.get();
        double[] motorSpeeds = {left, left, right, -right};

        runt.setMotors(motorSpeeds);
    }

    @Override
    public void end(boolean interrupted) {}

    @Override
    public boolean isFinished() {
        return false;
    }
}
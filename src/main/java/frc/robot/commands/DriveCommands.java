package frc.robot.commands;
import java.util.function.Supplier;

import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;

public class DriveCommands extends Command {
    private Drivetrain runt;
    private Supplier<Double> driveSpd, turnSpd;

    public DriveCommands(Drivetrain runt, Supplier<Double> turnSpd, Supplier<Double> driveSpd) {
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
        double[] motorSpeeds = {-left, -right, -left, right};

        runt.setSpeeds(motorSpeeds);
    }

    @Override
    public void end(boolean interrupted) {}

    @Override
    public boolean isFinished() {
        return false;
    }
}
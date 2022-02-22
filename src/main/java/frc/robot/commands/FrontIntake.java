// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.Intake;

import org.opencv.core.RotatedRect;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class FrontIntake extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Intake m_subsystem;

<<<<<<< Updated upstream:src/main/java/frc/robot/commands/TeleopDriveForever.java
  private double m_speed;
  private double m_rotation;
=======
  private static double timesRun = 0.0;
>>>>>>> Stashed changes:src/main/java/frc/robot/commands/FrontIntake.java
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public FrontIntake(Intake subsystem) {
    m_subsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
<<<<<<< Updated upstream:src/main/java/frc/robot/commands/TeleopDriveForever.java
    m_speed = speed;
    m_rotation = rotation;
  }
=======
    }
>>>>>>> Stashed changes:src/main/java/frc/robot/commands/FrontIntake.java

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_subsystem.frontOff();
    System.out.println("in frontinatke's intialize");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_subsystem.frontOn();
    System.out.println("in frontinatke's execute");
  }

  // Called once the command ends or is interrupted.
  @Override
<<<<<<< Updated upstream:src/main/java/frc/robot/commands/TeleopDriveForever.java
  public void end(boolean interrupted) {}
=======
  public void end(boolean interrupted) {
    m_subsystem.frontOff();
    System.out.println("in frontinatke's end");
  }
>>>>>>> Stashed changes:src/main/java/frc/robot/commands/FrontIntake.java

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    /*if(RobotContainer.getInstance().getSquareButton()){
      return false;
    }*/
    return true;
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class FrontIntake extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Intake m_subsystem;

  private static double timesScheduled = 0.0;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public FrontIntake(Intake subsystem) {
    m_subsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
    }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_subsystem.frontOff();
    timesScheduled++;
    System.out.println("in frontinatke's intialize " + timesScheduled);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_subsystem.frontOn();
    System.out.println("in frontinatke's execute");
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.frontOff();
    System.out.println("in frontinatke's end");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // should be set to FALSE for whileHeld() 
    // whileHeld() calls CommandScheduler's cancel() when button is false
    // that cancel() calls command.end()
      return false; 
    }
}

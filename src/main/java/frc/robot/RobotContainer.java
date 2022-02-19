// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.wpilibj.PS4Controller;
//controller
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

//subsystem
import frc.robot.subsystems.DriveSubsystem;

//commands
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.commands.TeleopDrive;
import frc.robot.commands.TeleopDriveDubSup;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  //create RobotContainer Singleton
  private static RobotContainer m_robotContainer = new RobotContainer();
  
  // The robot's subsystems
  //private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final DriveSubsystem m_DriveSubsystem = new DriveSubsystem();  

  // The robot's commands
  private final CommandBase m_autoCommand = new TeleopDrive(m_DriveSubsystem, 0.21, 0.11);

  // The robot's controller
  private final PS4Controller m_controller = new PS4Controller(0);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  private RobotContainer() {
    //set each subsystem's default command
    m_DriveSubsystem.setDefaultCommand(new TeleopDriveDubSup(m_DriveSubsystem, m_controller::getLeftY, m_controller::getLeftX));

    // Configure the button bindings
    //configureButtonBindings();
  }

  /** because its a singleton */
  public static RobotContainer getInstance(){
    return m_robotContainer;
  }
  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    
    JoystickButton square = new JoystickButton(m_controller, 1);
    
    square.whenPressed(new TeleopDrive(m_DriveSubsystem, 0, 0.41));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}

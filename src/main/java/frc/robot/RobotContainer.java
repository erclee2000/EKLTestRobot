// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.wpilibj.PS4Controller;
<<<<<<< Updated upstream
//controller
import edu.wpi.first.wpilibj.XboxController;
=======
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
>>>>>>> Stashed changes
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

//subsystem
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.Intake;
//commands
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.commands.TeleopDrive;
import frc.robot.commands.FrontIntake;

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
  private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();  
  private final Intake m_intake = new Intake();  

  // The robot's commands
<<<<<<< Updated upstream
  private final CommandBase m_autoCommand = new TeleopDriveForever(m_driveSubsystem, 0.11, 0.11);

=======
  Command m_autoCommand = new FrontIntake(m_intake);
  Command m_frontIntake = new FrontIntake(m_intake);
>>>>>>> Stashed changes
  // The robot's controller
  private final PS4Controller m_controller = new PS4Controller(0);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  private RobotContainer() {
    //set each subsystem's default command
    m_driveSubsystem.setDefaultCommand(new TeleopDrive(m_driveSubsystem, m_controller::getLeftY, m_controller::getLeftX));

    // Configure the button bindings
    configureButtonBindings();
<<<<<<< Updated upstream
=======

    // put some stuff on the shuffleboard
    SmartDashboard.putData(m_driveSubsystem);
    SmartDashboard.putData(m_intake);
    
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
    square.whileHeld(new TeleopDriveForever(m_driveSubsystem, 0.41, 0.41));

=======
    JoystickButton cross = new JoystickButton(m_controller, 2);
>>>>>>> Stashed changes
    JoystickButton circle = new JoystickButton(m_controller, 3);
    circle.whenHeld(new TeleopDriveForever(m_driveSubsystem, 0.61, 0.61));

<<<<<<< Updated upstream
    JoystickButton cross = new JoystickButton(m_controller, 2);
    cross.whenPressed(new TeleopDriveCheckButton(m_driveSubsystem, 0.81, 0.81));
    
=======
    //square.whenPressed(new FrontIntake(m_intake));
    //square.whileHeld(new FrontIntake(m_intake));
    square.whileHeld(m_frontIntake::execute);
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
  public boolean getControllerCross(){
    return m_controller.getCrossButton();
  }
=======
  public boolean getSquareButton(){
    return m_controller.getSquareButton();
  }

>>>>>>> Stashed changes
}

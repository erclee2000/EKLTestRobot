// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

//subsystem
import frc.robot.subsystems.Drive;
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
  //private final Drive m_driveSubsystem = new Drive();  
  private final Intake m_intake = new Intake();  

  // The robot's commands
  Command m_autoCommand = new FrontIntake(m_intake);
  Command m_frontIntake = new FrontIntake(m_intake);
  // The robot's controller
  private final PS4Controller m_controller = new PS4Controller(0);

  //Shuffleboard
  //public NetworkTableEntry teleopCount = Shuffleboard.getTab("My Tab").add("Times TeleopDriveForever Has Run", 0).getEntry();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  private RobotContainer() {
    //set each subsystem's default command
    //m_driveSubsystem.setDefaultCommand(new TeleopDrive(m_driveSubsystem, m_controller::getLeftY, m_controller::getLeftX));

    // Configure the button bindings
    configureButtonBindings();

    // put some stuff on the shuffleboard
    //SmartDashboard.putData(m_driveSubsystem);
    SmartDashboard.putData(m_intake);
    
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
    JoystickButton cross = new JoystickButton(m_controller, 2);
    JoystickButton circle = new JoystickButton(m_controller, 3);

    /* three ways to do a similar thing */
    /* option 1: repeat sched/unsched--too quick to register speed on sim 
    square.whileHeld(new FrontIntake(m_intake));
    */

    /* option 2: direct call the methods of the command */ 
    square.whenPressed(() -> m_frontIntake.initialize());
    square.whileHeld(() -> m_frontIntake.execute());
    square.whenReleased(() -> m_frontIntake.end(false)); 
    
    /* option 3: create accessor to the button, then check button in command 
    square.whileHeld(m_frontIntake);
    */
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

  public boolean getSquareButton(){
    return m_controller.getSquareButton();
  }

}

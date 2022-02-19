// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  private PWMSparkMax leftMotorController1 = new PWMSparkMax(0);
  private PWMSparkMax leftMotorController2 = new PWMSparkMax(1);
  private PWMSparkMax rightMotorController1 = new PWMSparkMax(2);
  private PWMSparkMax rightMotorController2 = new PWMSparkMax(3);

  private MotorControllerGroup leftMotorControllerGroup = new MotorControllerGroup(leftMotorController1, leftMotorController2);
  private MotorControllerGroup rightMotorControllerGroup = new MotorControllerGroup(rightMotorController1, rightMotorController2);
  private DifferentialDrive m_DifferentialDrive = new DifferentialDrive(leftMotorControllerGroup, rightMotorControllerGroup);
  
  public DriveSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  //an accessor method to m_differntialDrive
  public void activateDifferentialDrive(double speed, double rotation){
    m_DifferentialDrive.arcadeDrive(speed,rotation);
  }
}

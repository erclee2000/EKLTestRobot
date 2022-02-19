// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/*
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxRelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
*/


public class DriveSubsystem extends SubsystemBase {
  /*
  private CANSparkMax leftMotorController1 = new CANSparkMax(0);
  private CANSparkMax leftMotorController2 = new CANSparkMax(1);
  private CANSparkMax rightMotorController1 = new CANSparkMax(2);
  private CANSparkMax rightMotorController2 = new CANSparkMax(3);
*/
private PWMSparkMax leftMotorController1 = new PWMSparkMax(0);
private PWMSparkMax leftMotorController2 = new PWMSparkMax(1);
private PWMSparkMax rightMotorController1 = new PWMSparkMax(2);
private PWMSparkMax rightMotorController2 = new PWMSparkMax(3);

  private MotorController leftMotorControllerGroup = new MotorControllerGroup(leftMotorController1, leftMotorController2);
  private MotorController rightMotorControllerGroup = new MotorControllerGroup(rightMotorController1, rightMotorController2);
  private DifferentialDrive m_DifferentialDrive = new DifferentialDrive(leftMotorControllerGroup, rightMotorControllerGroup);
  
  public DriveSubsystem() {
  
  }

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
    m_DifferentialDrive.arcadeDrive(speed, rotation);
  }

  //an accessor method to m_differntialDrive using DoubleSupplier
  /*
  public void activateDifferentialDrive(DoubleSupplier speed, DoubleSupplier rotation){
      m_DifferentialDrive.arcadeDrive(speed.getAsDouble(),rotation.getAsDouble());
  }
  */
  
}

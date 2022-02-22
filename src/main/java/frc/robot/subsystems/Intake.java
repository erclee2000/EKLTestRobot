// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  
  //TalonSRX intake1 = new TalonSRX(0);
  PWMSparkMax intake1 = new PWMSparkMax(5);
  double intake1on = 0.219;
  double intake1off = 0.0;
  
  /** Creates a new ExampleSubsystem. */
  public Intake() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void frontOn(){
    //intake1.set(ControlMode.PercentOutput, intake1on); for talonsrx
    intake1.set(intake1on);
  }

  public void frontOff(){
    intake1.set(intake1off);
  }
}

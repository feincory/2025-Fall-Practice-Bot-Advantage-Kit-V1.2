// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class intake extends SubsystemBase {
  /** Creates a new intake. */
  private final TalonFX intakeMotor = new TalonFX(30, "Drive CAN");

  private final DutyCycleOut intakeMotoroutput = new DutyCycleOut(0);
  TalonFXConfiguration intakeConfig = new TalonFXConfiguration();

  public intake() {

    intakeConfig.OpenLoopRamps.DutyCycleOpenLoopRampPeriod = 0.2;
    intakeMotor.getConfigurator().apply(intakeConfig);
    intakeMotor.setNeutralMode(NeutralModeValue.Coast);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void runintake() {
    intakeMotor.set(1);
  }

  public void stopintake() {
    intakeMotor.set(0);
  }
}

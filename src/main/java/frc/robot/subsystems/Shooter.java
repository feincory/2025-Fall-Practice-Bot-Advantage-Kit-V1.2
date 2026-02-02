// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  /** Creates a new intake. */
  private final TalonFX shooterMotor = new TalonFX(31, "Drive CAN");

  private final DutyCycleOut shooterMotoroutput = new DutyCycleOut(0);
  TalonFXConfiguration shooterConfig = new TalonFXConfiguration();

  public Shooter() {

    shooterConfig.OpenLoopRamps.DutyCycleOpenLoopRampPeriod = 1.5;
    shooterMotor.getConfigurator().apply(shooterConfig);
    shooterMotor.setNeutralMode(NeutralModeValue.Coast);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("shooter RPM", shooterMotor.getVelocity().getValueAsDouble());
  }

  public void runshooter() {
    shooterMotor.set(1);
  }

  public void runshootervariable(double speed) {
    shooterMotor.set(speed);
  }

  public void stopshooter() {
    shooterMotor.set(0);
  }
}

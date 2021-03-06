package frc.team3407.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team3407.robot.commands.CloseArms;
import frc.team3407.robot.commands.LowerLift;
import frc.team3407.robot.commands.OpenArms;
import frc.team3407.robot.commands.RaiseLift;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	public Joystick stickL = new Joystick(RobotMap.STICK_L);
	public Joystick stickR = new Joystick(RobotMap.STICK_R);
	public Joystick stickCam = null; //new Joystick(RobotMap.STICK_CAMERA);

	public Button triggerR = null; //new JoystickButton(stickR, RobotMap.SOLENOID_TRIGGER);
	public Button triggerCam = null; //new JoystickButton(stickCam, RobotMap.RESET_TRIGGER);
	
	public Button triggerLiftUp = new JoystickButton(stickR, RobotMap.LIFT_TRIGGER_UP);
	public Button triggerLiftDown = new JoystickButton(stickR, RobotMap.LIFT_TRIGGER_DOWN);
	public Button triggerArms = new JoystickButton(stickR, RobotMap.ARMS_TRIGGER);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	public OI(){
		//triggerR.whenPressed(new ShootSolenoid());
		//triggerCam.whenPressed(new HoldServo());
		triggerLiftUp.whileActive(new RaiseLift());		
		triggerLiftDown.whileActive(new LowerLift());
		
		triggerArms.whenActive(new OpenArms());
		triggerArms.whenReleased(new CloseArms());
	}

	public boolean getTriggerCam() {
		return (triggerCam == null) ? false : triggerCam.get();
	}
	
	public double getStickCam() {
		return (stickCam == null) ? 0.0 : stickCam.getX()+0.5;
	}
}
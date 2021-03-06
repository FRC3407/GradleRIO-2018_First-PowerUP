package frc.team3407.robot.commands;



import frc.team3407.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class TimedDrive extends TimedCommand {
	private double left, right;

    public TimedDrive(double timeout, double left, double right) {
        super(timeout);
        this.left = left;
        this.right = right;
        requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("TimedDrive left=" + left + " right=" + right);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive.tank(left,right);
    	
    }

    // Called once after timeout
    protected void end() {
    	Robot.drive.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drive.stop();
    }
}

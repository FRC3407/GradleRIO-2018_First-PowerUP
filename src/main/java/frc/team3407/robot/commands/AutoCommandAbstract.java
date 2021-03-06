package frc.team3407.robot.commands;

import frc.team3407.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public abstract class AutoCommandAbstract extends Command {
	boolean isLeft;
    public AutoCommandAbstract() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    	requires(Robot.lift);
    	requires(Robot.arms);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	isLeft = Robot.gameInfo.isSwitchLeft();
    }
    protected abstract void left();
    protected abstract void right();
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(isLeft) {
    		left();
    	} else {
    		right();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

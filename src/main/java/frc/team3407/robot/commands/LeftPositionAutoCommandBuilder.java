package frc.team3407.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftPositionAutoCommandBuilder extends AbstractAutoDropAtSwitchCommandBuilder {
	
	@Override
	protected void addDriveManeuver(Direction direction, CommandGroup command) {
		if (direction == Direction.LEFT) {
			addNearDriveManeuver(Direction.RIGHT, command);
		} else {
			addFarDriveManeuver(Direction.RIGHT, command);
		}		
	}
}

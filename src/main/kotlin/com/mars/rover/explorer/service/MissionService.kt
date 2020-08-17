package com.mars.rover.explorer.service

import com.mars.rover.explorer.domain.Command
import com.mars.rover.explorer.domain.Direction
import com.mars.rover.explorer.exceptions.RoverRuntimeException
import com.mars.rover.explorer.model.Area
import com.mars.rover.explorer.model.Position
import com.mars.rover.explorer.model.Rover
import org.springframework.stereotype.Service

@Service
class MissionService {

	var regex = String.format("(%s|%s|%s)+", Command.MOVE.value, Command.LEFT.value, Command.RIGTH.value).toRegex();

	var rover: Rover? = null

	fun startRover() {
		val position = Position(0, 0, Direction.NORTH)
		val area: Area = Area(5, 5)
		this.rover = Rover(position, area)
	}

	fun move(str: String) {
		val commands = str.toUpperCase()
		if (commands.matches(this.regex)) {
			for(command in commands){
				this.rover?.sendCommand(command)
			}
		} else {
			throw RoverRuntimeException("Invalid command.")
		}
	}
}

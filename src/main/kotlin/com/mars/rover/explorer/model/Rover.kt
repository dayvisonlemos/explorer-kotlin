package com.mars.rover.explorer.model

import com.mars.rover.explorer.domain.Direction
import com.mars.rover.explorer.exceptions.RoverRuntimeException
import com.mars.rover.explorer.factory.CommandBehavior
import com.mars.rover.explorer.factory.CommandFactory
import com.mars.rover.explorer.factory.MoveCommand

data class Rover(val position: Position, val area: Area) {

	private fun verifyBoundaries(): Boolean {
		var success = true
		when (position.direction) {
			Direction.NORTH -> success = position.y < area.getY()
			Direction.SOUTH -> success = position.y > 0
			Direction.EAST -> success = position.x < area.getX()
			Direction.WEST -> success = position.x > 0
		}
		return success
	}

	fun sendCommand(command: Char) {
		val cb: CommandBehavior = CommandFactory.getInstance(command)
		var canMove = true

		if (cb is MoveCommand) {
			canMove = this.verifyBoundaries()
		}

		if (canMove) {
			cb.sendCommand(position)
		} else {
			throw RoverRuntimeException("The robot cannot move beyond the specified area.")
		}
	}

}

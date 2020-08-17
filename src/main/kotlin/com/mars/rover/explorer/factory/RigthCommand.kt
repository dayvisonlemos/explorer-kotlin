package com.mars.rover.explorer.factory

import com.mars.rover.explorer.domain.Direction
import com.mars.rover.explorer.model.Position

class RigthCommand : CommandBehavior {
	override fun sendCommand(position: Position) {
		when (position.direction) {
			Direction.NORTH -> position.direction = Direction.EAST
			Direction.EAST -> position.direction = Direction.SOUTH
			Direction.SOUTH -> position.direction = Direction.WEST
			Direction.WEST -> position.direction = Direction.NORTH
		}
	}
}

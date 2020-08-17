package com.mars.rover.explorer.factory

import com.mars.rover.explorer.model.Position

class MoveCommand : CommandBehavior {
	override fun sendCommand(position: Position) {
		position.increase();
	}
}

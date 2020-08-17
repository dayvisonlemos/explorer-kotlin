package com.mars.rover.explorer.factory

import com.mars.rover.explorer.model.Position

interface CommandBehavior {

	fun sendCommand(position: Position)
}

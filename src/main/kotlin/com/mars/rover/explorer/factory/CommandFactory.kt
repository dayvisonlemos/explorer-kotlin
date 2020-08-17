package com.mars.rover.explorer.factory

import com.mars.rover.explorer.domain.Command


class CommandFactory {

	companion object {
		fun getInstance(c: Char): CommandBehavior {
			val command: Command = Command.lookup(c)
			var behavior: CommandBehavior? = null
			when (command) {
				Command.MOVE -> behavior = MoveCommand()
				Command.LEFT -> behavior = LeftCommand()
				Command.RIGTH -> behavior = RigthCommand()
			}
			return behavior
		}
	}


}

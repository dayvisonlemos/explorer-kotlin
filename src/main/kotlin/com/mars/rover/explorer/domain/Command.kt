package com.mars.rover.explorer.domain

import com.mars.rover.explorer.exceptions.RoverRuntimeException

enum class Command(val value: String) {
	MOVE("M"),
	LEFT("L"),
	RIGTH("R");

	companion object {
		fun lookup(c: Char): Command {
			val str = c.toString()
			var command: Command? = null
			for (cd in values()) {
				if (cd.value == str) {
					command = cd
					break
				}
			}
			if (command == null) {
				throw RoverRuntimeException("Invalid command.");
			}
			return command
		}
	}
}

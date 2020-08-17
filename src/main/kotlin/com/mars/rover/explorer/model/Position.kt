package com.mars.rover.explorer.model

import com.mars.rover.explorer.domain.Direction

data class Position(var x: Int, var y: Int, var direction: Direction) {
	fun increase() {
		if (direction == Direction.NORTH || direction == Direction.SOUTH) {
			this.y = this.y + direction.increase
		} else {
			this.x = this.x + direction.increase
		}
	}

	override fun toString(): String {
		return String.format("(%d, %d, %s)", this.x, this.y, this.direction.label)
	}
}

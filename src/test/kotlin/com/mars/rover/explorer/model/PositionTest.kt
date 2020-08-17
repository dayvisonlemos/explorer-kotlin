package com.mars.rover.explorer.model

import com.mars.rover.explorer.domain.Direction
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class PositionTest{
	@Test
	fun testIncreaseNorth() {
		val position = Position(0, 0, Direction.NORTH)
		position.increase()
		assertEquals("(0, 1, N)", position.toString())
	}

	@Test
	fun testIncreaseSouth() {
		val position = Position(0, 4, Direction.SOUTH)
		position.increase()
		assertEquals("(0, 3, S)", position.toString())
	}

	@Test
	fun testIncreaseEast() {
		val position = Position(0, 0, Direction.EAST)
		position.increase()
		assertEquals("(1, 0, E)", position.toString())
	}

	@Test
	fun testIncreaseWest() {
		val position = Position(4, 0, Direction.WEST)
		position.increase()
		assertEquals("(3, 0, W)", position.toString())
	}
}

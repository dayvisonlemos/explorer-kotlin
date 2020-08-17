package com.mars.rover.explorer.model

import com.mars.rover.explorer.domain.Direction
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class RoverTest {

	@Test
	fun testDefaultRover() {
		val rover = Rover(Position(0, 0, Direction.NORTH), Area(5, 5))
		assertEquals("(0, 0, N)", rover.position.toString())
	}

	@Test
	fun test3MovesToNorth() {
		val rover = Rover(Position(0, 0, Direction.NORTH), Area(5, 5))

		//first move
		rover.sendCommand('M')

		//second move
		rover.sendCommand('M')

		//third move
		rover.sendCommand('M')

		assertEquals("(0, 3, N)", rover.position.toString())
	}

	@Test
	fun test3MovesToEast() {
		val rover = Rover(Position(0, 0, Direction.NORTH), Area(5, 5))

		rover.sendCommand('R')

		//first move
		rover.sendCommand('M')

		//second move
		rover.sendCommand('M')

		//third move
		rover.sendCommand('M')

		assertEquals("(3, 0, E)", rover.position.toString())
	}

	/**
	 * Test 2 moves to north, 2 moves to earth, 2 moves to north, 1 move to south and 1 move to east
	 */
	@Test
	fun testFewMoves() {
		val rover = Rover(Position(0, 0, Direction.NORTH), Area(5, 5))
		rover.sendCommand('M')
		rover.sendCommand('M')
		rover.sendCommand('R')
		rover.sendCommand('M')
		rover.sendCommand('M')
		rover.sendCommand('L')
		rover.sendCommand('M')
		rover.sendCommand('M')
		rover.sendCommand('L')
		rover.sendCommand('L')
		rover.sendCommand('M')
		rover.sendCommand('L')
		rover.sendCommand('M')
		assertEquals("(3, 3, E)", rover.position.toString())
	}
}

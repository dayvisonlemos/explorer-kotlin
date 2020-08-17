package com.mars.rover.explorer.service

import com.mars.rover.explorer.domain.Direction
import com.mars.rover.explorer.exceptions.RoverRuntimeException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.String


class MissionServiceTest {
	private var missionService: MissionService? = null

	@BeforeEach
	fun beforeTest() {
		missionService = MissionService()
		missionService?.startRover()
	}

	@Test
	fun testMissionDefault() {
		assertPositionAttributes(0, 0, Direction.NORTH)
	}

	@Test
	fun testInvalidCommandToMove() {
		assertThrows<RoverRuntimeException> {
			missionService?.move("AAA")
		}
	}

	@Test
	fun testMixCommandToMove() {
		assertThrows<RoverRuntimeException> {
			missionService?.move("MAM")
		}
	}

	@Test
	fun testinvalidMixCommandToRotateMove() {
		assertThrows<RoverRuntimeException> {
			missionService?.move("MMLMLARMRRRM")
		}
	}

	@Test
	fun test2MovesNorth() {
		missionService?.move("MM")
		assertPositionAttributes(0, 2, Direction.NORTH)
	}

	@Test
	fun testMovesNorthToBound() {
		missionService?.move("MMMM")
		assertPositionAttributes(0, 4, Direction.NORTH)
	}

	@Test
	fun testMovesNorthToOutOfBoundArea() {
		assertThrows<RoverRuntimeException> {
			missionService?.move("MMMMM")
		}
	}

	@Test
	fun testMovesSouthToOutOfBoundArea() {
		assertThrows<RoverRuntimeException> {
			missionService?.move("RRM")
		}
	}

	@Test
	fun testMovesEastToOutOfBoundArea() {
		assertThrows<RoverRuntimeException> {
			missionService?.move("RMMMMM")
		}
	}

	@Test
	fun testMovesWeastToOutOfBoundArea() {
		assertThrows<RoverRuntimeException> {
			missionService?.move("LM")
		}
	}

	@Test
	fun testChalange01() {
		missionService?.move("MMRMMRMM")
		assertPositionAttributes(2, 0, Direction.SOUTH)
	}

	@Test
	fun testChalange02() {
		missionService?.move("MML")
		assertPositionAttributes(0, 2, Direction.WEST)
	}

	@Test
	fun testChalange03() {
		missionService?.move("MML")
		assertPositionAttributes(0, 2, Direction.WEST)
	}

	@Test
	fun testChalange05() {
		assertThrows<RoverRuntimeException> {
			missionService?.move("MMMMMMMMMMMMMMMMMMMMMMMM")
		}
	}

	private fun assertPositionAttributes(expectedX: Int, expectedY: Int, expectedDirection: Direction) {
		val expected = String.format("(%d, %d, %s)", expectedX, expectedY, expectedDirection.label)
		assertEquals(expected, missionService?.rover?.position.toString())
	}
}

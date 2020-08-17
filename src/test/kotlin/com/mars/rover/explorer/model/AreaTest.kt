package com.mars.rover.explorer.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class AreaTest {

	@Test
	fun testNewInstanceArea() {
		val (width, heigth) = Area(5, 10)
		assertEquals(5, width)
		assertEquals(10, heigth)
	}

	@Test
	fun testAreaAttr() {
		val area = Area(0, 0)
		area.width = 30
		area.heigth = 25
		assertEquals(30, area.width)
		assertEquals(25, area.heigth)
	}
}

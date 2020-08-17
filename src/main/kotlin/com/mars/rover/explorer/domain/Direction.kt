package com.mars.rover.explorer.domain

enum class Direction(val label: String, val increase: Int) {
	NORTH("N", 1),
	SOUTH("S", -1),
	EAST("E", 1),
	WEST("W", -1)
}

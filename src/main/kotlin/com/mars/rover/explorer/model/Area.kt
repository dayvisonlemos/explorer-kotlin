package com.mars.rover.explorer.model

data class Area(var width: Int, var heigth: Int) {

	fun getX(): Int {
		return width - 1
	}

	fun getY(): Int {
		return heigth - 1
	}
}

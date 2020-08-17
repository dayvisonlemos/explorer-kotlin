package com.mars.rover.explorer.controller

import com.mars.rover.explorer.service.MissionService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/rest")
class MissionController(val service: MissionService) {

	@GetMapping("/mars/{command}")
	fun starter(@PathVariable command: String): String {
		this.service.startRover()
		this.service.move(command)
		return this.service.rover?.position.toString();
	}

}

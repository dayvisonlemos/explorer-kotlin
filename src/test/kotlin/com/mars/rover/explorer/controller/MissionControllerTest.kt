package com.mars.rover.explorer.controller

import com.mars.rover.explorer.Application
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [Application::class])
class MissionControllerTest {

	val restPath = "/rest/mars/"

	@Autowired
	lateinit var restTemplate: TestRestTemplate;

	@Test
	fun testRotateRight() {
		val command = "MMRMMRMM"

		val response = restTemplate.getForEntity(String.format("%s/%s", restPath, command), String::class.java);

		Assertions.assertEquals(response.statusCode, HttpStatus.OK);
		Assertions.assertEquals(response.body, "(2, 0, S)");
	}

	@Test
	fun testRotateLeft() {
		val command = "MML"

		val response = restTemplate.getForEntity(String.format("%s/%s", restPath, command), String::class.java);

		Assertions.assertEquals(response.statusCode, HttpStatus.OK);
		Assertions.assertEquals(response.body, "(0, 2, W)");
	}

	@Test
	fun testInvalidCommand() {
		val command = "AAA"

		val response = restTemplate.getForEntity(String.format("%s/%s", restPath, command), String::class.java);

		Assertions.assertEquals(response.statusCode, HttpStatus.BAD_REQUEST);
		Assertions.assertEquals(response.body, "Invalid command.");
	}

	@Test
	fun testMixCommands() {
		val command = "MAM"

		val response = restTemplate.getForEntity(String.format("%s/%s", restPath, command), String::class.java);

		Assertions.assertEquals(response.statusCode, HttpStatus.BAD_REQUEST);
		Assertions.assertEquals(response.body, "Invalid command.");
	}

	@Test
	fun testInvalidPosition() {
		val command = "MMMMMMMMMMMMMMMMMMMMMMMM"

		val response = restTemplate.getForEntity(String.format("%s/%s", restPath, command), String::class.java);

		Assertions.assertEquals(response.statusCode, HttpStatus.BAD_REQUEST);
		Assertions.assertEquals(response.body, "The robot cannot move beyond the specified area.");
	}

	@Test
	fun testLowerCaseCommand() {
		val command = "rmmlm"

		val response = restTemplate.getForEntity(String.format("%s/%s", restPath, command), String::class.java);

		Assertions.assertEquals(response.statusCode, HttpStatus.OK);
		Assertions.assertEquals(response.body, "(2, 1, N)");
	}

}

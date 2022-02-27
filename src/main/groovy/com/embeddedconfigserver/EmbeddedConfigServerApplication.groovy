package com.embeddedconfigserver

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.config.server.EnableConfigServer
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@EnableConfigServer
@SpringBootApplication
class EmbeddedConfigServerApplication {

	static void main(String[] args) {
		SpringApplication.run(EmbeddedConfigServerApplication, args)
	}

}

@RefreshScope
@RestController
class Demo {

	@Autowired
	Environment env

	@GetMapping("/message")
	String demo() {
		return env.getProperty("message")
	}
}

/**
 * Get request (original value) -> http://localhost:8080/message/
 * Change message value here https://github.com/T-travis/config-repo/blob/main/config.properties
 * Post request -> http://localhost:8080/actuator/refresh
 * Get request (updated value) -> http://localhost:8080/message/
 */
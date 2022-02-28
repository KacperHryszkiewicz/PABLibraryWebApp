package com.LibraryProject.PABLibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableAutoConfiguration
//@EntityScan(basePackages = "com.LibraryProject.PABLibrary.repositories")
public class PabLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PabLibraryApplication.class, args);
	}

}

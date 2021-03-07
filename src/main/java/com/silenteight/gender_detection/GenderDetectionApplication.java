package com.silenteight.gender_detection;

import com.silenteight.gender_detection.support.FileManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GenderDetectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenderDetectionApplication.class, args);
		System.out.println(FileManager.read_file("female.txt"));
		System.out.println(FileManager.read_file("male.txt"));

	}

}

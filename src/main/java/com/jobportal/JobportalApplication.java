package com.jobportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.jobportal.model.Document;

@SpringBootApplication
@EnableConfigurationProperties({
    Document.class
})
public class JobportalApplication /*extends SpringBootServletInitializer*/ {

	public static void main(String[] args) {
		SpringApplication.run(JobportalApplication.class, args);
	}

}

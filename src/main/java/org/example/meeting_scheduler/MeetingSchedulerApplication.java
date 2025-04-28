package org.example.meeting_scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableJpaRepositories(basePackages = "org.example.meeting_scheduler.domain")
@EntityScan(basePackages = "org.example.meeting_scheduler.domain")
@SpringBootApplication
@EnableAsync
public class MeetingSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeetingSchedulerApplication.class, args);
	}

}

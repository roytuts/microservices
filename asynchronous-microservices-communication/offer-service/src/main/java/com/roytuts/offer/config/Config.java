package com.roytuts.offer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Value("${topic.name}")
	private String topicName;

	@Bean
	public NewTopic newTopic() {
		NewTopic newTopic = new NewTopic(topicName, 1, (short) 1);

		return newTopic;
	}

}

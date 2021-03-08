package io.nenodias.evento;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EventoApplication {

	@Value("${queue.events.name}")
	private String eventQueue;

	public static void main(String[] args) {
		SpringApplication.run(EventoApplication.class, args);
	}

	@Bean
	public Queue queue(){
		Boolean durable = true;
		return new Queue(eventQueue, durable);
	}

}

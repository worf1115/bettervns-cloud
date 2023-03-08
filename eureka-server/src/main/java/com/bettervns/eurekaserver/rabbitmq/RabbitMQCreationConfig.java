package com.bettervns.eurekaserver.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQCreationConfig {

    public static final String QUEUE_FOR_STUDENTS_NAME = "adminToStudents";

    @Bean
    public ConnectionFactory connectionFactory() {
        return new CachingConnectionFactory("localhost");
    }

    @Bean
    public Queue myQueue(){
        return new Queue(QUEUE_FOR_STUDENTS_NAME);
    }
}
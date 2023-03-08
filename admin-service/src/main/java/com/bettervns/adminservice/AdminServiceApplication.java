package com.bettervns.adminservice;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class AdminServiceApplication {

    private final static String QUEUE_NAME = "queue";

    public  static void main(String[] args) throws IOException, TimeoutException {
        SpringApplication.run(AdminServiceApplication.class, args);
        /*ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        //factory.setPort(15672);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,
                false,
                false,
                false,
                null);
        String message = "Welcome to RabbitMQ";
        channel.basicPublish("", QUEUE_NAME,null, message.getBytes("UTF-8"));
        System.out.println("[!] Sent '" + message + "'");
        channel.close();
        connection.close();*/
    }

    @Bean
    public DataSource adminsDataSource(){
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setDriverClassName("com.mysql.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://localhost:3306/admins?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true");
        datasource.setUsername("danyil");
        datasource.setPassword("Grisha_sobaka1");
        return datasource;
    }

    @Bean
    public JdbcTemplate adminsJdbcTemplate(){
        return new JdbcTemplate(adminsDataSource());
    }
}
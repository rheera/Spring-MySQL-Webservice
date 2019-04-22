package com.mysqlwebservices.mysqlws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MysqlwsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysqlwsApplication.class, args);
    }

}

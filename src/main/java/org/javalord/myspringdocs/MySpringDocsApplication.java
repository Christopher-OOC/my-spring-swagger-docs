package org.javalord.myspringdocs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MySpringDocsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringDocsApplication.class, args);
    }

}

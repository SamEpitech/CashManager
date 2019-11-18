package eu.epitech.cashmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class CashmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CashmanagerApplication.class, args);
    }

}

package de.hbrs.ia;

import de.hbrs.ia.repository.SalesManRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories({"de.hbrs.ia.repository"})
@SpringBootApplication
public class MainApplication  {

    public static void main(String[] args) {

        SpringApplication.run(MainApplication.class, args);
    }
}
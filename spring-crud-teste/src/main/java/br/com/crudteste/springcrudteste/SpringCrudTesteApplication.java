package br.com.crudteste.springcrudteste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "br.com.crudteste.springcrudteste")
@EntityScan(basePackages = "br.com.crudteste.springcrudteste.entity")
public class SpringCrudTesteApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCrudTesteApplication.class, args);
    }

}



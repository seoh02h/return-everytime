package com.seohyuni.returneverytimeserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ReturnEverytimeServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(ReturnEverytimeServerApplication.class, args);
  }

}

package com.itlize.korera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KoreraApplication{

    public static void main(String[] args) {
        SpringApplication.run(KoreraApplication.class, args);
    }
}
//package com.itlize.korera;
//
//import com.itlize.korera.entity.User;
//import com.itlize.korera.repository.UserRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//
//@SpringBootApplication
//public class KoreraApplication {
//
//    private static final Logger log = LoggerFactory.getLogger(KoreraApplication.class);
//
//    public static void main(String[] args) {
//        SpringApplication.run(KoreraApplication.class);
//    }
//
//    @Bean
//    public CommandLineRunner demo(UserRepository repository) {
//        return (args) -> {
//            // save a few User
//            repository.save(new User("Jack", "Bauer", "aaa@gmail.com","12345"));
//            repository.save(new User("Chloe", "O'Brian","bbb@gmail.com","5678"));
//            repository.save(new User("Kim", "Bauer","ccc@gmail.com","sdfgh"));
//
//
//            // fetch all User
//            log.info("Customers found with findAll():");
//            log.info("-------------------------------");
//            for (User customer : repository.findAll()) {
//                log.info(customer.toString());
//            }
//            log.info("");
//
//            // fetch an individual User by ID
////            User customer = repository.findById(1L);
////            log.info("Customer found with findById(1L):");
////            log.info("--------------------------------");
////            log.info(customer.toString());
////            log.info("");
//
//            // fetch customers by last name
//            log.info("Customer found with findByLastName('Bauer'):");
//            log.info("--------------------------------------------");
//            repository.findByLastName("Bauer").forEach(bauer -> {
//                log.info(bauer.toString());
//            });
//            // for (Customer bauer : repository.findByLastName("Bauer")) {
//            //  log.info(bauer.toString());
//            // }
//            log.info("");
//        };
//    }
//
//
//}


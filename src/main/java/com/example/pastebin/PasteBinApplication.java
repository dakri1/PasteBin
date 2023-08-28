package com.example.pastebin;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.ReactiveRedisTemplate;

@SpringBootApplication
public class PasteBinApplication {

    public static void main(String[] args) {
        SpringApplication.run(PasteBinApplication.class, args);
    }
//
//
//
//    @Bean
//    ApplicationRunner list (ReactiveRedisTemplate <String, String> template){
//        return args -> {
//            var listTemplate = template.opsForList();
//            var listName = "spring-team";
//            var push = listTemplate.leftPushAll(listName, "George", "Andrey");
//            push.thenMany(listTemplate.leftPop(listName)).doOnNext(System.out::println)
//                    .thenMany(listTemplate.leftPop(listName))
//                    .doOnNext(System.out::println)
//                    .subscribe();
//        };
//    }

}

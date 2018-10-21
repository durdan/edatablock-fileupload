package com;

import com.edatablock.fileupload.StorageProperties;
import com.edatablock.fileupload.StorageService;
import com.edatablock.rpaclient.RpaJwtClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class Application {


    public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
//        ApplicationContext app = SpringApplication.run(Application .class, args);//init the context

       // getWordWithZone();

    }

    @Bean
    CommandLineRunner init(StorageService storageService,RpaJwtClient rpaJwtClient) {
        String username = "admin";
        String password = "admin";
        String url = "http://localhost:9000/api/authenticate";
        String url2 = "http://localhost:9000/api/clients/";

//        String authorizationString = rpaJwtClient.postLogin(username, password);
//
//        System.out.println("Authorization String=" + authorizationString);

        // Call REST API:
       // rpaJwtClient.callRPARESTApi(url2, authorizationString);

        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }


}

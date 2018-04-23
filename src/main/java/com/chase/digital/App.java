package com.chase.digital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * TODO - Class definition
 *
 * @author Nate Vardell
 * @since 3/28/2018
 */
@SpringBootApplication
@PropertySource("classpath:host.properties")
public class App {

    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }

}

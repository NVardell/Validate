package com.digital.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO - Class definition
 *
 * @author Nate Vardell
 * @since 3/28/2018
 */
@RestController
public class HomeController {

    @RequestMapping("/health")
    public String health() {
        return "HC Health Mapping";
    }
}

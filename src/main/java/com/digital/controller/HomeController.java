package com.digital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TODO - Class definition
 *
 * @author Nate Vardell
 * @since 3/28/2018
 */
@Controller
public class HomeController {

    @RequestMapping(value="/")
    public String routeToHome(){
        return "forward:index.html";
    }

    @RequestMapping("/health")
    public String health() {
        return "HC Health Mapping";
    }
}
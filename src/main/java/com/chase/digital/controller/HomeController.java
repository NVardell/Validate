package com.chase.digital.controller;

import com.chase.digital.model.Request;
import com.chase.digital.repo.RequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO - Class definition
 *
 * @author Nate Vardell
 * @since 3/28/2018
 */
@RestController
public class HomeController {

    @Autowired
    private RequestRepo requestRepo;

    @RequestMapping(value = "requests", method = RequestMethod.GET)
    public List<Request> list() {
        return requestRepo.findAll();
    }

    @RequestMapping(value = "requests", method = RequestMethod.POST)
    public Request create(@RequestBody Request request) {
        return requestRepo.saveAndFlush(request);
    }

    @RequestMapping("/health")
    public String health() {
        return "HC Health Mapping";
    }
}

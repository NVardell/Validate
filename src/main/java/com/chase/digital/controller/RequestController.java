package com.chase.digital.controller;

import com.chase.digital.model.Request;
import com.chase.digital.repo.RequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * TODO - Add Definition
 *
 * @author Nate Vardell
 * @since 4/21/2018
 */
@RestController
public class RequestController {

    @Autowired
    private RequestRepo requestRepo;

    @RequestMapping(value = "/requests", method = RequestMethod.GET)
    public List<Request> list() {
        return requestRepo.findAll();
    }

    @RequestMapping(value = "/requests", method = RequestMethod.POST)
    public Request create(@RequestBody Request request) {
        return requestRepo.saveAndFlush(request);
    }

}

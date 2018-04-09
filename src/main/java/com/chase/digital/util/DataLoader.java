package com.chase.digital.util;

import com.chase.digital.model.Application;
import com.chase.digital.repo.ApplicationRepo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO - Class definition
 *
 * @author Nate Vardell
 * @since 4/8/2018
 */
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    // Saw this in a different example...  Maybe it will be better than this class.... or cleaner...
//    @Override
//    public void run(String... args) throws Exception {
        //Code to run at application startup
//    }


    private Logger log = Logger.getLogger(DataLoader.class);

    @Autowired
    private ApplicationRepo applicationRepo;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        Set apps = new HashSet<Application>(){{
            add(new Application("GWS"));
            add(new Application("GWMOL"));
            add(new Application("GWMOB"));
            add(new Application("GWCSR"));
            add(new Application("GWSUTIL"));
        }};
//        applicationRepo.sa

    }
}

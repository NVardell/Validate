package com.digital.repo;

import com.digital.model.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

/**
 * TODO - Class definition
 *
 * @author Nate Vardell
 * @since 3/28/2018
 */
@DataJpaTest
@SpringBootTest
@RunWith(SpringRunner.class)
public class ApplicationRepoTest {

    @Autowired
    private ApplicationRepo appRepo;

    @Test
    public void testFindAll() {
        List<Application> apps = appRepo.findAll();
        assertThat(apps.size(), is(greaterThanOrEqualTo(0)));
        assertThat(apps.size(), is(0));
    }
}

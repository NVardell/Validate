package com.digital.repo;

import com.digital.model.Request;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

import java.util.List;

/**
 * TODO - Class definition
 *
 * @author Nate Vardell
 * @since 3/28/2018
 */
@DataJpaTest
@RunWith(SpringRunner.class)
public class RequestRepoTest {

    @Autowired
    private RequestRepo requestRepo;

    @Test
    public void testFindAll() {
        List<Request> requests = requestRepo.findAll();
        assertThat(requests.size(), is(greaterThanOrEqualTo(0)));
    }
}

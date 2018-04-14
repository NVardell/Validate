package com.chase.digital.repo;

import com.chase.digital.model.App;
import com.chase.digital.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * TODO - Class definition
 *
 * @author Nate Vardell
 * @since 4/8/2018
 */
public interface RequestRepo extends JpaRepository<Request, Long> {
}

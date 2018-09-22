package com.digital.repo;

import com.digital.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TODO - Class definition
 *
 * @author Nate Vardell
 * @since 3/28/2018
 */
public interface ApplicationRepo extends JpaRepository<Application, Long> {
}

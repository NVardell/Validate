package com.digital.repo;

import com.digital.model.CommandType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TODO - Class definition
 *
 * @author Nate Vardell
 * @since 4/8/2018
 */
public interface CommandTypeRepo extends JpaRepository<CommandType, Long> {
}

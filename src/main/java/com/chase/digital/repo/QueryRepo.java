package com.chase.digital.repo;

import com.chase.digital.model.App;
import com.chase.digital.model.Query;
import com.chase.digital.model.Region;
import com.chase.digital.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * TODO - Class definition
 *
 * @author Nate Vardell
 * @since 4/8/2018
 */
public interface QueryRepo extends JpaRepository<Query, Long> {
    List<Query> findByApp(App app);
    List<Query> findByType(Type type);
    List<Query> findByRegion(Region region);
}

package com.chase.digital.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * TODO - Class definition
 *
 * @author Nate Vardell
 * @since 4/8/2018
 */
@Entity
public class Request {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name="request_queries",
            joinColumns = { @JoinColumn(name = "request_id") },
            inverseJoinColumns = { @JoinColumn(name = "query_id") })
    private Set<Query> queries = new HashSet<>();

    public Request() {
    }

    public Request(Long id, Set<Query> queries) {
        this.id = id;
        this.queries = queries;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Query> getQueries() {
        return queries;
    }

    public void setQueries(Set<Query> queries) {
        this.queries = queries;
    }
}

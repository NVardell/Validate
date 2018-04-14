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
public class Query {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = { CascadeType.PERSIST, CascadeType.MERGE },
            mappedBy = "queries")
    private Set<Request> requests = new HashSet<>();

    private App app;
    private Type type;
    private Region region;
    private String searchValue;
    private String expectedValue;

    public Query() {
    }

    public Query(Long id, Set<Request> requests, App app, Type type, Region region, String searchValue, String expectedValue) {
        this.id = id;
        this.requests = requests;
        this.app = app;
        this.type = type;
        this.region = region;
        this.searchValue = searchValue;
        this.expectedValue = expectedValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Request> getRequests() {
        return requests;
    }

    public void setRequests(Set<Request> requests) {
        this.requests = requests;
    }

    public App getApp() {
        return app;
    }

    public void setApp(App app) {
        this.app = app;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public String getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(String expectedValue) {
        this.expectedValue = expectedValue;
    }
}

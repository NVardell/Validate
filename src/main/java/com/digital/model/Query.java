package com.digital.model;

import javax.persistence.*;

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

    @OneToOne
    private Application app;

    @OneToOne
    @JoinColumn
    private CommandType cmdType;
}

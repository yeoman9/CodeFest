package com.spring.bean;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -2737994233035769305L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLE_SEQ")
	@SequenceGenerator(sequenceName = "role_seq", allocationSize = 1, name = "ROLE_SEQ")
	private Long id;

    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}

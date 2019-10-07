package com.spring.bean;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "appuser")
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6859572909566176473L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
	@SequenceGenerator(sequenceName = "user_seq", allocationSize = 1, name = "USER_SEQ")
	private Long id;

    private String username;
    
    private String firstName;
    
    private String lastName;
    
    @Column(unique=true)
    private String mobileNumber;
    
    private String email;
    
    private String password;
    
    @Transient
    private String passwordConfirm;

    @JsonIgnore
    @ManyToMany
    @JoinTable
    private Set<Role> roles;
    
    private String createdBy;
    
    private Date created;
    
    private Date updated;
    
    @PrePersist
    protected void onCreate() {
      created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
      updated = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
}

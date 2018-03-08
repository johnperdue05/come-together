package com.johnperdue.cometogether.models;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private int id;
    @Column(name = "username")
    @NotEmpty(message = "Please provide a username")
    private String username;
    /*@Column(name = "orgname")
    @NotEmpty(message = "Please provide your organization's name")
    private String orgName;
    @OneToOne
    @JoinTable(name = "user_address", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "address_id"))
    private Address address;
    @Column(name = "ein")
    @NotEmpty(message = "Please provide a valid EIN")
    private Long EIN; */
    @Column(name = "password")
    @Length(min = 8, max = 16, message = "Passwords must be between 8 and 16 characters long")
    @NotEmpty(message = "Please provide a password")
    @Transient
    private String password;
    @Column(name = "email")
    @Email(message = "Please provide a valid email address")
    @NotEmpty(message = "Please provide an email address")
    private String email;
    /* @Column(name = "account_manager")
            private String accountManager;*/
    /*@OneToMany
    @JoinColumn(name = "author_id")
    private List<Project> projects;
       @OneToMany
        @JoinTable(name = "user_proposals", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "proposal_id"))
        private List<Proposal>proposals; */
    @Column(name = "active")
    private boolean active;

    /* @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles; */

    public User(int userId, String username, /*String orgName, Address address, Long EIN, */String password, String email){
        this.id = userId;
        this.username = username;
        /*this.orgName = orgName;
        this.address = address;
        this.EIN = EIN;*/
        this.password = password;
        this.email = email;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /*public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getEIN() {
        return EIN;
    }

    public void setEIN(Long EIN) {
        this.EIN = EIN;
    }*/

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*public String getAccountManager() {
        return accountManager;
    }

    public void setAccountManager(String accountManager) {
        this.accountManager = accountManager;
    }*/

    public int getId() {
        return id;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    /* public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Role> getRoles() {
        return roles;
    } */

    /*public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }*/

}
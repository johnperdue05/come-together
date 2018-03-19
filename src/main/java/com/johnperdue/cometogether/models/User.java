package com.johnperdue.cometogether.models;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;
    @Column(name = "username")
    @NotEmpty(message = "Please provide a username")
    private String username;
    @Column(name = "orgName")
    @NotEmpty(message = "Please provide your organization's name")
    private String orgName;
    @Column(name = "address_line_1")
    private String addressLine1;
    @Column(name = "address_line_2")
    private String addressLine2;
    @Column(name="city")
    private String city;
    @Column(name = "state")
    private State state;
    @Column(name = "zip")
    private Integer zip;
    @Column(name = "EIN")
    @NotNull(message = "Please provide a valid EIN")
    private Long EIN;
    @Column(name = "password")
    @Length(min = 8, max = 16, message = "Passwords must be between 8 and 16 characters long")
    @NotEmpty(message = "Please provide a password")
    private String password;
    @Column(name = "email")
    @Email(message = "Please provide a valid email address")
    @NotEmpty(message = "Please provide an email address")
    private String email;
    @Column(name = "accountManager")
    private String accountManager;
    @OneToMany
    @JoinColumn(name = "author_id")
    private List<Project> projects = new ArrayList<>();
    /*@OneToMany
    @JoinTable(name = "user_proposals", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "proposal_id"))
    private List<Proposal>proposals; */
    @Column(name = "active")
    private boolean active;

    /* @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles; */

    public User(int userId, String username, String orgName, /*long EIN, */String password, String email){
        this.id = userId;
        this.username = username;
        this.orgName = orgName;
        /*this.EIN = EIN;*/
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

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Long getEIN() {
        return EIN;
    }

    public void setEIN(Long EIN) {
        this.EIN = EIN;
    }

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

    public String getAccountManager() {
        return accountManager;
    }

    public void setAccountManager(String accountManager) {
        this.accountManager = accountManager;
    }

    public int getId() {
        return id;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }



    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }


    /* public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Role> getRoles() {
        return roles;
    } */

    public List<Project> getProjects() {
        return projects;
    }

    public void addProject(Project project) {
        this.projects.add(project);
    }

}
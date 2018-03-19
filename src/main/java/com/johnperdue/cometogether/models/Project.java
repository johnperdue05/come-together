package com.johnperdue.cometogether.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue
    @Column(name = "project_id")
    private int id;
    //The userId of the user who created this Project
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
    @Column(name = "title")
    @NotEmpty(message = "Please enter a title for your project")
    private String title;
    /* @Column(name = "category")
    private ProjectCategory projectCategory; */
    @Column(name = "description")
    @NotEmpty(message = "Please enter a description of this project")
    private String description;
    /*@Column(name = "needs")
    @NotEmpty(message = "Please describe the needs you have in meeting this project")
    private String needs;
    @OneToMany
    @JoinTable(name = "proposals", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "proposal_id"))
    private List<Proposal> proposals;*/

    public Project(int id, User author, String title, /*ProjectCategory projectCategory, */ String description) {
        this.id = id;
        this.author = author;
        this.title = title;
        /*this.projectCategory = projectCategory; */
        this.description = description;
    }

    public Project() {
    }

    public int id() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*public String getNeeds() {
        return needs;
    }

    public void setNeeds(String needs) {
        this.needs = needs;
    }

    public ProjectCategory getProjectCategory() {
        return projectCategory;
    }

    public void setProjectCategory(ProjectCategory projectCategory) {
        this.projectCategory = projectCategory;
    } */
    public User getAuthor() {
        return author;
    }
    public void setAuthor(User author) {
        this.author = author;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}

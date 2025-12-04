package com.webdynamo.AuthSysOne.model;

import jakarta.persistence.*;

/**
 * This class represents a User entity in the application.
 * It maps to the "users" table in the database.
 *
 * @Entity: Specifies that the class is an entity and is mapped to a database table.
 * @Table(name = "users"): Specifies the name of the database table to be used for mapping.
 */
@Entity
@Table(name = "users")
public class Users {

    /**
     * @Id: Specifies the primary key of an entity.
     * @GeneratedValue(strategy = GenerationType.IDENTITY): Indicates that the persistence provider
     * must assign primary keys for the entity using a database identity column.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;

    // Default constructor is required by JPA
    public Users() {
    }

    // Parameterized constructor for easy object creation
    public Users(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    // Getters and Setters allow access and modification of private fields

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

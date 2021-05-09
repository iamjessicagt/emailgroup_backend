package org.mxcrossings.emailgroup.model;

import javax.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "user")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters.")
    @NotBlank(message = "Name is required.")
    private String name;

    @NotBlank(message = "Please provide a valid contact email.")
    @Email
    @Column(unique = true)
    private String email;

    @NotNull
    private String username;

//    research maven dependency password encoder!!!
//    https://maven.apache.org/guides/mini/guide-encryption.html
//    @NotNull
//    private String pwhash;

//    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    //add getters and setters

    public UserEntity() {
    }

    public UserEntity(String name, String email, String username) {
        this.name = name;
        this.email = email;
        this.username = username;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
package org.mxcrossings.emailgroup.model;

import org.springframework.format.annotation.DateTimeFormat;

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

    @NotBlank(message = "Please provide a valid contact email.")
    @Email
    @Column(unique = true)
    private String email;

    @NotNull
    private String password;

    @Size(min = 3, max = 50)
    @NotBlank(message = "First name is required.")
    private String firstName;

    @Size(min = 3, max = 50)
    @NotBlank(message = "Last name is required.")
    private String lastName;

    @NotBlank
    @Column(unique = true)
    private String phoneNumber;

    @NotBlank
    @DateTimeFormat
    @Column(unique = true)
    private String birthday;

    private String token;

//    research maven dependency password encoder!!!
//    https://maven.apache.org/guides/mini/guide-encryption.html


//    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    //add getters and setters


    public UserEntity() {
    }

    public UserEntity(String email, String password, String firstName, String lastName, String phoneNumber, String birthday, String token) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthday='" + birthday + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
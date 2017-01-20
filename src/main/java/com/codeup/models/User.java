package com.codeup.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Austin on 1/17/17.
 */

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "User must have a username.")
    @Size(min = 4, message = "A password must be at least 4 characters.")
    private String username;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "User must have a valid email.")
    @Email(message = "Please provide a valid email address. Example@Example.com")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "Please enter a password.")
    @Size(min = 5, message = "A password must be at least 5 characters.")
    private String password;

    @Column(name = "home_zip")
    private String homeZip;

    @OneToMany(mappedBy = "user")
    private List<TrystRanking> trystRankings;

    public User() {
    }

    public User(User user) {
        id = user.id;
        email = user.email;
        username = user.username;
        password = user.password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHomeZip() {
        return homeZip;
    }

    public void setHomeZip(String homeZip) {
        this.homeZip = homeZip;
    }

    public List<TrystRanking> getTrystRankings() {
        return trystRankings;
    }

    public void setTrystRankings(List<TrystRanking> trystRankings) {
        this.trystRankings = trystRankings;
    }
}

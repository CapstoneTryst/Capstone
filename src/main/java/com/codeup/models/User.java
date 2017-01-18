package com.codeup.models;

import javax.persistence.*;
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
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
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

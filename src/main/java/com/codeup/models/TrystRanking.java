package com.codeup.models;

import javax.persistence.*;


/**
 * Created by Austin on 1/17/17.
 */

@Entity
@Table(name = "tryst_rankings")
public class TrystRanking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private DateCategory dateCategory;

    @Column(name = "yelp_id")
    private String yelpId;

    @Column
    private int rating;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DateCategory getDateCategory() {
        return dateCategory;
    }

    public void setDateCategory(DateCategory dateCategory) {
        this.dateCategory = dateCategory;
    }

    public String getYelpId() {
        return yelpId;
    }

    public void setYelpId(String yelpId) {
        this.yelpId = yelpId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

package com.codeup.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Austin on 1/17/17.
 */

@Entity
@Table(name = "date_categories")
public class DateCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, name ="date_type")
    private String dateType;

    @OneToMany(mappedBy = "dateCategory")
    private List<TrystRanking> trystRankings;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType;
    }

    public List<TrystRanking> getTrystRankings() {
        return trystRankings;
    }

    public void setTrystRankings(List<TrystRanking> trystRankings) {
        this.trystRankings = trystRankings;
    }
}

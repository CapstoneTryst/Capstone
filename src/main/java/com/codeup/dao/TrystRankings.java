package com.codeup.dao;

import com.codeup.models.TrystRanking;
import com.codeup.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Austin on 1/17/17.
 */
public interface TrystRankings extends CrudRepository<TrystRanking, Long> {

    List<TrystRanking> findByUser(User user);

    TrystRanking findByUserIdAndRatingAndYelpId(User user, int rating, String yelpId);

}

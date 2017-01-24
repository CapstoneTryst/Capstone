package com.codeup.dao;

import com.codeup.models.DateCategory;
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

    TrystRanking findByUserIdAndRatingAndYelpId(long userId, int rating, String yelpId);
    TrystRanking findByUserIdAndDateCategoryIdAndYelpId(long userId, long dateCategoryId, String yelpId);

    List<TrystRanking> findAllByDateCategory(DateCategory category);

    long countByYelpIdAndDateCategoryIdAndRating(String yelpId, long dateCategoryId, int rating);
}

package com.codeup.dao;

import com.codeup.models.TrystRanking;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Austin on 1/17/17.
 */
public interface TrystRankings extends CrudRepository<TrystRanking, Long> {
}

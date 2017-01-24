package com.codeup.dao;

import com.codeup.models.DateCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by Austin on 1/17/17.
 */
public interface DateCategories extends CrudRepository<DateCategory, Long> {
    List<DateCategory> findAll();
}

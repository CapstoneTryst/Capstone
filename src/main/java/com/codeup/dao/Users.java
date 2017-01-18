package com.codeup.dao;

import com.codeup.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Austin on 1/17/17.
 */
public interface Users extends CrudRepository<User, Long> {

}

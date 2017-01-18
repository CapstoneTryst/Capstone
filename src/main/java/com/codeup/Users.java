package com.codeup;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Austin on 1/17/17.
 */
public interface Users extends CrudRepository<User, Long> {

}

package com.esliceu.dwes.boot.dao;

import com.esliceu.dwes.boot.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xavi on 23/02/17.
 */
@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);
}

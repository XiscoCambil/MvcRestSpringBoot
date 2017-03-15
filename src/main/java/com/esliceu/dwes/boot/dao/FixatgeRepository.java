package com.esliceu.dwes.boot.dao;

import com.esliceu.dwes.boot.model.Fixatge;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by blackwidow on 2/03/17.
 */
@Repository
public interface FixatgeRepository extends CrudRepository<Fixatge,Long> {
}

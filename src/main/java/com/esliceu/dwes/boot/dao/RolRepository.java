package com.esliceu.dwes.boot.dao;

import com.esliceu.dwes.boot.model.Rol;
import com.esliceu.dwes.boot.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by blackwidow on 2/03/17.
 */
@Repository
public interface RolRepository extends CrudRepository<Rol,Long> {
    Rol findByRolName(String rolName);
}

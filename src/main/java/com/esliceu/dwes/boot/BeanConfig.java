package com.esliceu.dwes.boot;

import com.esliceu.dwes.boot.model.Fixatge;
import com.esliceu.dwes.boot.model.Rol;
import com.esliceu.dwes.boot.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by xavi on 23/02/17.
 */
@Configuration
public class BeanConfig {

    @Bean
    @Scope(value = "prototype")
    public User user(){
        return new User();
    }

    @Bean
    @Scope(value = "prototype")
    public Rol rol(){
        return new Rol();
    }

    @Bean
    @Scope(value = "prototype")
    public Fixatge fixatge(){
        return new Fixatge();
    }

}

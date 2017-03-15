package com.esliceu.dwes.boot;

import com.esliceu.dwes.boot.dao.FixatgeRepository;
import com.esliceu.dwes.boot.dao.RolRepository;

import com.esliceu.dwes.boot.dao.UserRepository;
import com.esliceu.dwes.boot.model.Fixatge;
import com.esliceu.dwes.boot.model.Rol;
import com.esliceu.dwes.boot.model.Tipus_Fixatge_Name;
import com.esliceu.dwes.boot.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xavi on 23/02/17.
 */
@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) { SpringApplication.run(Application.class);}

    @Bean
    public CommandLineRunner demo(UserRepository repository, RolRepository rolRepository, FixatgeRepository fp) {

        return (args) -> {

            // save a couple of customersparams
            Rol admin = new Rol("Adminstrador","adminsitrador de la pagina web");
            Rol profesor = new Rol("Professor","profesor de el colegio es liceu");

            User u1 = new User("paco", "reno","usuari1","contraseña");
            User u2 = new User("Usuario2", "Bauer","Jackito","contraseña");

            rolRepository.save(admin);
            rolRepository.save(profesor);

            List<Rol> roles = new ArrayList<>();
            List<Rol> roles2 = new ArrayList<>();

            roles.add(admin);
            roles.add(profesor);
            roles2.add(profesor);

            u1.setRoles(roles);
            u2.setRoles(roles2);

            List<Fixatge> fixatges = new ArrayList<>();
            List<Fixatge> fixatges2 = new ArrayList<>();

            Fixatge fixatge = new Fixatge(1489079900, Tipus_Fixatge_Name.ENTRADA);
            Fixatge fixatge2 = new Fixatge(1489079422, Tipus_Fixatge_Name.SALIDA);

            fp.save(fixatge);
            fp.save(fixatge2);
            fixatges.add(fixatge);
            fixatges2.add(fixatge2);

            fixatge = new Fixatge(1489079900, Tipus_Fixatge_Name.SALIDA);
            fixatge2 = new Fixatge(1489079122, Tipus_Fixatge_Name.ENTRADA);

            fp.save(fixatge);
            fp.save(fixatge2);

            fixatges.add(fixatge);
            fixatges2.add(fixatge2);

            u1.setFixatges(fixatges);
            u2.setFixatges(fixatges2);

            repository.save(u1);
            repository.save(u2);

        };

    }

}

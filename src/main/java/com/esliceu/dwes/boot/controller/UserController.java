package com.esliceu.dwes.boot.controller;

import com.esliceu.dwes.boot.model.Tipus_Fixatge_Name;
import com.esliceu.dwes.boot.dao.FixatgeRepository;
import com.esliceu.dwes.boot.dao.UserRepository;
import com.esliceu.dwes.boot.model.Fixatge;
import com.esliceu.dwes.boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by xavi on 23/02/17.
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRep;

    @Autowired
    private Fixatge fixatge;

    @Autowired
    private User user;

    @Autowired
    private FixatgeRepository fitRep;

    @RequestMapping("/FindAllUsers")
    public List<User> findAllUsers(){
        return (List<User>) userRep.findAll();
    }

    @RequestMapping("/FindUserByDateAndUsername")
    public List<User> findUserByDateAndUsername(@RequestParam(required = true) long dateTo,@RequestParam(required = true) long dateFrom, @RequestParam(required = false) List<String> users ){
        User user;
        List<User> allUsers = new ArrayList<>();
        List<User> usersList = new ArrayList<>();
        List<Fixatge> fixatges = new ArrayList<>();

        if(users == null){
            allUsers = (List<User>) userRep.findAll();
            for (int i = 0; i < allUsers.size(); i++) {
                if(allUsers.get(i).getFixatges() != null) {
                    for (int j = 0; j < allUsers.get(i).getFixatges().size() ; j++) {
                        if(allUsers.get(i).getFixatges().get(j).getDate() >= dateTo
                                && allUsers.get(i).getFixatges().get(j).getDate() <= dateFrom){
                            fixatges.add(allUsers.get(i).getFixatges().get(j));
                        }
                    }
                    if(fixatges.size() != 0){
                        allUsers.get(i).setFixatges(fixatges);
                        usersList.add(allUsers.get(i));
                    }
                    fixatges = new ArrayList<>();
                }
            }
        }else {
            for (int i = 0; i < users.size(); i++) {
                user = userRep.findByUsername(users.get(i));
                if (user.getFixatges().size() != 0) {
                    for (int j = 0; j < user.getFixatges().size(); j++) {
                        if (user.getFixatges().get(j).getDate() >= dateTo
                                && user.getFixatges().get(j).getDate() <= dateFrom) {
                            fixatges.add(user.getFixatges().get(j));
                        }
                    }
                    if(fixatges.size() != 0){
                        user.setFixatges(fixatges);
                        usersList.add(user);
                    }
                    fixatges = new ArrayList<>();
                }
            }
        }
        return usersList;
    }

    @RequestMapping("/FindUserByUsername")
    public User findByUsername(@RequestParam String username){
        return userRep.findByUsername(username);
    }

    @RequestMapping(value = "/InsertTick", method = RequestMethod.POST)
    public Fixatge insertTick(@RequestParam String username,@RequestParam long date){

        user = userRep.findByUsername(username);
        List<Fixatge> fixatges = user.getFixatges();

        if(fixatges.get(0).getTipusFixatge() == Tipus_Fixatge_Name.ENTRADA){
            fixatge = new Fixatge(date,Tipus_Fixatge_Name.SALIDA);
        }else{
            fixatge = new Fixatge(date,Tipus_Fixatge_Name.ENTRADA);
        }

        fitRep.save(fixatge);
        fixatges.add(fixatge);
        user.setFixatges(fixatges);
        userRep.save(user);
        return fixatge;

    }



}

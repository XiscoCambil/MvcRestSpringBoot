package com.esliceu.dwes.boot.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by blackwidow on 2/03/17.
 */
@Entity
public class Fixatge implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long date;

    private Tipus_Fixatge_Name tipusFixatge;

    public Fixatge(){

    }

    public Fixatge(long date,Tipus_Fixatge_Name tipus_fixatge) {
        this.date = date;
        this.tipusFixatge = tipus_fixatge;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDate() {return date;}

    public void setDate(long date) {
        this.date = date;
    }

    public Tipus_Fixatge_Name getTipusFixatge() {return tipusFixatge;}

    public void setTipusFixatge(Tipus_Fixatge_Name tipusFixatge) {this.tipusFixatge = tipusFixatge;}

}

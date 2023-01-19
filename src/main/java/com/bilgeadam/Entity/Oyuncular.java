package com.bilgeadam.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Oyuncular {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String oyuncularAdi;
    private Boolean oodulVarMi;
    private String oOdulAdi;

    public Oyuncular() {
    }

    public Oyuncular(String adi, Boolean odulVarMi, String odulAdi) {
        this.oyuncularAdi = adi;
        this.oodulVarMi = odulVarMi;
        this.oOdulAdi = odulAdi;
    }

    public Oyuncular(String adi, Boolean odulVarMi) {
        this.oyuncularAdi = adi;
        this.oodulVarMi = odulVarMi;
    }
}

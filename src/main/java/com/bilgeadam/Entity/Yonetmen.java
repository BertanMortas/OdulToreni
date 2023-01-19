package com.bilgeadam.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Yonetmen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String YonetmenAdi;
    private Boolean yodulVarMi;
    private String yOdulAdi;
    //private Film film;

    public Yonetmen() {
    }

    public Yonetmen(String adi, Boolean odulVarMi, String odulAdi) {
        this.YonetmenAdi = adi;
        this.yodulVarMi = odulVarMi;
        this.yOdulAdi = odulAdi;
    }

    public Yonetmen(String adi, Boolean odulVarMi) {
        this.YonetmenAdi = adi;
        this.yodulVarMi = odulVarMi;
    }
}

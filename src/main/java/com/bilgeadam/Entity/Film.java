package com.bilgeadam.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean odulVarMi;
    private String filmAdi;
    private String odulAdi;
    @ManyToOne(cascade = CascadeType.ALL)
    private Yonetmen yonetmen;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Oyuncular> oyuncularList;
    @OneToOne(cascade = CascadeType.ALL)
    private Kategori kategori;

    public Film() {
    }

    public Film(Integer id, Boolean odulVarMi, String filmAdi, Yonetmen yonetmen, List<Oyuncular> oyuncularList, Kategori kategori) {
        this.id = id;
        this.odulVarMi = odulVarMi;
        this.filmAdi = filmAdi;

        this.yonetmen = yonetmen;
        this.oyuncularList = oyuncularList;
        this.kategori = kategori;
    }

    public Film(Boolean odulVarMi, String filmAdi, String odulAdi, Yonetmen yonetmen, List<Oyuncular> oyuncularList, Kategori kategori) {
       // if (this.odulVarMi.equals(true)){
            this.odulVarMi = odulVarMi;
            this.filmAdi = filmAdi;
            this.odulAdi = odulAdi;
            this.yonetmen = yonetmen;
            this.oyuncularList = oyuncularList;
            this.kategori = kategori;
       // }else {

       // }

    }

    public Film(Boolean odulVarMi, String filmAdi, Yonetmen yonetmen, List<Oyuncular> oyuncularList, Kategori kategori) {
        this.odulVarMi = odulVarMi;
        this.filmAdi = filmAdi;
        this.yonetmen = yonetmen;
        this.oyuncularList = oyuncularList;
        this.kategori = kategori;
    }

}

package com.bilgeadam.Service;

import com.bilgeadam.Entity.Film;
import com.bilgeadam.Entity.Kategori;
import com.bilgeadam.Entity.Oyuncular;
import com.bilgeadam.Entity.Yonetmen;
import com.bilgeadam.Repository.FilmDao;

import java.util.Arrays;

public class FilmService {
   static FilmDao filmDao = new FilmDao();
    public static void main(String[] args) {
    //getAll();
    //save();
        // dökümantasyon hazırla
        //update();
        //getRewardedActorsByFilmName("aga");
        //getActorsNoAwarded();
        getDirectorNoAwarded();
    }
    private static void save(){
        Oyuncular oyuncular1 = new Oyuncular("Emma Stone",true,"En iyi Kadın Oyuncu");
        Oyuncular oyuncular2 = new Oyuncular("Cuneyt Arkın",true,"En iyi Erkek Oyuncu");
        Oyuncular oyuncular3 = new Oyuncular("Burak Ozcivit",false);
        Oyuncular oyuncular4 = new Oyuncular("Bergüzar Korel",false);

        Yonetmen yonetmen1 = new Yonetmen("Nuri Bilge Ceylan",true,"En iyi Yönetmen");
        Yonetmen yonetmen2 = new Yonetmen("Zeki Demirkubuz",false);

        Kategori kategori1 = new Kategori("Dram");
        Kategori kategori2 = new Kategori("Korku");
        Kategori kategori3 = new Kategori("Komedi");

        Film film1 = new Film(true,"Babam ve Oglum","En iyi Dram",yonetmen2, Arrays.asList(oyuncular3,oyuncular2,oyuncular4),kategori1);
        Film film2= new Film(false,"Ahlat agaci",yonetmen1,Arrays.asList(oyuncular1,oyuncular2,oyuncular4),kategori3);
        filmDao.save(film1);
    }
    private static void getAll(){
        filmDao.getAll();
    }
    private static void update(){
        Oyuncular oyuncular1 = new Oyuncular("Emma Stone",true,"En iyi Kadın Oyuncu");
        Oyuncular oyuncular2 = new Oyuncular("Cuneyt Arkın",true,"En iyi Erkek Oyuncu");
        Oyuncular oyuncular3 = new Oyuncular("Burak Ozcivit",false);
        Oyuncular oyuncular4 = new Oyuncular("Bergüzar Korel",false);

        Yonetmen yonetmen1 = new Yonetmen("Nuri Bilge Ceylan",true,"En iyi Yönetmen");
        Yonetmen yonetmen2 = new Yonetmen("Zeki Demirkubuz",false);

        Kategori kategori1 = new Kategori("Dram");
        Kategori kategori2 = new Kategori("Korku");
        Kategori kategori3 = new Kategori("Komedi");

        Film film1 = new Film(true,"Babam ve Oglum","En iyi Dram",yonetmen2, Arrays.asList(oyuncular3,oyuncular2,oyuncular4),kategori1);
        Film film2= new Film(1,false,"Ahlat agaci",yonetmen1,Arrays.asList(oyuncular1,oyuncular3,oyuncular2,oyuncular4),kategori3);
        filmDao.update(film2);
    }
    private static void getRewardedActorsByFilmName(String filmAdi){
        filmDao.getAllByFilmName(filmAdi);
    }
    public static void getActorsNoAwarded(){
        filmDao.getActorsNoAwarded();
    }
    public static void getDirectorNoAwarded(){
        filmDao.getDirectorNoAwarded();
    }
}

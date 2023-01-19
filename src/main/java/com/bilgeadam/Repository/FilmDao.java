package com.bilgeadam.Repository;

import com.bilgeadam.Entity.Film;
import com.bilgeadam.Utils.Hibernate;
import org.hibernate.Session;
import javax.persistence.Query;
import java.util.List;

public class FilmDao implements ICrud<Film> {
    @Override
    public void save(Film film) {
        try {
            Session session = Hibernate.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(film);
            session.getTransaction().commit();
            session.close();
            System.out.println("kayıt basarılı");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new RuntimeException("Kayıt başarısız!!!");
        }
    }
    @Override
    public void getAll() {
    Session session = Hibernate.getSessionFactory().openSession();
        String sql = "SELECT f.filmAdi, f.odulVarMi, f.odulAdi, o.oyuncularAdi, o.oodulVarMi, o.oOdulAdi, y.YonetmenAdi,y.yodulVarMi ,y.yOdulAdi  FROM odul_toreni.Film as f\n" +
                "inner join odul_toreni.Kategori as k on k.id = f.kategori_id\n" +
                "inner join odul_toreni.Film_Oyuncular as fo on fo.Film_id = f.id\n" +
                "inner join odul_toreni.Oyuncular as o on o.id = fo.oyuncularList_id\n" +
                "inner join odul_toreni.Yonetmen as y on y.id = f.yonetmen_id";
        Query query = session.createNativeQuery(sql);
        List<Object[]> bookList = query.getResultList();
        for (Object[] item : bookList) {
          //  if (item[1].equals(null)) {
            System.out.println("===================");
                System.out.println(
                        "film adı: " + item[0] +
                                " filmin odulu var mı: " + item[1] +
                                " filmin odul adı: " + item[2] +
                                " oyuncu isimleri: " + item[3] +
                                " oyuncu odulu var mı: " + item[4] +
                                " oyuncu odul adı: " + item[5] +
                                " yönetmen adı: " + item[6] +
                                " yönetmenin ödülü var mı: " + item[7] +
                                " yönetmenin ödülünün adı: "+ item[8]
                );
           // }

        }
    }

    @Override
    public void update(Film film) {
        if (!film.getId().equals("0")||!film.getId().equals(null)){
            try {
                Session session = Hibernate.getSessionFactory().openSession();
                session.beginTransaction();
                session.update(film);
                session.getTransaction().commit();
                session.close();
                System.out.println("güncelleme basarılı");
            }catch (Exception e){
                e.printStackTrace();
                System.out.println(e.getMessage());
                throw new RuntimeException("güncelleme başarısız!!!");
            }
        }
        else {
            System.out.println("id bulunamadı");
        }

    }

    @Override
    public void delete(Film film) { // kontrol edilecek
        try {
            Session session = Hibernate.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(film);
            session.getTransaction().commit();
            session.close();
            System.out.println("silme basarılı");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new RuntimeException("silme başarısız!!!");
        }
    }

    @Override
    public void getAllByFilmName(String filmAdi) {
        Session session = Hibernate.getSessionFactory().openSession();
        String sql = "SELECT f.filmAdi,o.oyuncularAdi, o.oodulVarMi, o.oOdulAdi FROM odul_toreni.Film as f\n" +
                "inner join odul_toreni.Kategori as k on k.id = f.kategori_id\n" +
                "inner join odul_toreni.Film_Oyuncular as fo on fo.Film_id = f.id\n" +
                "inner join odul_toreni.Oyuncular as o on o.id = fo.oyuncularList_id\n" +
                "inner join odul_toreni.Yonetmen as y on y.id = f.yonetmen_id\n" +
                "where o.oodulVarMi = 1 and f.filmAdi like :aa";
        Query query = session.createNativeQuery(sql);
        query.setParameter("aa", "%" + filmAdi + "%");
        List<Object[]> bookList = query.getResultList();
        for (Object[] item : bookList) {
            System.out.println("===================");
            System.out.println(
                    "film adı: " + item[0] +
                            " bu film ile ödül kazanan oyuncu isimleri: " + item[1] +
                            " oyuncu odul adı: " + item[3]
            );
        }
    }
    public void getActorsNoAwarded(){
        Session session = Hibernate.getSessionFactory().openSession();
        String sql = "SELECT f.filmAdi,o.oyuncularAdi, o.oodulVarMi, o.oOdulAdi FROM odul_toreni.Film as f\n" +
                "inner join odul_toreni.Kategori as k on k.id = f.kategori_id\n" +
                "inner join odul_toreni.Film_Oyuncular as fo on fo.Film_id = f.id\n" +
                "inner join odul_toreni.Oyuncular as o on o.id = fo.oyuncularList_id\n" +
                "inner join odul_toreni.Yonetmen as y on y.id = f.yonetmen_id\n" +
                "where o.oodulVarMi = 0";
        Query query = session.createNativeQuery(sql);
        List<Object[]> bookList = query.getResultList();
        for (Object[] item : bookList) {
            System.out.println("===================");
            System.out.println(
                    "film adı: " + item[0] +
                            " ödül kazanamayan oyuncu isimleri: " + item[1]
            );
        }
    }
    public void getDirectorNoAwarded(){
        Session session = Hibernate.getSessionFactory().openSession();
        String sql = "SELECT f.filmAdi, y.YonetmenAdi FROM odul_toreni.Film as f\n" +
                "inner join odul_toreni.Kategori as k on k.id = f.kategori_id\n" +
                "inner join odul_toreni.Film_Oyuncular as fo on fo.Film_id = f.id\n" +
                "inner join odul_toreni.Oyuncular as o on o.id = fo.oyuncularList_id\n" +
                "inner join odul_toreni.Yonetmen as y on y.id = f.yonetmen_id\n" +
                "where y.yodulVarMi = 0 \n" +
                "GROUP BY f.filmAdi, y.YonetmenAdi";
        // notlar:
        // aynı filmden oyuncular yüzünden 3 adet görünüyor bu yüzden group by ile devam ettim
        // sql de inner join kısmında da çözebilirdim
        Query query = session.createNativeQuery(sql);
        List<Object[]> bookList = query.getResultList();
        for (Object[] item : bookList) {
            System.out.println("===================");
            System.out.println(
                    "film adı: " + item[0] +
                            " ödül alamayan yönetmen: " + item[1]
            );
        }
    }
}

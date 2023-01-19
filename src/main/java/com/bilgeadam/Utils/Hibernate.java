package com.bilgeadam.Utils;

import com.bilgeadam.Entity.Film;
import com.bilgeadam.Entity.Kategori;
import com.bilgeadam.Entity.Oyuncular;
import com.bilgeadam.Entity.Yonetmen;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernate {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null){
            try {
                Configuration configuration = new Configuration();
                configuration.addAnnotatedClass(Oyuncular.class);
                configuration.addAnnotatedClass(Film.class);
                configuration.addAnnotatedClass(Yonetmen.class);
                configuration.addAnnotatedClass(Kategori.class);
                sessionFactory = configuration.configure("Hibernate.cfg.xml").buildSessionFactory();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}

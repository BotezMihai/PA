package controller;

import com.dao.Database;
import entity.Actor;
import entity.Actor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActorController {
    private EntityManagerFactory emf;

    public ActorController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void create(Actor actor) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(actor);
        em.getTransaction().commit();
        em.close();
    }

//    public ArrayList<Actor> list(String directorName) {
//        ArrayList<Actor> actor = new ArrayList<>();
//        EntityManager em = emf.createEntityManager();
//        List actorObjs = null;
//        List moviesObjs = null;
//
//        if (directorName.equalsIgnoreCase("all")) {
//            Query query = em.createQuery("select t from Actor t");
//            actorObjs = query.getResultList();
//        } else {
//            Query query = em.createQuery("select t from Movie t where t.director like :directorName");
//            moviesObjs = query.setParameter("directorName", Integer.valueOf(directorName)).getResultList();
//            for (Object movieObj: moviesObjs) {
////                Query query1 = em.createNamedQuery("findAllActorsFromAMovie", Actor.class);
////                Query query1 = em.createQuery("select t from Actor t where t.id.getMovieId() = :movieObj.movieId");
//                actorObjs = query1.getResultList();
//
//            }
//        }
//
//        for (Object movieobj : actorObjs) {
//            actor.add((Actor) movieobj);
//        }
//        em.close();
//        return actor;
//    }
}
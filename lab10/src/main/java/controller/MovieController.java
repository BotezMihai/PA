package controller;

import entity.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class MovieController {
    private EntityManagerFactory emf;
    public MovieController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public void create(Movie movie) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(movie);
        em.getTransaction().commit();
        em.close();
    }
    public Movie findByName(String movieName) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select t from Movie t where t.name like :name");
        List<Movie> movies = query.setParameter("name", movieName).getResultList();
        em.close();
        return movies.isEmpty() ? null : movies.get(0);

    }
}
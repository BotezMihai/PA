package controller;

import entity.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

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
        List persons = query.setParameter("name", movieName).getResultList();
        em.close();
        return persons.isEmpty() ? null : (Movie)persons.get(0);
    }

    public ArrayList<Movie> list(String directorName)
    {
        ArrayList<Movie> movies = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        List moviesObjs = null;
        if(directorName.equalsIgnoreCase("all")) {
            Query query = em.createQuery("select t from Movie t");
            moviesObjs = query.getResultList();
        }
        else
        {
            Query query = em.createQuery("select t from Movie t where t.director like :directorName");
            moviesObjs = query.setParameter("directorName", Integer.valueOf(directorName)).getResultList();
        }
        for(Object movieobj : moviesObjs)
        {
            movies.add((Movie)movieobj);
        }
        em.close();
        return movies;
    }
}

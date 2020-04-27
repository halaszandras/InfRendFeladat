package dtos;

import dataConnect.HibernateUtil;
import models.MovieEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DtoMovie {

    private static List<MovieEntity> movies;
    private static Calendar calendar = Calendar.getInstance();
    private static Date date = new Date(calendar.getTime().getTime());

    public static List<MovieEntity> getAllMovie(){
        movies = new ArrayList<>();
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            movies = session.createQuery("from MovieEntity ", MovieEntity.class).list();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return movies;
    }

    public static void addMovieToDatabase(MovieEntity movie){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(movie);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

    public static void deleteMovie(MovieEntity movie){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            MovieEntity deleteMovie = (MovieEntity)session.load(MovieEntity.class,movie.getId());
            session.delete(deleteMovie);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

    public static void editMovie(MovieEntity movie){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(movie);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

    public static void setMovieToRented(int movieID){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            MovieEntity updatedMovie = (MovieEntity)session.load(MovieEntity.class,movieID);
            updatedMovie.setState("Rented");
            session.update(updatedMovie);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

    public static void setMovieToAvailable(int movieID){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            MovieEntity updatedMovie = (MovieEntity)session.load(MovieEntity.class,movieID);
            updatedMovie.setState("Available");
            session.update(updatedMovie);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }
}

package services;


import dtos.DtoMovie;
import models.MovieEntity;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;

@ManagedBean(name="MoviesService")
@ApplicationScoped
public class MoviesService {

    private ArrayList<MovieEntity> movies;

    public ArrayList<MovieEntity> getMovies(){
        movies = (ArrayList<MovieEntity>) DtoMovie.getAllMovie();
        return movies;
    }

    public void addMovie(MovieEntity movie){
        DtoMovie.addMovieToDatabase(movie);
    }

    public void deleteMovie(MovieEntity movie){
        DtoMovie.deleteMovie(movie);
    }

    public void editMovie(MovieEntity movie){
        DtoMovie.editMovie(movie);
    }
}

package views;


import models.MovieEntity;
import services.MoviesService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

@ManagedBean(name="moviesView")
@SessionScoped
public class MoviesView implements Serializable {

    private ArrayList<MovieEntity> movies;
    private MovieEntity selectedMovie;
    private MovieEntity editedMovie = new MovieEntity();
    private boolean moviesIsEdited = false;
    private MovieEntity newMovie = new MovieEntity();

    @ManagedProperty("#{MoviesService}")
    private MoviesService service;

    public ArrayList<MovieEntity> getMovies(){
        movies = service.getMovies();
        return movies;
    }

    public MovieEntity getSelectedMovie() {
        return selectedMovie;
    }

    public void setSelectedMovie(MovieEntity selectedMovie) {
        this.selectedMovie = selectedMovie;
    }

    public void deleteSelectedMovie() {
        service.deleteMovie(selectedMovie);
        selectedMovie = null;
    }

    public String addMovie(){
        service.addMovie(newMovie);
        newMovie = new MovieEntity();
        return "movies?faces-redirect=true";
    }

    public String deleteMovie(MovieEntity movie){
        service.deleteMovie(movie);
        return "movies?faces-redirect=true";
    }

    public String selectMovieToEdit(MovieEntity movie){
        moviesIsEdited = true;
        editedMovie = movie;
        return "movies?faces-redirect=true";
    }

    public String saveEditedMovie(){
        service.editMovie(editedMovie);
        editedMovie = new MovieEntity();
        moviesIsEdited = false;
        return "movies?faces-redirect=true";
    }

    public void setService(MoviesService service){
        this.service = service;
    }



    //Getters and Setters
    public void setMovies(ArrayList<MovieEntity> movies) {
        this.movies = movies;
    }

    public MovieEntity getEditedMovie() {
        return editedMovie;
    }

    public void setEditedMovie(MovieEntity editedMovie) {
        this.editedMovie = editedMovie;
    }

    public MovieEntity getNewMovie() {
        return newMovie;
    }

    public void setNewMovie(MovieEntity newMovie) {
        this.newMovie = newMovie;
    }

    public boolean isMoviesIsEdited() {
        return moviesIsEdited;
    }

    public void setMoviesIsEdited(boolean moviesIsEdited) {
        this.moviesIsEdited = moviesIsEdited;
    }

    public MoviesService getService() {
        return service;
    }
}

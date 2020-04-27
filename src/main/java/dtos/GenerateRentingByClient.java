package dtos;

import models.ClientEntity;
import models.MovieEntity;
import models.RentingByClient;
import models.RentingEntity;

import java.util.ArrayList;
import java.util.List;

public class GenerateRentingByClient {
    //EntityLists
    private static List<ClientEntity> clients;
    private static List<MovieEntity> movies;
    private static List<RentingEntity> rentings;
    //ClassList
    private static List<RentingByClient> rentingByClientList;

    //Get
    private static void getClients(){
        clients = DtoClient.getAllClient();
    }
    private static void getMovies(){
        movies = DtoMovie.getAllMovie();
    }
    private static void getRentings(){
        rentings = DtoRenting.getAllRenting();
    }

    //Generating
    public static List<RentingByClient> generateRentings(){
        //get
        getClients();
        getMovies();
        getRentings();

        //Create new instance
        RentingByClient rentingByClient;
        rentingByClientList = new ArrayList<>();

        //generate
        for (RentingEntity renting: rentings) {
            for(ClientEntity client: clients){
                for(MovieEntity movie: movies){
                    //Paring up users with their rented movies
                    if(renting.getClientId() == client.getId() && renting.getMovieId() == movie.getId()){
                        //new instance of a single rent of a movie by client
                        rentingByClient = new RentingByClient(
                                renting.getId(),
                                client.getId(),
                                movie.getId(),
                                movie.getTitle(),
                                movie.getDate(),
                                movie.getNumber(),
                                movie.getState(),
                                movie.getType(),
                                renting.getStart(),
                                renting.getEnd());

                        //Adding the new instance to the list of renting by the clients
                        rentingByClientList.add(rentingByClient);
                    }
                }
            }
        }

        //And now you got all the needed rents pared up ^^
        return rentingByClientList;
    }
}

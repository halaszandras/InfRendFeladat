package services;

import dtos.DtoClient;
import dtos.DtoMovie;
import dtos.DtoRenting;
import dtos.GenerateRentingByClient;
import models.ClientEntity;
import models.MovieEntity;
import models.RentingByClient;
import models.RentingEntity;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@ManagedBean(name="ClientsService")
@ApplicationScoped
public class ClientsService {

    public ArrayList<ClientEntity> getClients(){
        ArrayList<ClientEntity> clients = (ArrayList<ClientEntity>) DtoClient.getAllClient();
        return clients;
    }

    public ArrayList<RentingByClient> getAllRentingByClient(ClientEntity client){
        //get all renting
        ArrayList<RentingByClient> rentingByClients = (ArrayList<RentingByClient>) GenerateRentingByClient.generateRentings();
        //get the ones done by the client
        ArrayList<RentingByClient> rentingBySelectedClient = new ArrayList<>();
        for(RentingByClient rentingByClient: rentingByClients){
            if(rentingByClient.getClientId() == client.getId()){
                rentingBySelectedClient.add(rentingByClient);
            }
        }
        return rentingBySelectedClient;
    }

    public void addClient(ClientEntity client){
        DtoClient.addClientToDatabase(client);
    }

    public void deleteClient(ClientEntity client){
        DtoClient.deleteClient(client);
    }

    public void editClient(ClientEntity client) {
        DtoClient.editClient(client);
    }

    public void saveRenting(MovieEntity movie, ClientEntity selectedClient){
        RentingEntity renting;
        Date dateStart = new Date();

        //Two week long EndTime generation
        Date dateEnd = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dateEnd);
        c.add(Calendar.DATE, 14);
        dateEnd = c.getTime();

        //add new instance
        renting = new RentingEntity(selectedClient.getId(),movie.getId(),dateStart,dateEnd);
        DtoRenting.addRentingToDatabase(renting);
        //Apply state changes
        DtoMovie.setMovieToRented(movie.getId());

    }
    public void deleteRenting(RentingByClient renting){
        DtoRenting.deleteRenting(renting.getId());
        DtoMovie.setMovieToAvailable(renting.getMovieId());
    }

    public long getDaysFromEnding(Date end){
        Date currentTimeStamp = new Date();
        long difference = 0;
        if(currentTimeStamp.compareTo(end) >= 1){
            long differenceInMillies = Math.abs(currentTimeStamp.getTime() - end.getTime());
            //Get Days gone by since endTime
            difference = TimeUnit.DAYS.convert(differenceInMillies, TimeUnit.MILLISECONDS);
        }
        return difference;
    }

}

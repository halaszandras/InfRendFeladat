package views;

import models.ClientEntity;
import models.MovieEntity;
import models.RentingByClient;
import services.ClientsService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@ManagedBean(name="clientView")
@SessionScoped
public class ClientView implements Serializable {

    private ArrayList<ClientEntity> clients;

    private ClientEntity selectedClient;
    private ArrayList<RentingByClient> selectedClientRentings;

    private ClientEntity editedClient;
    private ClientEntity newClient = new ClientEntity();
    private boolean edit = false;

    @ManagedProperty("#{ClientsService}")
    private ClientsService service;

    public ArrayList<ClientEntity> getClients(){
        clients = service.getClients();
        return clients;
    }

    public String addClient(){
        service.addClient(newClient);
        newClient = new ClientEntity();
        return "clients?faces-redirect=true\"";
    }

    public String deleteClient(ClientEntity client){
        System.out.println(client.toString());
        service.deleteClient(client);
        return "clients?faces-redirect=true";
    }

    public String changeEdit(){
        edit = !edit;
        editedClient = selectedClient;
        return "client_data?faces-redirect=true";
    }

    public String saveClient(){
        service.editClient(editedClient);
        changeEdit();
        return "client_data?faces-redirect=true";
    }

    public String dataClient(ClientEntity client){
        selectedClient = client;
        getRentingByClientID();
        return "client_data?faces-redirect=true";
    }

    public ArrayList<RentingByClient> getRentingByClientID(){
        selectedClientRentings = service.getAllRentingByClient(selectedClient);
        return selectedClientRentings;
    }

    public void setDataClient(ClientEntity client){
        selectedClient = client;
    }

    public String saveRenting(MovieEntity movieEntity){
        service.saveRenting(movieEntity,selectedClient);
        getRentingByClientID();
        return "client_data?faces-redirect=true";
    }

    public String deleteRenting(RentingByClient renting){
        service.deleteRenting(renting);
        selectedClientRentings.remove(renting);
        return "client_data?faces-redirect=true";

    }

    //Get days gone by since endTime
    public int getDaysFromEnd(Date date){
        return (int) service.getDaysFromEnding(date);
    }

    //Getters and Setters
    public void setClients(ArrayList<ClientEntity> clients) { this.clients = clients; }

    public void setService(ClientsService service){
        this.service = service;
    }

    public ClientsService getService() {
        return service;
    }

    public void setSelectedClient(ClientEntity selectedClient) {
        this.selectedClient = selectedClient;
    }

    public ClientEntity getSelectedClient() {
        return selectedClient;
    }

    public ClientEntity getNewClient() {
        return newClient;
    }

    public void setNewClient(ClientEntity newClient) {
        this.newClient = newClient;
    }

    public ClientEntity getEditedClient() {
        return editedClient;
    }

    public void setEditedClient(ClientEntity editedClient) {
        this.editedClient = editedClient;
    }


    public ArrayList<RentingByClient> getSelectedClientRentings() {
        return selectedClientRentings;
    }

    public void setSelectedClientRentings(ArrayList<RentingByClient> selectedClientRentings) { this.selectedClientRentings = selectedClientRentings; }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

}

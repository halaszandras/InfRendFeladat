package dtos;

import dataConnect.HibernateUtil;
import models.ClientEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DtoClient {

    private static List<ClientEntity> clients;

    public static List<ClientEntity> getAllClient(){
        clients = new ArrayList<>();
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            clients = session.createQuery("from ClientEntity", ClientEntity.class).list();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return clients;
    }

    public static void addClientToDatabase(ClientEntity client){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            System.out.println(client.toString());
            session.save(client);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

    public static void deleteClient(ClientEntity client){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            ClientEntity deletedClient = (ClientEntity)session.load(ClientEntity.class,client.getId());
            session.delete(deletedClient);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

    public static void editClient(ClientEntity client){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(client);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }


}

package sio.projetautoecole.repositories;


import sio.projetautoecole.models.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public interface RepositoryInterface<T,ID>
{
    void createCompte(String login, String password) throws SQLException;

    void create(String login, String password) throws SQLException;

    void create(T obj) throws SQLException;

    void createVehicule(String modele, String immatriculation, String marque, int annee);

    void createVehicule(String modele, String immatriculation, String marque, Date annee) throws SQLException;

    void createEleve(Compte obj) throws SQLException;

    void createEleve(String nom, String prenom, String email, String telephone, String adresse, String codepostal, String ville) throws SQLException;

    Eleve setCurrentEleve(int numCompte) throws SQLException;

    Compte setCurrentCompte(int numCompte) throws SQLException;

    Compte setCurrentCompte(String login, String password) throws SQLException;

    void update(T obj) throws SQLException;
    void delete(ID id);

    Moniteur setCurrentMoniteur(int numCompte) throws SQLException;

    T get(ID id);
    ArrayList<T> getAll() throws SQLException;

    ArrayList<Categorie> getAll(Moniteur moniteur) throws SQLException;

    ArrayList<Categorie> getAllObtenu(Moniteur moniteur) throws SQLException;


    void createLicence(Licence licence) throws SQLException;

    int getIdCategorie(String Lelibelle) throws SQLException;
}




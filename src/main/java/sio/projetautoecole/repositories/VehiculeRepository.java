package sio.projetautoecole.repositories;

import sio.projetautoecole.models.*;
import sio.projetautoecole.tools.ConnexionBDDAutoEcole;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


public class VehiculeRepository implements RepositoryInterface<Vehicule, String>
{
    private Connection dataSource;

    public VehiculeRepository()
    {
        this.dataSource = ConnexionBDDAutoEcole.getCnx();
    }

    @Override
    public void createCompte(String login, String password) throws SQLException {

    }

    @Override
    public void create(String login, String password) throws SQLException {

    }

    @Override
    public void create(Vehicule obj) throws SQLException {

    }

    @Override
    public void createVehicule(String modele, String immatriculation, String marque, int annee) {

    }

    @Override
    public void createVehicule(String modele, String immatriculation, String marque, Date annee) throws SQLException {
        Vehicule vehicule= new Vehicule();
        vehicule.setModele(modele);
        vehicule.setIdImmatriculation(immatriculation);
        vehicule.setMarque(marque);
        vehicule.setAnnee(annee);
        PreparedStatement preparedStatement = dataSource.prepareStatement("insert into vehicule (Immatriculation, Marque, Modele, Annee) VALUES(?, ?, ?, ?) ");
        preparedStatement.setString(1, vehicule.getIdImmatriculation());
        preparedStatement.setString(2,vehicule.getMarque());
        preparedStatement.setString(3, vehicule.getModele());
        preparedStatement.setString(4,vehicule.getAnnee().toString());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void createEleve(Compte obj) throws SQLException {

    }

    @Override
    public void createEleve(String nom, String prenom, String email, String telephone, String adresse, String codepostal, String ville) throws SQLException {

    }

    @Override
    public Eleve setCurrentEleve(int numCompte) throws SQLException {
        return null;
    }

    @Override
    public Compte setCurrentCompte(int numCompte) throws SQLException {
        return null;
    }

    @Override
    public Compte setCurrentCompte(String login, String password) throws SQLException {
        return null;
    }

    @Override
    public void update(Vehicule obj) {

    }

    @Override
    public void delete(String s) {

    }

    @Override
    public Moniteur setCurrentMoniteur(int numCompte) throws SQLException {
        return null;
    }

    @Override
    public Vehicule get(String s) {
        return null;
    }

    @Override
    public ArrayList<Vehicule> getAll() throws SQLException {
        ArrayList<Vehicule> Vehicules = new ArrayList<>();
        PreparedStatement preparedStatement = dataSource.prepareStatement("select Immatriculation, Marque, Modele, Annee, from Vehicule ");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Vehicules.add(new Vehicule(resultSet.getString("Immatriculation"), resultSet.getString("Marque"),resultSet.getString("Modele"),resultSet.getDate("Annee")));
        }
        return Vehicules;
    }

    @Override
    public ArrayList<Categorie> getAll(Moniteur moniteur) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Categorie> getAllObtenu(Moniteur moniteur) throws SQLException {
        return null;
    }

    @Override
    public void createLicence(Licence licence) throws SQLException {

    }

    @Override
    public int getIdCategorie(String Lelibelle) throws SQLException {
        return 0;
    }


    public ArrayList<Vehicule> getAllBy(int id) throws SQLException {

        ArrayList<Vehicule> Vehicules = new ArrayList<>();
        PreparedStatement preparedStatement = dataSource.prepareStatement("select code, intitule from Vehicule where CodeCategorie = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Vehicules.add(new Vehicule(resultSet.getString("Immatriculation"), resultSet.getString("Marque"),resultSet.getString("Modele"),resultSet.getDate("Annee")));
        }
        return Vehicules;
    }
}


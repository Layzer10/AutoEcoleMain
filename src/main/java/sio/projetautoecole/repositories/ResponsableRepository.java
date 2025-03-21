package sio.projetautoecole.repositories;

import sio.projetautoecole.models.*;
import sio.projetautoecole.tools.ConnexionBDDAutoEcole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class ResponsableRepository implements RepositoryInterface<Responsable, Integer>{
    private Connection dataSource;

    public ResponsableRepository()
    {
        this.dataSource = ConnexionBDDAutoEcole.getCnx();
    }

    @Override
    public Responsable setCurrentResponsable(int numCompte) throws SQLException {
        Responsable r = new Responsable();
        PreparedStatement preparedStatement = dataSource.prepareStatement("SELECT CodeAdmin,mail,Nom,NumCompte from admin where numCompte = ?");
        preparedStatement.setInt(1,numCompte);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())    {
            r = new Responsable(resultSet.getInt("CodeAdmin"),resultSet.getString("mail"),resultSet.getString("Nom"),numCompte);    }
        return r;}

    @Override
    public void createCompte(String login, String password) throws SQLException {

    }

    @Override
    public void create(String login, String password) throws SQLException {

    }

    @Override
    public void create(Responsable obj) throws SQLException {

    }

    @Override
    public void createVehicule(String modele, String immatriculation, String marque, int annee) {

    }

    @Override
    public void createVehicule(String modele, String immatriculation, String marque, Date annee) throws SQLException {

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
    public void update(Responsable obj) throws SQLException {

    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public Moniteur setCurrentMoniteur(int numCompte) throws SQLException {
        return null;
    }

    @Override
    public Responsable get(Integer integer) {
        return null;
    }

    @Override
    public ArrayList<Responsable> getAll() throws SQLException {
        return null;
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
}

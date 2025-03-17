package sio.projetautoecole.repositories;

import sio.projetautoecole.models.*;
import sio.projetautoecole.tools.ConnexionBDDAutoEcole;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


public class LeconRepository implements RepositoryInterface<Lecon, String>
{
    private Connection dataSource;

    public LeconRepository()
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
    public void create(Lecon obj) {

    }

    @Override
    public void createVehicule(String modele, String immatriculation, String marque, int annee) {

    }

    @Override
    public void createVehicule(String modele, String immatriculation, String marque, Date annee) {

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
    public void update(Lecon obj) {

    }

    @Override
    public void delete(String s) {

    }

    @Override
    public Moniteur setCurrentMoniteur(int numCompte) throws SQLException {
        return null;
    }

    @Override
    public Lecon get(String s) {
        return null;
    }

    @Override
    public ArrayList<Lecon> getAll() throws SQLException {
        ArrayList<Lecon> Lecons = new ArrayList<>();
        PreparedStatement preparedStatement = dataSource.prepareStatement("select CodeLecon, Date, Heure, Reglee from Lecon ");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Lecons.add(new Lecon(resultSet.getInt("CodeLecon"), resultSet.getDate("Date"),resultSet.getString("Heure"),resultSet.getInt("Reglee")));
        }
        return Lecons;
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


    public ArrayList<Lecon> getAllBy(Eleve eleve) throws SQLException {
        ArrayList<Lecon> Lecons = new ArrayList<>();
        PreparedStatement preparedStatement = dataSource.prepareStatement("SELECT l.CodeLecon, l.Date, l.Heure, l.Reglee, m.Nom, l.Immatriculation " +
                "FROM Lecon l " +
                "INNER JOIN Moniteur m ON l.CodeMoniteur = m.CodeMoniteur " +
                "INNER JOIN Eleve e ON l.CodeEleve = e.CodeEleve " +
                "INNER JOIN Vehicule v ON l.Immatriculation = v.Immatriculation " +
                "WHERE l.CodeEleve = ?");
        preparedStatement.setInt(1,eleve.getIdEleve());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Lecons.add(new Lecon(resultSet.getInt("CodeLecon"), resultSet.getDate("Date"),resultSet.getString("Heure"),resultSet.getInt("Reglee"),resultSet.getString("Immatriculation"),resultSet.getString("Nom")));
        }
        return Lecons;
    }

    public ArrayList<Lecon> getAllBy(Moniteur moniteur) throws SQLException {
        ArrayList<Lecon> Lecons = new ArrayList<>();
        PreparedStatement preparedStatement = dataSource.prepareStatement("SELECT l.CodeLecon, l.Date, l.Heure, l.Reglee, e.Nom, l.Immatriculation " +
                "FROM Lecon l " +
                "INNER JOIN Moniteur m ON l.CodeMoniteur = m.CodeMoniteur " +
                "INNER JOIN Eleve e ON l.CodeEleve = e.CodeEleve " +
                "INNER JOIN Vehicule v ON l.Immatriculation = v.Immatriculation " +
                "WHERE l.CodeMoniteur = ?");
        preparedStatement.setInt(1,moniteur.getIdMoniteur());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Lecons.add(new Lecon(resultSet.getInt("CodeLecon"), resultSet.getDate("Date"),resultSet.getString("Heure"),resultSet.getInt("Reglee"),resultSet.getString("Immatriculation"),resultSet.getString("Nom")));
        }
        return Lecons;
    }


    public int getNbLeconValidee(Eleve eleve) throws SQLException {
        int NbLecon = 0;

        String query = "SELECT COUNT(l.CodeLecon) " +
                "FROM Lecon l " +
                "INNER JOIN Moniteur m ON l.CodeMoniteur = m.CodeMoniteur " +
                "INNER JOIN Eleve e ON l.CodeEleve = e.CodeEleve " +
                "INNER JOIN Vehicule v ON l.Immatriculation = v.Immatriculation " +
                "WHERE l.CodeEleve = ? AND l.Validee = 1";

        PreparedStatement preparedStatement = dataSource.prepareStatement(query);
        preparedStatement.setInt(1, eleve.getIdEleve());

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            NbLecon = resultSet.getInt(1); // Récupérer directement le COUNT
        }

        resultSet.close();
        preparedStatement.close();

        return NbLecon;
    }

    public int getNbLeconBySexeM() throws SQLException {
        int NbLeconM = 0;

        String query = "SELECT COUNT(l.CodeLecon) " +
                "FROM Lecon l " +
                "INNER JOIN Moniteur m ON l.CodeMoniteur = m.CodeMoniteur " +
                "INNER JOIN Eleve e ON l.CodeEleve = e.CodeEleve " +
                "INNER JOIN Vehicule v ON l.Immatriculation = v.Immatriculation " +
                "WHERE e.Sexe = 0";

        PreparedStatement preparedStatement = dataSource.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            NbLeconM = resultSet.getInt(1); // Récupérer directement le COUNT
        }

        resultSet.close();
        preparedStatement.close();

        return NbLeconM;
    }

    public int getNbLeconBySexeF() throws SQLException {
        int NbLeconF = 0;

        String query = "SELECT COUNT(l.CodeLecon) " +
                "FROM Lecon l " +
                "INNER JOIN Moniteur m ON l.CodeMoniteur = m.CodeMoniteur " +
                "INNER JOIN Eleve e ON l.CodeEleve = e.CodeEleve " +
                "INNER JOIN Vehicule v ON l.Immatriculation = v.Immatriculation " +
                "WHERE e.Sexe = 1";

        PreparedStatement preparedStatement = dataSource.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            NbLeconF = resultSet.getInt(1); // Récupérer directement le COUNT
        }

        resultSet.close();
        preparedStatement.close();

        return NbLeconF;
    }
}

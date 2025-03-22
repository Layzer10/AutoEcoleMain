package sio.projetautoecole.repositories;

import sio.projetautoecole.models.*;
import sio.projetautoecole.tools.ConnexionBDDAutoEcole;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


public class LicenceRepository implements RepositoryInterface<Licence, String>
{
    private Connection dataSource;

    public LicenceRepository()
    {
        this.dataSource = ConnexionBDDAutoEcole.getCnx();
    }

    @Override
    public Responsable setCurrentResponsable(int numCompte) throws SQLException {
        return null;
    }

    @Override
    public void createCompte(String login, String password) throws SQLException {

    }

    @Override
    public void create(String login, String password) throws SQLException {

    }

    @Override
    public void create(Licence obj) {

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
    public void update(Licence obj) {

    }

    @Override
    public void delete(String s) {

    }

    @Override
    public Moniteur setCurrentMoniteur(int numCompte) throws SQLException {
        return null;
    }

    @Override
    public Licence get(String s) {
        return null;
    }

    @Override
    public ArrayList<Licence> getAll() throws SQLException {
        ArrayList<Licence> Licences = new ArrayList<>();
        PreparedStatement preparedStatement = dataSource.prepareStatement("select CodeLicence, DateObtention, from Licence ");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Licences.add(new Licence(resultSet.getInt("CodeLicence"), resultSet.getDate("DateObtention")));
        }
        return Licences;
    }

    @Override
    public ArrayList<Categorie> getAll(Moniteur moniteur) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Categorie> getAllObtenu(Moniteur moniteur) throws SQLException {
        return null;
    }


    public ArrayList<Licence> getAllBy(int id) throws SQLException {

        ArrayList<Licence> Licences = new ArrayList<>();
        PreparedStatement preparedStatement = dataSource.prepareStatement("select CodeLicence, DateObtention from Licence where CodeCategorie = ? and CodeMoniteur = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Licences.add(new Licence(resultSet.getInt("CodeLicence"), resultSet.getDate("DateObtention")));
        }
        return Licences;
    }

    @Override
    public void createLicence(Licence licence) throws SQLException {
        int increment = autoIncrementLicence();

        // Préparer la requête pour insérer une licence
        PreparedStatement preparedStatement = dataSource.prepareStatement(
                "INSERT INTO licence (CodeLicence, CodeMoniteur, CodeCategorie) VALUES (?, ?, ?)"
        );

        // Assigner les valeurs
        preparedStatement.setInt(1, increment); // CodeLicence auto-incrémenté
        preparedStatement.setInt(2, licence.getIdMoniteur()); // ID du moniteur
        preparedStatement.setInt(3, licence.getIdCategorie()); // ID de la catégorie

        // Exécuter la requête
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }


    @Override
    public int getIdCategorie(String Lelibelle) throws SQLException {
        return 0;
    }


    public int autoIncrementLicence() throws SQLException {
        int increment = 1; // Valeur par défaut si la table est vide

        // Préparer la requête SQL pour calculer MAX(NumCompte) + 1
        PreparedStatement preparedStatement = dataSource.prepareStatement("SELECT COALESCE(MAX(CodeLicence), 0) + 1 AS increment FROM licence");

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            increment = resultSet.getInt("increment"); // Récupérer la valeur du champ "increment"
        }

        resultSet.close();
        preparedStatement.close();

        return increment;

    }

    public int getHommeByLicenceCategorie(int idCategorie) throws SQLException {
        int nbHomme =0;
        String query = "SELECT COUNT(l.CodeLicence) " +
                "FROM Licence l " +
                "INNER JOIN Moniteur m ON l.CodeMoniteur = m.CodeMoniteur " +
                "WHERE l.CodeCategorie = ? AND m.Sexe=0";

        PreparedStatement preparedStatement = dataSource.prepareStatement(query);
        preparedStatement.setInt(1, idCategorie);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            nbHomme = resultSet.getInt(1); // Récupérer le prix
        }

        resultSet.close();
        preparedStatement.close();

        return nbHomme;
    }

    public int getFemmeByLicenceCategorie(int idCategorie) throws SQLException {
        int nbFemme =0;
        String query = "SELECT COUNT(l.CodeLicence) " +
                "FROM Licence l " +
                "INNER JOIN Moniteur m ON l.CodeMoniteur = m.CodeMoniteur " +
                "WHERE l.CodeCategorie = ? AND m.Sexe=1";

        PreparedStatement preparedStatement = dataSource.prepareStatement(query);
        preparedStatement.setInt(1, idCategorie);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            nbFemme = resultSet.getInt(1); // Récupérer le prix
        }

        resultSet.close();
        preparedStatement.close();

        return nbFemme;
    }
}




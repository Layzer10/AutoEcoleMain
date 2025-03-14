package sio.projetautoecole.repositories;

import sio.projetautoecole.models.*;
import sio.projetautoecole.tools.ConnexionBDDAutoEcole;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class CategorieRepository implements RepositoryInterface<Categorie, Integer>{
    private Connection dataSource;

    public CategorieRepository()
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
    public void create(Categorie obj) {

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
    public void update(Categorie obj) {

    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public Moniteur setCurrentMoniteur(int numCompte) throws SQLException {
        return null;
    }

    @Override
    public Categorie get(Integer integer) {
        return null;
    }

    @Override
    public ArrayList<Categorie> getAll() throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Categorie> getAll(Moniteur moniteur) throws SQLException {
        ArrayList<Categorie> Categories = new ArrayList<>();
        PreparedStatement preparedStatement = dataSource.prepareStatement("SELECT libelle from Categorie c WHERE CodeCategorie NOT IN (\n" +
                "    SELECT licence.CodeCategorie\n" +
                "    FROM licence\n" +
                "    WHERE licence.CodeMoniteur = ? )");
        preparedStatement.setInt(1,moniteur.getIdMoniteur());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            Categories.add(new Categorie(resultSet.getString("Libelle")));
        }
        return Categories;
    }

    @Override
    public ArrayList<Categorie> getAllObtenu(Moniteur moniteur) throws SQLException {
        ArrayList<Categorie> Categories = new ArrayList<>();
        PreparedStatement preparedStatement = dataSource.prepareStatement("SELECT libelle " +
                "FROM Categorie c " +
                "INNER JOIN licence l ON c.CodeCategorie = l.CodeCategorie " +
                "WHERE l.CodeMoniteur = ?");
        preparedStatement.setInt(1,moniteur.getIdMoniteur());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            Categories.add(new Categorie(resultSet.getString("Libelle")));
        }
        return Categories;
    }

    @Override
    public void createLicence(Licence licence) throws SQLException {

    }

    @Override
    public int getIdCategorie(String Lelibelle) throws SQLException {
        String query = "SELECT CodeCategorie FROM Categorie WHERE Libelle = ?";
        PreparedStatement preparedStatement = dataSource.prepareStatement(query);
        preparedStatement.setString(1, Lelibelle);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return resultSet.getInt("CodeCategorie"); // Récupère et retourne l'ID de la catégorie
        }
        throw new SQLException("Aucune catégorie trouvée avec le libellé : " + Lelibelle);

    }





}

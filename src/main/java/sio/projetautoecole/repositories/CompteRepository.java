package sio.projetautoecole.repositories;

import sio.projetautoecole.models.*;
import sio.projetautoecole.tools.ConnexionBDDAutoEcole;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class CompteRepository implements RepositoryInterface<Compte, Integer> {
    private Connection dataSource;

    public CompteRepository() {
        this.dataSource = ConnexionBDDAutoEcole.getCnx();
    }

    @Override
    public void createCompte(String login, String password) throws SQLException {
        int increment = autoIncrement();
        Compte compte= new Compte();
        compte.setLoginCompte(login);
        compte.setMdpCompte(password);
        PreparedStatement preparedStatement = dataSource.prepareStatement("insert into compte (NumCompte, login, mdp) values(?,?,?)");
        preparedStatement.setInt(1, increment);
        preparedStatement.setString(2,compte.getLoginCompte());
        preparedStatement.setString(3,compte.getMdpCompte());

        preparedStatement.executeUpdate();
        preparedStatement.close();

    }

    public int autoIncrement() throws SQLException {
        int increment = 1; // Valeur par défaut si la table est vide

        // Préparer la requête SQL pour calculer MAX(NumCompte) + 1
        PreparedStatement preparedStatement = dataSource.prepareStatement("SELECT COALESCE(MAX(NumCompte), 0) + 1 AS increment FROM compte");

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            increment = resultSet.getInt("increment"); // Récupérer la valeur du champ "increment"
        }

        resultSet.close();
        preparedStatement.close();

        return increment;

    }


    @Override
    public void create(String login, String password) throws SQLException {

    }

    @Override
    public void create(Compte obj) throws SQLException {

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
        Compte compte = null;
        String sql = "SELECT NumCompte, login, mdp, statut FROM Compte WHERE login = ? AND mdp = ?";
        PreparedStatement preparedStatement = dataSource.prepareStatement(sql);
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            compte = new Compte(
                    resultSet.getInt("NumCompte"),
                    resultSet.getString("login"),
                    resultSet.getString("mdp"),
                    resultSet.getInt("statut")
            );
        }

        return compte;
    }

    @Override
    public void update(Compte obj) {
    }

    @Override
    public void delete(Integer integer) {
    }

    @Override
    public Moniteur setCurrentMoniteur(int numCompte) throws SQLException {
        return null;
    }

    @Override
    public Compte get(Integer integer) {
        return null;
    }

    @Override
    public ArrayList<Compte> getAll() throws SQLException {
        ArrayList<Compte> comptes = new ArrayList<>();
        PreparedStatement preparedStatement = dataSource.prepareStatement("SELECT NumCompte, login, mdp, statut FROM Compte");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            comptes.add(new Compte(
                    resultSet.getInt("NumCompte"),
                    resultSet.getString("login"),
                    resultSet.getString("mdp"),
                    resultSet.getInt("statut")
            ));
        }
        return comptes;
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

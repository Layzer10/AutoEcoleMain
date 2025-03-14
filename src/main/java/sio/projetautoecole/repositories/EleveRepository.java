package sio.projetautoecole.repositories;
import sio.projetautoecole.models.*;
import sio.projetautoecole.tools.ConnexionBDDAutoEcole;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class EleveRepository implements RepositoryInterface<Eleve, Integer>{
    private Connection dataSource;

    public EleveRepository()
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
    public void create(Eleve obj) throws SQLException {

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
        Eleve eleve= new Eleve();
        eleve.setNomEleve(nom);
        eleve.setPrenomEleve(prenom);
        eleve.setAdresse(adresse);
        eleve.setCodePostal(codepostal);
        eleve.setVille(ville);
        eleve.setNumero(telephone);
        eleve.setMail(email);
        int increment = autoIncrementIndex();
        int increment2 = autoIncrementPrimaire();
        PreparedStatement preparedStatement = dataSource.prepareStatement("insert into eleve (Nom, Prenom, Adresse1, CodePostal, Ville, Telephone, mail, NumCompte, CodeEleve) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?) ");
        preparedStatement.setString(1, eleve.getNomEleve());
        preparedStatement.setString(2,eleve.getPrenomEleve());
        preparedStatement.setString(3,eleve.getAdresse());
        preparedStatement.setString(4,eleve.getCodePostal());
        preparedStatement.setString(5,eleve.getVille());
        preparedStatement.setString(6,eleve.getNumero());
        preparedStatement.setString(7,eleve.getMail());
        preparedStatement.setInt(8,increment);
        preparedStatement.setInt(9,increment2);
        preparedStatement.executeUpdate();
        preparedStatement.close();

    }

    public int autoIncrementIndex() throws SQLException {
        int increment = 1; // Valeur par défaut si la table est vide

        PreparedStatement preparedStatement = dataSource.prepareStatement("SELECT COALESCE(MAX(NumCompte), 0) AS increment FROM compte"); //recupere le numcompte du compte creer

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            increment = resultSet.getInt("increment"); // Récupérer la valeur du champ "increment"
        }

        resultSet.close();
        preparedStatement.close();

        return increment;

    }
    public int autoIncrementPrimaire() throws SQLException {
        int increment2 = 1; // Valeur par défaut si la table est vide

        PreparedStatement preparedStatement = dataSource.prepareStatement("SELECT COALESCE(MAX(CodeEleve), 0) + 1 AS increment FROM eleve");

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            increment2 = resultSet.getInt("increment"); // Récupérer la valeur du champ "increment"
        }

        resultSet.close();
        preparedStatement.close();

        return increment2;

    }

    @Override
    public Eleve setCurrentEleve(int numCompte) throws SQLException {
        Eleve e = new Eleve();
        PreparedStatement preparedStatement = dataSource.prepareStatement("SELECT CodeEleve,Nom,Prenom,Sexe,DateDeNaissance,Adresse1,CodePostal,Ville,Telephone,mail from eleve where numCompte = ?");
        preparedStatement.setInt(1,numCompte);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())    {
            e = new Eleve(resultSet.getInt("CodeEleve"),resultSet.getString("Nom"),resultSet.getString("Prenom"),resultSet.getBoolean("Sexe"),resultSet.getString("DateDeNaissance"),resultSet.getString("Adresse1"),resultSet.getString("CodePostal"),resultSet.getString("Ville"),resultSet.getString("Telephone"),resultSet.getString("mail"),numCompte);    }
        return e;}

    @Override
    public Compte setCurrentCompte(int numCompte) throws SQLException {
        return null;
    }

    @Override
    public Compte setCurrentCompte(String login, String password) throws SQLException {
        return null;
    }

    public void update(Eleve eleve) throws SQLException {

        String sql = "UPDATE eleve SET Nom = ?, Prenom = ?, Adresse1 = ?, CodePostal = ?, Ville = ?, mail = ?, Telephone = ?, DateDeNaissance = ? WHERE numCompte = ?";
        try (PreparedStatement statement = dataSource.prepareStatement(sql)) {
            statement.setString(1, eleve.getNomEleve());
            statement.setString(2, eleve.getPrenomEleve());
            statement.setString(3, eleve.getAdresse());
            statement.setString(4, eleve.getCodePostal());
            statement.setString(5, eleve.getVille());
            statement.setString(6, eleve.getMail());
            statement.setString(7, eleve.getNumero());
            statement.setString(8, eleve.getDateNaissance());
            statement.setInt(9, eleve.getNumCompte());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("Aucune ligne mise à jour.");
            }
        }
    }


    @Override
    public void delete(Integer integer) {

    }

    @Override
    public Moniteur setCurrentMoniteur(int numCompte) throws SQLException {
        return null;
    }

    @Override
    public Eleve get(Integer integer) {
        return null;
    }

    @Override
    public ArrayList<Eleve> getAll() throws SQLException {
        ArrayList<Eleve> Eleves = new ArrayList<>();
        PreparedStatement preparedStatement = dataSource.prepareStatement("select CodeEleve, Nom, Prenom, Sexe, DateDeNaissance, Adresse1, CodePostal, Ville, Telephone, mail, from eleve");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            Eleves.add(new Eleve(resultSet.getInt("CodeEleve"), resultSet.getString("Nom"), resultSet.getString("Prenom"), resultSet.getBoolean("Sexe"), resultSet.getString("DateDeNaissance"), resultSet.getString("Adresse1"),resultSet.getString("CodePostal"), resultSet.getString("Ville"), resultSet.getString("Telephone"),resultSet.getString("mail")));
        }
        return Eleves;
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

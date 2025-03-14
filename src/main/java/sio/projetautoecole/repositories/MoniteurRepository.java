package sio.projetautoecole.repositories;
import sio.projetautoecole.models.*;
import sio.projetautoecole.tools.ConnexionBDDAutoEcole;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class MoniteurRepository implements RepositoryInterface<Moniteur, Integer>{
    private Connection dataSource;

    public MoniteurRepository()
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
    public void create(Moniteur obj) {

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
    public void update(Moniteur moniteur) throws SQLException {

        String sql = "UPDATE moniteur SET Nom = ?, Prenom = ?, Adresse1 = ?, CodePostal = ?, Ville = ?, mail = ?, Telephone = ?, DateDeNaissance = ? WHERE numCompte = ?";
        try (PreparedStatement statement = dataSource.prepareStatement(sql)) {
            statement.setString(1, moniteur.getNomMoniteur());
            statement.setString(2, moniteur.getPrenomMoniteur());
            statement.setString(3, moniteur.getAdresse());
            statement.setString(4, moniteur.getCodePostal());
            statement.setString(5, moniteur.getVille());
            statement.setString(6, moniteur.getMail());
            statement.setString(7, moniteur.getNumero());
            statement.setString(8, moniteur.getDateNaissance());
            statement.setInt(9, moniteur.getNumCompte());

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
        Moniteur m = new Moniteur();
        PreparedStatement preparedStatement = dataSource.prepareStatement("SELECT CodeMoniteur,Nom,Prenom,Sexe,DateDeNaissance,Adresse1,CodePostal,Ville,Telephone,mail from moniteur where numCompte = ?");
        preparedStatement.setInt(1,numCompte);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())    {
            m = new Moniteur(resultSet.getInt("CodeMoniteur"),resultSet.getString("Nom"),resultSet.getString("Prenom"),resultSet.getBoolean("Sexe"),resultSet.getString("DateDeNaissance"),resultSet.getString("Adresse1"),resultSet.getString("CodePostal"),resultSet.getString("Ville"),resultSet.getString("Telephone"),resultSet.getString("mail"),numCompte);    }
        return m;}

    @Override
    public Moniteur get(Integer integer) {
        return null;
    }

    @Override
    public ArrayList<Moniteur> getAll() throws SQLException {
        ArrayList<Moniteur> Moniteurs = new ArrayList<>();
        PreparedStatement preparedStatement = dataSource.prepareStatement("select CodeMoniteur, Nom, Prenom, Sexe, DateDeNaissance, Adresse1, CodePostal, Ville, Telephone, mail from moniteur");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            Moniteurs.add(new Moniteur(resultSet.getInt("CodeMoniteur"), resultSet.getString("Nom"), resultSet.getString("Prenom"), resultSet.getBoolean("Sexe"), resultSet.getString("DateDeNaissance"), resultSet.getString("Adresse1"),resultSet.getString("CodePostal"), resultSet.getString("Ville"), resultSet.getString("Telephone"),resultSet.getString("mail")));
        }
        return Moniteurs;
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

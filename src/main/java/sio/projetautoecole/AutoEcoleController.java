package sio.projetautoecole;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import sio.projetautoecole.models.*;
import sio.projetautoecole.repositories.*;
import sio.projetautoecole.services.CompteService;
import sio.projetautoecole.tools.ConnexionBDDAutoEcole;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;



public class AutoEcoleController implements Initializable {
    private CompteService compteService;
    @FXML
    private TextField txtPrenom;
    @FXML
    private Button btnMenuLicenceMoniteur;
    @FXML
    private TextField txtNumero;
    @FXML
    private TextField txtVille;
    @FXML
    private Button btnMenuElevePlanning;
    @FXML
    private Button btnInscription;
    @FXML
    private AnchorPane bpStatsEleve;
    @FXML
    private BorderPane bpAdmin;
    @FXML
    private BorderPane bpInscription;
    @FXML
    private TextField txtCodePostale;
    @FXML
    private AnchorPane bpLeconEleve;
    @FXML
    private RadioButton radioBtnFemme;
    @FXML
    private Button btnInfoPersoEleve;
    @FXML
    private Button btnInfoPersoMoniteur;
    @FXML
    private RadioButton radioBtnEleve;
    @FXML
    private BorderPane bpConnexion;
    @FXML
    private BorderPane bpAccueil;
    @FXML
    private ImageView imgBtnInfoPersoAdmin;
    @FXML
    private Button btnMenuStatsMoniteur;
    @FXML
    private RadioButton radioBtnMoniteur;
    @FXML
    private RadioButton radioBtnAdmin;
    @FXML
    private Button btnValiderConnect;
    @FXML
    private Button btnMenuEleveLecon;
    @FXML
    private BorderPane bpMoniteur;
    @FXML
    private Button btnInfoPersoAdmin;
    @FXML
    private Button btnAnnulerC;
    @FXML
    private TextField txtMail;
    @FXML
    private Button btnMenuPlanningMoniteur;
    @FXML
    private BorderPane bpEleve;
    @FXML
    private Button btnMenuEleveStats;
    @FXML
    private PasswordField txtMdp;
    @FXML
    private Button btnConnexion;
    @FXML
    private TextField txtAdresse;
    @FXML
    private Label lblNomPrenomAdmin;
    @FXML
    private DatePicker dpDateDeNaiss;
    @FXML
    private RadioButton radioBtnHomme;
    @FXML
    private Button btnValiderInscris;
    @FXML
    private TextField txtNom;
    @FXML
    private Button btnMenuStatsAdmin;
    @FXML
    private ImageView imgBtnInfoPersoEleve;
    @FXML
    private Button btnMenuPlanningAdmin;
    @FXML
    private Button btnMenuLicenceAdmin;
    @FXML
    private ImageView imgBtnInfoPersoMoniteur;
    @FXML
    private Button btnAnnulerInscris;
    @FXML
    private TextField txtIdentifiant;
    @FXML
    private PasswordField txtMotDePasse;
    @FXML
    private Label lblPrenomEleve;
    @FXML
    private Label lblNomEleve;
    @FXML
    private TextField mailE;
    @FXML
    private TextField codepostalE;
    @FXML
    private TextField txtprenomE;
    @FXML
    private TextField txtnomE;
    @FXML
    private TextField villeE;
    @FXML
    private TextField telephoneE;
    @FXML
    private TextField adresseE;
    @FXML
    private DatePicker dateE;
    Moniteur m;
    Eleve e;
    @FXML
    private AnchorPane bpInfoEleve;
    @FXML
    private AnchorPane bpInfoMoniteur;
    @FXML
    private TextField mailM;
    @FXML
    private TextField codepostalM;
    @FXML
    private TextField txtprenomM;
    @FXML
    private TextField txtnomM;
    @FXML
    private TextField villeM;
    @FXML
    private TextField telephoneM;
    @FXML
    private TextField adresseM;
    @FXML
    private DatePicker dateM;
    @FXML
    private Label lblNomMoniteur;
    @FXML
    private Label lblPrenomMoniteur;
    @FXML
    private TextField txtLogin;
    @FXML
    private TableColumn colImatriculation;
    @FXML
    private TableColumn colMoniteur;
    @FXML
    private TableColumn colDate;
    @FXML
    private AnchorPane bpPlanningEleve;
    @FXML
    private TableColumn colLecon;
    @FXML
    private TableColumn colHeure;
    @FXML
    private TableColumn colReglee;
    @FXML
    private TableView tvLeconEleve;
    @FXML
    private Button btnMenuEleveAccueil;
    @FXML
    private TableColumn colLeconM;
    @FXML
    private TableColumn colDateM;
    @FXML
    private AnchorPane bpPlanningMoniteur;
    @FXML
    private TableColumn colRegleeM;
    @FXML
    private TableView tvLeconMoniteur;
    @FXML
    private TableColumn colImatriculationM;
    @FXML
    private TableColumn colMoniteurM;
    @FXML
    private TableColumn colHeureM;
    @FXML
    private AnchorPane bpStatMoniteur;
    @FXML
    private AnchorPane bpLicenceMoniteur;
    @FXML
    private Button btnMenuPlanningMoniteur1;
    @FXML
    private TableView tvLicenceObtenu;
    @FXML
    private TableView tvLicence;
    @FXML
    private TableColumn nomLicenceObtenu;
    @FXML
    private TableColumn nomCategorie;
    @FXML
    private TextField modele;
    @FXML
    private TextField marque;
    @FXML
    private AnchorPane Vehicule;
    @FXML
    private TextField immatriculation;
    @FXML
    private Button btnValiderConnect1;
    @FXML
    private DatePicker annee;
    @FXML
    private Label nbLecon;

    public AutoEcoleController() {
        this.compteService = new CompteService();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            ConnexionBDDAutoEcole.initConnexion(); // Initialisation de la connexion à la BDD
            this.compteService = new CompteService(); // Initialisation du service
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de connexion");
            alert.setHeaderText(null);
            alert.setContentText("Impossible de se connecter à la base de données.");
            alert.showAndWait();
        }
        /* A l'initialisation, je veille que toutes les pages ne sois pas visible a par la page d'accueil.*/
        bpAdmin.setVisible(false);
        bpMoniteur.setVisible(false);
        bpEleve.setVisible(false);
        bpConnexion.setVisible(false);
        bpInscription.setVisible(false);
        bpAccueil.setVisible(true);

    }
    @FXML
    public void clickBtnInscription(Event event) {
        bpInscription.setVisible(true);
    }

    @FXML
    public void clickBtnConnexion(Event event) {
        bpConnexion.setVisible(true);
    }

    @FXML
    public void clickBtnValiderInscris(Event event) throws SQLException {
        String nom = txtNom.getText();
        String prenom = txtPrenom.getText();
        String email = txtMail.getText();
        String telephone = txtNumero.getText();
        LocalDate dateDeNaissance = dpDateDeNaiss.getValue();
        String adresse = txtAdresse.getText();
        String codePostale = txtCodePostale.getText();
        String ville= txtVille.getText();
        String Mdp = txtMdp.getText();
        String Login= txtLogin.getText();
        Compte newCompte= new Compte();
        Eleve newEleve= new Eleve();
        new CompteRepository().createCompte(Login,Mdp);
        new EleveRepository().createEleve(nom,prenom,email,telephone,adresse,codePostale,ville);
    }

    @Deprecated
    public void clickBtnAnnuler(Event event) {
        bpConnexion.setVisible(false);
    }

    @Deprecated
    public void handleRadioSelection(Event event) {
        if (radioBtnEleve.isSelected()) {
            radioBtnMoniteur.setSelected(false);
            radioBtnAdmin.setSelected(false);
        } else if (radioBtnMoniteur.isSelected()) {
            radioBtnEleve.setSelected(false);
            radioBtnAdmin.setSelected(false);
        } else if (radioBtnAdmin.isSelected()) {
            radioBtnEleve.setSelected(false);
            radioBtnMoniteur.setSelected(false);
        }

    }


    @FXML
    public void clickBtnAnnulerInscris(Event event) {
        bpInscription.setVisible(false);
        txtNom.clear();
        txtPrenom.clear();
        txtMail.clear();
        txtNumero.clear();
        dpDateDeNaiss.setValue(null);
        txtAdresse.clear();
        txtCodePostale.clear();
        txtMdp.clear();
    }

    @FXML
    public void btnInfoPersoMoniteurClicked(Event event) {
    }

    @Deprecated
    public void clickBtnAnnulerE(Event event) {
    }

    @FXML
    public void menuMoniteurClicked(Event event) {
    }

    @FXML
    public void clickBtnValiderConnect(Event event) {

        String login = txtIdentifiant.getText();
        String mdp = txtMotDePasse.getText();
        if(radioBtnEleve.isSelected()){
            try {
                // Essayer de récupérer le compte basé sur les identifiants
                Compte compte = compteService.setCurrentCompte(login, mdp);

                if (compte != null) {
                    // Connexion réussie
                    // Récupérer l'éléve associé au compte
                    e = new EleveRepository().setCurrentEleve(compte.getIdCompte()); // Récupérer l'élève via son numCompte

                    // Mettre à jour les labels avec les informations de l'élève
                    lblNomEleve.setText(e.getNomEleve());
                    lblPrenomEleve.setText(e.getPrenomEleve());


                    // Afficher la page de l'élève
                    bpEleve.setVisible(true);

                    // Afficher une alerte de succès
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Connexion réussie");
                    alert.setHeaderText(null);
                    alert.setContentText("Bienvenue, " + compte.getLoginCompte());
                    alert.showAndWait();


                    txtnomE.setText(e.getNomEleve());
                    txtprenomE.setText(e.getPrenomEleve());
                    adresseE.setText(e.getAdresse());
                    codepostalE.setText(e.getCodePostal());
                    villeE.setText(e.getVille());
                    mailE.setText(e.getMail());
                    telephoneE.setText(e.getNumero());

                    colLecon.setCellValueFactory(new PropertyValueFactory<>("idLecon"));
                    colDate.setCellValueFactory(new PropertyValueFactory<>("dateLecon"));
                    colHeure.setCellValueFactory(new PropertyValueFactory<>("heureLecon"));
                    colReglee.setCellValueFactory(new PropertyValueFactory<>("reglee"));
                    colMoniteur.setCellValueFactory(new PropertyValueFactory<>("nom"));
                    colImatriculation.setCellValueFactory(new PropertyValueFactory<>("immatriculation"));

                    try {
                        int totalReglees = 0;
                        LeconRepository leconRepository = new LeconRepository();
                        ArrayList<Lecon> listeLecons = leconRepository.getAllBy(e); // Récupérer les leçons pour l'élève
                        ObservableList<Lecon> observableList = FXCollections.observableArrayList(listeLecons);
                        tvLeconEleve.setItems(observableList); // Ajouter les données au TableView
                        for (Lecon lecon : listeLecons) {
                            if (lecon.getReglee() == 1) { // Vérifie si la leçon est réglée
                                totalReglees++;
                            }
                        }
                        nbLecon.setText(String.valueOf(totalReglees));
                        if(leconRepository.getNbLeconValidee(e)>=15){
                            Alert alertP = new Alert(Alert.AlertType.INFORMATION);
                            alertP.setTitle("Important");
                            alertP.setHeaderText(null);
                            alertP.setContentText("Vous pouvez passez votre permis");
                            alertP.showAndWait();
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }



                } else {
                    // Identifiants incorrects
                    bpEleve.setVisible(false);
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur de connexion");
                    alert.setHeaderText(null);
                    alert.setContentText("Identifiant ou mot de passe incorrect.");
                    alert.showAndWait();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur de connexion");
                alert.setHeaderText(null);
                alert.setContentText("Une erreur est survenue lors de la connexion.");
                alert.showAndWait();
            }}





        if(radioBtnMoniteur.isSelected()){
            try {
                // Essayer de récupérer le compte basé sur les identifiants
                Compte compte = compteService.setCurrentCompte(login, mdp);

                if (compte != null) {
                    // Connexion réussie
                    m = new MoniteurRepository().setCurrentMoniteur(compte.getIdCompte());
                    lblNomMoniteur.setText(m.getNomMoniteur());
                    lblPrenomMoniteur.setText(m.getPrenomMoniteur());


                    // Afficher la page de l'élève
                    bpMoniteur.setVisible(true);

                    // Afficher une alerte de succès
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Connexion réussie");
                    alert.setHeaderText(null);
                    alert.setContentText("Bienvenue, " + compte.getLoginCompte());
                    alert.showAndWait();
                    //REMPLI INFO PERSO
                    txtnomM.setText(m.getNomMoniteur());
                    txtprenomM.setText(m.getPrenomMoniteur());
                    adresseM.setText(m.getAdresse());
                    codepostalM.setText(m.getCodePostal());
                    villeM.setText(m.getVille());
                    mailM.setText(m.getMail());
                    telephoneM.setText(m.getNumero());
                    //REMPLI PLANNING
                    colLeconM.setCellValueFactory(new PropertyValueFactory<>("idLecon"));
                    colDateM.setCellValueFactory(new PropertyValueFactory<>("dateLecon"));
                    colHeureM.setCellValueFactory(new PropertyValueFactory<>("heureLecon"));
                    colRegleeM.setCellValueFactory(new PropertyValueFactory<>("reglee"));
                    colMoniteurM.setCellValueFactory(new PropertyValueFactory<>("nom"));
                    colImatriculationM.setCellValueFactory(new PropertyValueFactory<>("immatriculation"));

                    try {
                        LeconRepository leconRepository = new LeconRepository();
                        ArrayList<Lecon> listeLecons = leconRepository.getAllBy(m); // Récupérer les leçons pour l'élève
                        ObservableList<Lecon> observableList = FXCollections.observableArrayList(listeLecons);
                        tvLeconMoniteur.setItems(observableList); // Ajouter les données au TableView
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }



                    //REMPLI LISTE DE CATEGORIE DE LICENCE
                    nomCategorie.setCellValueFactory(new PropertyValueFactory<>("libelle"));
                    try {
                        CategorieRepository categorieRepository= new CategorieRepository();
                        ArrayList<Categorie> listeCategories= categorieRepository.getAll(m);
                        ObservableList<Categorie> observableList = FXCollections.observableArrayList(listeCategories);
                        tvLicence.setItems(observableList);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    //REMPLI LISTE DE CATEGORIE DE LICENCE OBTENU
                    nomLicenceObtenu.setCellValueFactory(new PropertyValueFactory<>("libelle"));
                    try {
                        CategorieRepository categorieRepository= new CategorieRepository();
                        ArrayList<Categorie> listeCategories= categorieRepository.getAllObtenu(m);
                        ObservableList<Categorie> observableList = FXCollections.observableArrayList(listeCategories);
                        tvLicenceObtenu.setItems(observableList);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                } else {
                    // Identifiants incorrects
                    bpMoniteur.setVisible(false);
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur de connexion");
                    alert.setHeaderText(null);
                    alert.setContentText("Identifiant ou mot de passe incorrect.");
                    alert.showAndWait();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur de connexion");
                alert.setHeaderText(null);
                alert.setContentText("Une erreur est survenue lors de la connexion.");
                alert.showAndWait();
            }}

        if(radioBtnAdmin.isSelected()){
            Vehicule.setVisible(true);

        }
    }

    @FXML
    public void clickBtnAnnulerC(Event event) {
        bpConnexion.setVisible(false);
    }

    @FXML
    public void menuEleveClicked(Event event) {
    }

    @FXML
    public void btnInfoPersoEleveClicked(Event event) {
    }

    @FXML
    public void clickRadioBtnAdmin(Event event) {
    }

    @FXML
    public void clickRadioBtnMoniteur(Event event) {
    }

    @FXML
    public void clickRadioBtnEleve(Event event) {
    }

    @FXML
    public void validerInfo(Event event) throws SQLException {
        String nom = txtnomE.getText();
        String prenom = txtprenomE.getText();
        String adresse = adresseE.getText();
        String codePostal = codepostalE.getText();
        String ville = villeE.getText();
        String mail = mailE.getText();
        String telephone=telephoneE.getText();
        e.setNomEleve(nom);
        e.setPrenomEleve(prenom);
        e.setAdresse(adresse);
        e.setCodePostal(codePostal);
        e.setVille(ville);
        e.setMail(mail);
        e.setNumero(telephone);
        new EleveRepository().update(e);
    }

    @FXML
    public void menuEleveClickedPlanning(Event event) {
        bpPlanningEleve.setVisible(true);
        bpInfoEleve.setVisible(false);
        bpLeconEleve.setVisible(false);
        bpStatsEleve.setVisible(false);
    }

    @FXML
    public void menuEleveClickedAccueil(Event event) {
        bpInfoEleve.setVisible(true);
        bpPlanningEleve.setVisible(false);
        bpLeconEleve.setVisible(false);
        bpStatsEleve.setVisible(false);
    }

    @FXML
    public void validerInfoM(Event event) throws SQLException {
        String nom = txtnomM.getText();
        String prenom = txtprenomM.getText();
        String adresse = adresseM.getText();
        String codePostal = codepostalM.getText();
        String ville = villeM.getText();
        String mail = mailM.getText();
        String telephone=telephoneM.getText();
        m.setNomMoniteur(nom);
        m.setPrenomMoniteur(prenom);
        m.setAdresse(adresse);
        m.setCodePostal(codePostal);
        m.setVille(ville);
        m.setMail(mail);
        m.setNumero(telephone);
        new MoniteurRepository().update(m);
    }

    @FXML
    public void planningMoniteurClicked(Event event) {
        bpPlanningMoniteur.setVisible(true);
        bpInfoMoniteur.setVisible(false);
        bpStatMoniteur.setVisible(false);
        bpLicenceMoniteur.setVisible(false);
    }

    @FXML
    public void accueilMoniteurClicked(Event event) {
        bpInfoMoniteur.setVisible(true);
        bpPlanningMoniteur.setVisible(false);
        bpStatMoniteur.setVisible(false);
        bpLicenceMoniteur.setVisible(false);
    }

    @FXML
    public void licenceMoniteurClicked(Event event) {
        bpLicenceMoniteur.setVisible(true);
        bpInfoMoniteur.setVisible(false);
        bpPlanningMoniteur.setVisible(false);
        bpStatMoniteur.setVisible(false);
    }

    @FXML
    public void btnAjoutLicence(Event event) {
        try {
            // Vérifier si une licence est sélectionnée
            Categorie categorieSelectionnee = (Categorie) tvLicence.getSelectionModel().getSelectedItem();
            if (categorieSelectionnee == null) {
                System.out.println("Aucune licence sélectionnée !");
                return;
            }

            // Récupérer le libellé sélectionné
            String libelleSelectionne = categorieSelectionnee.getLibelle();

            // Créer une nouvelle licence
            Licence licence = new Licence();
            licence.setIdMoniteur(m.getIdMoniteur());

            // Initialiser les repositories
            LicenceRepository licenceRepository = new LicenceRepository();
            CategorieRepository categorieRepository = new CategorieRepository();

            // Associer l'ID de catégorie via le repository
            licence.setIdCategorie(categorieRepository.getIdCategorie(libelleSelectionne));

            // Ajouter la licence dans la base de données
            licenceRepository.createLicence(licence);

            // Mettre à jour les TableViews (supprimé et ajouté)
            tvLicenceObtenu.getItems().add(categorieSelectionnee);
            tvLicence.getItems().remove(categorieSelectionnee);

            System.out.println("Licence ajouté");
        } catch (SQLException e) {
            System.err.println("Erreur SQL lors de l'ajout de la licence : " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Une erreur inattendue est survenue : " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    public void clickBtnVehicule(Event event) throws SQLException {
        String Modele= modele.getText();
        String Immatriculation= immatriculation.getText();
        String Marque= marque.getText();
        Date Annee= Date.valueOf(annee.getValue());

        VehiculeRepository vehiculeRepository=new VehiculeRepository();
        vehiculeRepository.createVehicule(Modele, Immatriculation, Marque, Annee);

    }

    @FXML
    public void menuEleveClickedStats(Event event) {
        bpStatsEleve.setVisible(true);
        bpInfoEleve.setVisible(false);
        bpPlanningEleve.setVisible(false);
        bpLeconEleve.setVisible(false);
    }
}
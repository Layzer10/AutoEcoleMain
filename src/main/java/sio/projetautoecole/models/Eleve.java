package sio.projetautoecole.models;

public class Eleve {
    private int IdEleve;
    private String nomEleve;
    private String prenomEleve;
    private boolean sexe;
    private String dateNaissance;
    private String adresse;
    private String codePostal;
    private String ville;
    private String numero;
    private String mail;
    private int numCompte;


    public Eleve(int idEleve, String nomEleve, String prenomEleve, boolean sexe, String dateNaissance, String adresse, String codePostal, String ville, String numero, String mail) {
        IdEleve = idEleve;
        this.nomEleve = nomEleve;
        this.prenomEleve = prenomEleve;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.numero = numero;
        this.mail = mail;
    }

    public Eleve() {
    //Constructeur vide
    }

    public Eleve(int idEleve, String nomEleve, String prenomEleve, boolean sexe, String dateNaissance, String adresse, String codePostal, String ville, String numero, String mail, int numCompte) {
        this(idEleve, nomEleve, prenomEleve, sexe, dateNaissance, adresse, codePostal, ville, numero, mail);
        this.numCompte = numCompte; // Initialisation de numCompte dans la surcharge
    }


    public int getIdEleve() {
        return IdEleve;
    }

    public void setIdEleve(int idEleve) {
        IdEleve = idEleve;
    }

    public String getNomEleve() {
        return nomEleve;
    }

    public void setNomEleve(String nomEleve) {
        this.nomEleve = nomEleve;
    }

    public String getPrenomEleve() {
        return prenomEleve;
    }

    public void setPrenomEleve(String prenomEleve) {
        this.prenomEleve = prenomEleve;
    }

    public boolean getSexe() {
        return sexe;
    }

    public void setSexe(boolean sexe) {
        this.sexe = sexe;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isSexe() {
        return sexe;
    }
    public int getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(int numCompte) {
        this.numCompte = numCompte;
    }

}

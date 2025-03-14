package sio.projetautoecole.models;

public class Moniteur {
    private int IdMoniteur;
    private String nomMoniteur;
    private String prenomMoniteur;
    private boolean sexe;
    private String dateNaissance;
    private String adresse;
    private String codePostal;
    private String ville;
    private String numero;
    private String mail;
    private int numCompte;

    public Moniteur(int idMoniteur, String nomMoniteur, String prenomMoniteur, boolean sexe, String dateNaissance, String adresse, String codePostal, String ville, String numero, String mail) {
        IdMoniteur = idMoniteur;
        this.nomMoniteur = nomMoniteur;
        this.prenomMoniteur = prenomMoniteur;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.numero = numero;
        this.mail = mail;
    }
    public Moniteur(int idMoniteur, String nomMoniteur, String prenomMoniteur, boolean sexe, String dateNaissance, String adresse, String codePostal, String ville, String numero, String mail, int numCompte) {
        IdMoniteur = idMoniteur;
        this.nomMoniteur = nomMoniteur;
        this.prenomMoniteur = prenomMoniteur;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.numero = numero;
        this.mail = mail;
        this.numCompte = numCompte;
    }
    public Moniteur(){

    }

    public int getIdMoniteur() {
        return IdMoniteur;
    }

    public void setIdMoniteur(int idMoniteur) {
        IdMoniteur = idMoniteur;
    }

    public String getNomMoniteur() {
        return nomMoniteur;
    }

    public void setNomMoniteur(String nomMoniteur) {
        this.nomMoniteur = nomMoniteur;
    }

    public String getPrenomMoniteur() {
        return prenomMoniteur;
    }

    public void setPrenomMoniteur(String prenomMoniteur) {
        this.prenomMoniteur = prenomMoniteur;
    }

    public boolean isSexe() {
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

    public int getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(int numCompte) {
        this.numCompte = numCompte;
    }
}

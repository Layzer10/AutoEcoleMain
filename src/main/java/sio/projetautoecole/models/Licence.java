package sio.projetautoecole.models;

import java.util.Date;

public class Licence {
    private int IdLicence;
    private Date DateLicence;
    private int IdMoniteur;
    private int IdCategorie;

    public Licence(int idLicence, Date dateLicence) {
        IdLicence = idLicence;
        DateLicence = dateLicence;
    }

    public Licence() {

    }

    public int getIdMoniteur() {
        return IdMoniteur;
    }

    public void setIdMoniteur(int idMoniteur) {
        IdMoniteur = idMoniteur;
    }

    public int getIdCategorie() {
        return IdCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        IdCategorie = idCategorie;
    }

    public Licence( int idMoniteur, int idCategorie) {
        IdMoniteur = idMoniteur;
        IdCategorie = idCategorie;
    }

    public int getIdLicence() {
        return IdLicence;
    }

    public void setIdLicence(int idLicence) {
        IdLicence = idLicence;
    }

    public Date getDateLicence() {
        return DateLicence;
    }

    public void setDateLicence(Date dateLicence) {
        DateLicence = dateLicence;
    }
}

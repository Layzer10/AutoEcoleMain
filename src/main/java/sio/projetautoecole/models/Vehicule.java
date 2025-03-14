package sio.projetautoecole.models;

import java.util.Date;

public class Vehicule {
    private String IdImmatriculation;
    private String Marque;
    private String Modele;
    private Date Annee;

    public Vehicule(String idImmatriculation, String marque, String modele, Date annee) {
        IdImmatriculation = idImmatriculation;
        Marque = marque;
        Modele = modele;
        Annee = annee;
    }

    public Vehicule() {

    }

    public String getIdImmatriculation() {
        return IdImmatriculation;
    }

    public void setIdImmatriculation(String idImmatriculation) {
        IdImmatriculation = idImmatriculation;
    }

    public String getMarque() {
        return Marque;
    }

    public void setMarque(String marque) {
        Marque = marque;
    }

    public String getModele() {
        return Modele;
    }

    public void setModele(String modele) {
        Modele = modele;
    }

    public Date getAnnee() {
        return Annee;
    }

    public void setAnnee(Date annee) {
        Annee = annee;
    }

}

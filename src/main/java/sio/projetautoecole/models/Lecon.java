package sio.projetautoecole.models;

import java.util.Date;

public class Lecon {
    private int IdLecon;
    private Date DateLecon;
    private String HeureLecon;
    private int Reglee;
    private int CodeMoniteur;
    private String Immatriculation;
    private int CodeEleve;
    private String Nom;
    private boolean Validee;


    public Lecon(int idLecon, Date dateLecon, String heureLecon, int reglee, boolean validee) {
        IdLecon = idLecon;
        DateLecon = dateLecon;
        HeureLecon = heureLecon;
        Reglee = reglee;
        Validee= validee;
    }

    public Lecon(int idLecon, Date dateLecon, String heureLecon, int reglee) {
        IdLecon = idLecon;
        DateLecon = dateLecon;
        HeureLecon = heureLecon;
        Reglee = reglee;
    }

    public Lecon() {

    }

    public boolean isValidee() {
        return Validee;
    }

    public void setValidee(boolean validee) {
        Validee = validee;
    }

    public int getCodeMoniteur() {
        return CodeMoniteur;
    }

    public void setCodeMoniteur(int codeMoniteur) {
        CodeMoniteur = codeMoniteur;
    }

    public String getImmatriculation() {
        return Immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        Immatriculation = immatriculation;
    }

    public int getCodeEleve() {
        return CodeEleve;
    }

    public void setCodeEleve(int codeEleve) {
        CodeEleve = codeEleve;
    }


    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public Lecon(int idLecon, Date dateLecon, String heureLecon, int reglee, String immatriculation, String nom) {
        IdLecon = idLecon;
        DateLecon = dateLecon;
        HeureLecon = heureLecon;
        Reglee = reglee;
        Immatriculation = immatriculation;
        Nom=nom;
    }




    public int getIdLecon() {
        return IdLecon;
    }

    public void setIdLecon(int idLecon) {
        IdLecon = idLecon;
    }

    public Date getDateLecon() {
        return DateLecon;
    }

    public void setDateLecon(Date dateLecon) {
        DateLecon = dateLecon;
    }

    public int getReglee() {
        return Reglee;
    }

    public void setReglee(int reglee) {
        Reglee = reglee;
    }


    public String getHeureLecon() {
        return HeureLecon;
    }

    public void setHeureLecon(String heureLecon) {
        HeureLecon = heureLecon;
    }
}

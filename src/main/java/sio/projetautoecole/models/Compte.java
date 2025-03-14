package sio.projetautoecole.models;

import java.util.Date;

public class Compte {
    private int IdCompte;
    private String loginCompte;
    private String mdpCompte;
    private int statutCompte;

    public Compte() {

    }


    public int getIdCompte() {
        return IdCompte;
    }

    public void setIdCompte(int idCompte) {
        IdCompte = idCompte;
    }

    public String getLoginCompte() {
        return loginCompte;
    }

    public void setLoginCompte(String loginCompte) {
        this.loginCompte = loginCompte;
    }

    public String getMdpCompte() {
        return mdpCompte;
    }

    public void setMdpCompte(String mdpCompte) {
        this.mdpCompte = mdpCompte;
    }

    public int getStatutCompte() {
        return statutCompte;
    }

    public void setStatutCompte(int statutCompte) {
        this.statutCompte = statutCompte;
    }

    public Compte(int idCompte, String loginCompte, String mdpCompte, int statutCompte) {
        IdCompte = idCompte;
        this.loginCompte = loginCompte;
        this.mdpCompte = mdpCompte;
        this.statutCompte = statutCompte;
    }
}

package sio.projetautoecole.controllers;

import sio.projetautoecole.models.Eleve;
import sio.projetautoecole.models.Moniteur;
import sio.projetautoecole.services.MoniteurService;

import java.sql.SQLException;
import java.util.ArrayList;

public class MoniteurController {
    private MoniteurService moniteurService;

    public MoniteurController() {
        this.moniteurService = new MoniteurService() ;
    }


    public ArrayList<Moniteur> getAll() throws SQLException {
        return moniteurService.getAll();
    }
}

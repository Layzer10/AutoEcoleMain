package sio.projetautoecole.services;

import sio.projetautoecole.models.Eleve;
import sio.projetautoecole.models.Moniteur;
import sio.projetautoecole.repositories.MoniteurRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class MoniteurService {
    private MoniteurRepository moniteurRepository;

    public MoniteurService() {
        this.moniteurRepository = new MoniteurRepository() ;
    }


    public ArrayList<Moniteur> getAll() throws SQLException {
        return moniteurRepository.getAll();
    }
}

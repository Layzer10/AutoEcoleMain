package sio.projetautoecole.services;

import sio.projetautoecole.models.Eleve;
import sio.projetautoecole.repositories.EleveRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class EleveService {
    private EleveRepository eleveRepository;

    public EleveService() {
        this.eleveRepository = new EleveRepository() ;
    }


    public ArrayList<Eleve> getAll() throws SQLException {
        return eleveRepository.getAll();
    }
    public Eleve setCurrentEleve(int numCompte) throws SQLException{
        Eleve eleve = eleveRepository.setCurrentEleve(numCompte);
        return eleve;
    }

}

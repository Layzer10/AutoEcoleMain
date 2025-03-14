package sio.projetautoecole.services;

import sio.projetautoecole.models.Eleve;
import sio.projetautoecole.models.Lecon;
import sio.projetautoecole.repositories.LeconRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class LeconService
{
    private LeconRepository LeconRepository;

    public LeconService() {
        this.LeconRepository = new LeconRepository() ;
    }

    public ArrayList<Lecon> getAllBy(Eleve eleve) throws SQLException {
        return LeconRepository.getAllBy(eleve);
    }

    public ArrayList<Lecon> getAll() throws SQLException {
        return LeconRepository.getAll();
    }
}

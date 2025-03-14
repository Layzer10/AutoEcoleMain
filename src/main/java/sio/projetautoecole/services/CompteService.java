package sio.projetautoecole.services;

import sio.projetautoecole.models.Compte;
import sio.projetautoecole.repositories.CompteRepository;

import java.sql.SQLException;

public class CompteService {

    private CompteRepository compteRepository;

    public CompteService() {
        this.compteRepository = new CompteRepository();
    }

    public Compte setCurrentCompte(String login, String password) throws SQLException {
        return compteRepository.setCurrentCompte(login, password);
    }
}

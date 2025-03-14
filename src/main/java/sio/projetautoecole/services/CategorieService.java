package sio.projetautoecole.services;

import sio.projetautoecole.models.Categorie;
import sio.projetautoecole.repositories.CategorieRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class CategorieService {
    private CategorieRepository CategorieRepository;

    public CategorieService() {
        this.CategorieRepository = new CategorieRepository() ;
    }


    public ArrayList<Categorie> getAll() throws SQLException {
        return CategorieRepository.getAll();
    }
}

package sio.projetautoecole.controllers;

import sio.projetautoecole.models.Categorie;
import sio.projetautoecole.repositories.CategorieRepository;
import sio.projetautoecole.services.CategorieService;

import java.sql.SQLException;
import java.util.ArrayList;

public class CategorieController {
    private CategorieService CategorieService;

    public CategorieController() {
        this.CategorieService = new CategorieService() ;
    }


    public ArrayList<Categorie> getAll() throws SQLException {
        return CategorieService.getAll();
    }
}

package sio.projetautoecole.controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import sio.projetautoecole.models.Eleve;
import sio.projetautoecole.repositories.EleveRepository;
import sio.projetautoecole.services.EleveService;

import java.sql.SQLException;
import java.util.ArrayList;

public class EleveController {

    private EleveService eleveService;

    public EleveController() {
        this.eleveService = new EleveService() ;
    }


    public ArrayList<Eleve> getAll() throws SQLException {
        return eleveService.getAll();
    }
    public Eleve setCurrentEleve(int numCompte) throws SQLException{
        Eleve eleve = eleveService.setCurrentEleve(numCompte);
        return eleve;
    }

}


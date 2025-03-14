package sio.projetautoecole.controllers;

import sio.projetautoecole.models.Eleve;
import sio.projetautoecole.models.Lecon;
import sio.projetautoecole.services.LeconService;
import java.sql.SQLException;
import java.util.ArrayList;

public class LeconController
{
    private LeconService LeconService;

    public LeconController() {
        this.LeconService = new LeconService();
    }

    public ArrayList<Lecon> getAllBy(Eleve eleve) throws SQLException {
        return LeconService.getAllBy(eleve);
    }

    public ArrayList<Lecon> getAll() throws SQLException {
        return LeconService.getAll();
    }
}
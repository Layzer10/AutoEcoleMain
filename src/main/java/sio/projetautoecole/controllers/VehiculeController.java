package sio.projetautoecole.controllers;

import sio.projetautoecole.models.Vehicule;
import sio.projetautoecole.services.VehiculeService;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehiculeController
{
    private VehiculeService VehiculeService;

    public VehiculeController() {
        this.VehiculeService = new VehiculeService();
    }

    public ArrayList<Vehicule> getAllBy(int id) throws SQLException {
        return VehiculeService.getAllBy(id);
    }

    public ArrayList<Vehicule> getAll() throws SQLException {
        return VehiculeService.getAll();
    }
}


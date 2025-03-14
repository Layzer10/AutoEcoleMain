package sio.projetautoecole.services;


import sio.projetautoecole.models.Vehicule;
import sio.projetautoecole.repositories.VehiculeRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class VehiculeService
{
    private VehiculeRepository VehiculeRepository;

    public VehiculeService() {
        this.VehiculeRepository = new VehiculeRepository() ;
    }

    public ArrayList<Vehicule> getAllBy(int id) throws SQLException {
        return VehiculeRepository.getAllBy(id);
    }

    public ArrayList<Vehicule> getAll() throws SQLException {
        return VehiculeRepository.getAll();
    }
}

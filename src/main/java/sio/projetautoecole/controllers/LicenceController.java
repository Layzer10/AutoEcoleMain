package sio.projetautoecole.controllers;

import sio.projetautoecole.models.Licence;
import sio.projetautoecole.services.LicenceService;
import java.sql.SQLException;
import java.util.ArrayList;

public class LicenceController
{
    private LicenceService LicenceService;

    public LicenceController() {
        this.LicenceService = new LicenceService();
    }

    public ArrayList<Licence> getAllBy(int id) throws SQLException {
        return LicenceService.getAllBy(id);
    }

    public ArrayList<Licence> getAll() throws SQLException {
        return LicenceService.getAll();
    }
}

package sio.projetautoecole.services;
import sio.projetautoecole.models.Licence;
import sio.projetautoecole.repositories.LicenceRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class LicenceService
{
    private LicenceRepository LicenceRepository;

    public LicenceService() {
        this.LicenceRepository = new LicenceRepository() ;
    }

    public ArrayList<Licence> getAllBy(int id) throws SQLException {
        return LicenceRepository.getAllBy(id);
    }

    public ArrayList<Licence> getAll() throws SQLException {
        return LicenceRepository.getAll();
    }
}

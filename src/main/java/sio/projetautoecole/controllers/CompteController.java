package sio.projetautoecole.controllers;


import sio.projetautoecole.services.CompteService;

public class CompteController {

    private CompteService compteService;

    public CompteController() {
        this.compteService = new CompteService();
    }

}

package it.epicode;

import it.epicode.dao.LibroDao;
import it.epicode.dao.PrestitoDao;
import it.epicode.dao.RivistaDao;
import it.epicode.dao.UtenteDao;

public class UsaArchivio {
    public static void main(String[] args) {
        LibroDao libroDao = new LibroDao();
        RivistaDao rivistaDao = new RivistaDao();
        PrestitoDao prestitoDao = new PrestitoDao();
        UtenteDao utenteDao = new UtenteDao();
    }
}

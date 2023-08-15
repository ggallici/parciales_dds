package cl.tenpo.utils.encrypt.parcial.jobs;

import cl.tenpo.utils.encrypt.parcial.grillas.Grilla;
import cl.tenpo.utils.encrypt.parcial.grillas.RepositorioPerfiles;

public class ActualizadorUbicaciones {
    // Correr con crontab cada 1 min
    public static void main(String[] args) {
        var grilla = new Grilla(new RepositorioPerfiles());
        grilla.actualizarUbicacionesDePerfiles();
    }
}

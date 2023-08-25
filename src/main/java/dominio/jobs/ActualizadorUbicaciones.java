package dominio.jobs;

import dominio.grillas.Grilla;
import dominio.grillas.RepositorioPerfiles;

public class ActualizadorUbicaciones {
    // Correr con crontab cada 1 min
    public static void main(String[] args) {
        var grilla = new Grilla(new RepositorioPerfiles());
        grilla.actualizarUbicacionesDePerfiles();
    }
}

package dominio.grillas.filtros.rango;

import dominio.Perfil;

public class FiltroRangoEdad extends FiltroRango<Integer> {
    @Override
    protected Integer atributo(Perfil perfil) {
        return perfil.getEdad();
    }
}

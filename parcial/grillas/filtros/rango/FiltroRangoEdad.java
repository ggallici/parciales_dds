package cl.tenpo.utils.encrypt.parcial.grillas.filtros.rango;

import cl.tenpo.utils.encrypt.parcial.Perfil;

public class FiltroRangoEdad extends FiltroRango<Integer> {
    @Override
    protected Integer atributo(Perfil perfil) {
        return perfil.getEdad();
    }
}

package cl.tenpo.utils.encrypt.parcial.grillas.filtros.rango;

import cl.tenpo.utils.encrypt.parcial.Perfil;

public class FiltroRangoPeso extends FiltroRango<Float> {
    @Override
    protected Float atributo(Perfil perfil) {
        return perfil.getPeso();
    }
}

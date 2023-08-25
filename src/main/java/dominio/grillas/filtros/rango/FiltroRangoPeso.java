package dominio.grillas.filtros.rango;

import dominio.Perfil;

public class FiltroRangoPeso extends FiltroRango<Float> {
    @Override
    protected Float atributo(Perfil perfil) {
        return perfil.getPeso();
    }
}

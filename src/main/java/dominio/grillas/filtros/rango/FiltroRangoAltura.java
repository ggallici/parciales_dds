package dominio.grillas.filtros.rango;

import dominio.Perfil;

public class FiltroRangoAltura extends FiltroRango<Float> {
    @Override
    protected Float atributo(Perfil perfil) {
        return perfil.getAltura();
    }
}

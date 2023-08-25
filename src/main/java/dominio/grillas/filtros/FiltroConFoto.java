package dominio.grillas.filtros;

import dominio.Perfil;

public abstract class FiltroConFoto implements Filtro {
    @Override
    public boolean seCumplePara(Perfil perfil) {
        return perfil.tieneFotoAceptada();
    }
}

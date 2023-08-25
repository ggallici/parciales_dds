package dominio.grillas.filtros;

import dominio.Perfil;

public abstract class FiltroSinFoto implements Filtro {
    @Override
    public boolean seCumplePara(Perfil perfil) {
        return perfil.noTieneFoto() || perfil.tieneFotoPendiente() || perfil.tieneFotoRechazada();
    }
}

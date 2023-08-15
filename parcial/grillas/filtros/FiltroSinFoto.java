package cl.tenpo.utils.encrypt.parcial.grillas.filtros;

import cl.tenpo.utils.encrypt.parcial.Perfil;

public abstract class FiltroSinFoto implements Filtro {
    @Override
    public boolean seCumplePara(Perfil perfil) {
        return perfil.noTieneFoto() || perfil.tieneFotoPendiente() || perfil.tieneFotoRechazada();
    }
}

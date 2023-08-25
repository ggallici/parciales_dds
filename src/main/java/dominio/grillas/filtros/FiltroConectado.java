package dominio.grillas.filtros;

import dominio.Perfil;

public abstract class FiltroConectado implements Filtro {
    @Override
    public boolean seCumplePara(Perfil perfil) {
        return perfil.estaConectado();
    }
}

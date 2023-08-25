package dominio.grillas.filtros;

import dominio.Perfil;

public abstract class FiltroDesconectado implements Filtro {
    @Override
    public boolean seCumplePara(Perfil perfil) {
        return perfil.estaDesconectado();
    }
}

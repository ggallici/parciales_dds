package dominio.grillas.filtros;

import dominio.Perfil;
import dominio.perfiles.TipoGenero;

public class FiltroGenero implements Filtro {
    private TipoGenero tipoGenero;

    @Override
    public boolean seCumplePara(Perfil perfil) {
        return perfil.tieneTipoGenero(tipoGenero);
    }
}

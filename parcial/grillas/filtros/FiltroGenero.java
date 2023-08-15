package cl.tenpo.utils.encrypt.parcial.grillas.filtros;

import cl.tenpo.utils.encrypt.parcial.Perfil;
import cl.tenpo.utils.encrypt.parcial.perfiles.TipoGenero;

public class FiltroGenero implements Filtro {
    private TipoGenero tipoGenero;

    @Override
    public boolean seCumplePara(Perfil perfil) {
        return perfil.tieneTipoGenero(tipoGenero);
    }
}

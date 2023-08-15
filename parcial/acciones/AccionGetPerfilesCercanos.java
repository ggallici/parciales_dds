package cl.tenpo.utils.encrypt.parcial.acciones;

import cl.tenpo.utils.encrypt.parcial.Perfil;
import cl.tenpo.utils.encrypt.parcial.grillas.filtros.Filtro;
import cl.tenpo.utils.encrypt.parcial.tipos.Tipo;

import java.util.List;

public class AccionGetPerfilesCercanos extends Accion<List<Perfil>> {
    private List<Filtro> filtros;
    private List<Tipo> tipos;

    public AccionGetPerfilesCercanos(List<Filtro> filtros, List<Tipo> tipos) {
        this.filtros = filtros;
        this.tipos = tipos;
    }

    @Override
    protected List<Perfil> realizar(Perfil perfil) {
        return perfil._getPerfilesCercanos(filtros, tipos);
    }
}

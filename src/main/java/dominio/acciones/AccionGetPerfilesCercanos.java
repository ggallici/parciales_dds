package dominio.acciones;

import dominio.Perfil;
import dominio.grillas.filtros.Filtro;
import dominio.tipos.Tipo;

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

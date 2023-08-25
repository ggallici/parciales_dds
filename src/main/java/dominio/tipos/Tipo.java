package dominio.tipos;

import dominio.Perfil;
import dominio.grillas.filtros.Filtro;

import java.util.List;

public class Tipo implements Filtro {
    private String nombre;
    private List<Filtro> filtros;

    @Override
    public boolean seCumplePara(Perfil perfil) {
        return filtros.stream().allMatch(filtro -> filtro.seCumplePara(perfil));
    }
}

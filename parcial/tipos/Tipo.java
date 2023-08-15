package cl.tenpo.utils.encrypt.parcial.tipos;

import cl.tenpo.utils.encrypt.parcial.Perfil;
import cl.tenpo.utils.encrypt.parcial.grillas.filtros.Filtro;

import java.util.List;

public class Tipo implements Filtro {
    private String nombre;
    private List<Filtro> filtros;

    @Override
    public boolean seCumplePara(Perfil perfil) {
        return filtros.stream().allMatch(filtro -> filtro.seCumplePara(perfil));
    }
}

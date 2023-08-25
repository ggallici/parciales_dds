package dominio.grillas.filtros;

import dominio.Perfil;

public interface Filtro {
    boolean seCumplePara(Perfil perfil);
}

package dominio.grillas;

import dominio.Perfil;

import java.util.List;

public class RepositorioPerfiles {
    private List<Perfil> perfiles;

    public List<Perfil> findAll() {
        return perfiles;
    }
}

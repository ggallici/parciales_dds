package cl.tenpo.utils.encrypt.parcial.grillas;

import cl.tenpo.utils.encrypt.parcial.Perfil;
import cl.tenpo.utils.encrypt.parcial.grillas.filtros.Filtro;
import cl.tenpo.utils.encrypt.parcial.tipos.Tipo;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Grilla {
    private static final int MAXIMO_DE_PERFILES_A_VISUALIZAR = 100;

    private RepositorioPerfiles repositorioPerfiles;

    public Grilla(RepositorioPerfiles repositorioPerfiles) {
        this.repositorioPerfiles = repositorioPerfiles;
    }

    public List<Perfil> perfilesCercanosA(Perfil perfil, List<Filtro> filtros, List<Tipo> tipos) {
        return repositorioPerfiles.findAll().stream()
                .filter(noEs(perfil))
                .filter(cumpleConTodosLos(filtros))
                .filter(cumpleConAlgunoDeLos(tipos))
                .sorted(distanciaA(perfil))
                .limit(MAXIMO_DE_PERFILES_A_VISUALIZAR)
                .toList();
    }

    public void actualizarUbicacionesDePerfiles() {
        repositorioPerfiles.findAll().stream()
                .filter(Perfil::necesitaActualizarUbicacion)
                .forEach(Perfil::actualizarUbicacion);
    }

    public void notificarInteresadosSobrePerfilCercano(Perfil perfil) {
        repositorioPerfiles.findAll().stream()
                .filter(noEs(perfil))
                .filter(estaInteresadoEn(perfil))
                .forEach(notificarPerfilCercano(perfil));
    }

    private Predicate<Perfil> noEs(Perfil unPerfil) {
        return otroPerfil -> !otroPerfil.equals(unPerfil);
    }

    private Predicate<Perfil> cumpleConTodosLos(List<Filtro> filtros) {
        return perfil -> filtros.stream().allMatch(filtro -> filtro.seCumplePara(perfil));
    }

    private Predicate<Perfil> cumpleConAlgunoDeLos(List<Tipo> tipos) {
        return perfil -> tipos.stream().anyMatch(tipo -> tipo.seCumplePara(perfil));
    }

    private Comparator<Perfil> distanciaA(Perfil unPefil) {
        return Comparator.comparing(otroPerfil -> otroPerfil.distanciaA(unPefil));
    }

    private Predicate<Perfil> estaInteresadoEn(Perfil unPerfil) {
        return otroPerfil -> unPerfil.encajaConAlgunaDeLasAlertasDe(otroPerfil);
    }

    private Consumer<Perfil> notificarPerfilCercano(Perfil unPerfil) {
        return otroPerfil -> otroPerfil.notificarPerfilCercano(unPerfil);
    }
}

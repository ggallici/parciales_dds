package cl.tenpo.utils.encrypt.parcial.grillas.filtros.rango;

import cl.tenpo.utils.encrypt.parcial.Perfil;
import cl.tenpo.utils.encrypt.parcial.grillas.filtros.Filtro;

import java.util.Optional;

public abstract class FiltroRango<T extends Comparable<T>> implements Filtro {
    private T minimo;
    private T maximo;

    @Override
    public boolean seCumplePara(Perfil perfil) {
        return Optional.ofNullable(atributo(perfil))
                .map(atributo -> esMayorAlMinimo(atributo) && esMenorAlMaximo(atributo))
                .orElse(false);
    }

    private boolean esMayorAlMinimo(T atributo) {
        return atributo.compareTo(minimo) >= 0;
    }

    private boolean esMenorAlMaximo(T atributo) {
        return atributo.compareTo(maximo) <= 0;
    }

    protected abstract T atributo(Perfil perfil);
}

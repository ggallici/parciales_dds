package cl.tenpo.utils.encrypt.parcial.acciones;

import cl.tenpo.utils.encrypt.parcial.Perfil;

public abstract class Accion<T> {
    public T realizarSobre(Perfil perfil) {
        var resultado = realizar(perfil);

        perfil.actualizarUbicacion();
        perfil.actualizarHorarioUltimaAccion();

        return resultado;
    }

    protected abstract T realizar(Perfil perfil);
}

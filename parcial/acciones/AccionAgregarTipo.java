package cl.tenpo.utils.encrypt.parcial.acciones;

import cl.tenpo.utils.encrypt.parcial.Perfil;
import cl.tenpo.utils.encrypt.parcial.tipos.Tipo;

public class AccionAgregarTipo extends Accion<Void> {
    private Tipo tipo;

    public AccionAgregarTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    protected Void realizar(Perfil perfil) {
        perfil._agregarTipo(tipo);

        return null;
    }
}

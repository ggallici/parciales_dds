package dominio.acciones;

import dominio.Perfil;
import dominio.tipos.Tipo;

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

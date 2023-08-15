package cl.tenpo.utils.encrypt.parcial.acciones;

import cl.tenpo.utils.encrypt.parcial.Perfil;
import cl.tenpo.utils.encrypt.parcial.fotos.Foto;

public class AccionSetFoto extends Accion<Void> {
    private Foto foto;

    public AccionSetFoto(Foto foto) {
        this.foto = foto;
    }

    @Override
    protected Void realizar(Perfil perfil) {
        perfil._setFoto(foto);

        return null;
    }
}

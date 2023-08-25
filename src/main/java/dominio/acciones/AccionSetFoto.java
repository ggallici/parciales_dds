package dominio.acciones;

import dominio.Perfil;
import dominio.fotos.Foto;

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

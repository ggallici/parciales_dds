package dominio.fotos;

import dominio.exceptions.TransicionInvalidaException;

public enum EstadoFoto {
    PENDIENTE {
        @Override
        public void aceptar(Foto foto) {
            foto.setEstado(ACEPTADA);
        }

        @Override
        public void rechazar(Foto foto) {
            foto.setEstado(RECHAZADA);
        }

        @Override
        public boolean estaPendiente() {
            return true;
        }
    },
    ACEPTADA {
        @Override
        public boolean estaAceptada() {
            return true;
        }
    },
    RECHAZADA {
        @Override
        public boolean estaRechazada() {
            return true;
        }
    };

    private static final String MSJ_FOTO_NO_SE_PUEDE = "No se puede %s una foto en estado: %s";
    private static final String MSJ_ACEPTAR = "aceptar";
    private static final String MSJ_RECHAZAR = "rechazar";

    public void aceptar(Foto foto) {
        throw new TransicionInvalidaException(MSJ_FOTO_NO_SE_PUEDE.formatted(MSJ_ACEPTAR, this));
    }

    public void rechazar(Foto foto) {
        throw new TransicionInvalidaException(MSJ_FOTO_NO_SE_PUEDE.formatted(MSJ_RECHAZAR, this));
    }

    public boolean estaPendiente() {
        return false;
    }

    public boolean estaAceptada() {
        return false;
    }

    public boolean estaRechazada() {
        return false;
    }
}

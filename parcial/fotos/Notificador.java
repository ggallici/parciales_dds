package cl.tenpo.utils.encrypt.parcial.fotos;

import cl.tenpo.utils.encrypt.parcial.Perfil;

public interface Notificador {
    // asumo que `Perfil` y `Usuario` son lo mismo porque no tengo mas información
    void enviarNotificacion(Perfil perfil, String mensaje);
}

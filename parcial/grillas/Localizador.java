package cl.tenpo.utils.encrypt.parcial.grillas;

import cl.tenpo.utils.encrypt.parcial.Perfil;

public interface Localizador {
    // asumo que `Perfil` y `Usuario` son lo mismo porque no tengo mas información
    Ubicacion localizar(Perfil perfil);
}

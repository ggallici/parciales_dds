package dominio.grillas;

import dominio.Perfil;

public interface Localizador {
    // asumo que `Perfil` y `Usuario` son lo mismo porque no tengo mas información
    Ubicacion localizar(Perfil perfil);
}

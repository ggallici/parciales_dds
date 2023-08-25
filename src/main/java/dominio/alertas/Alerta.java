package dominio.alertas;

import dominio.Perfil;
import dominio.exceptions.AlertaInvalidaException;
import dominio.tipos.Tipo;

public class Alerta {
    private static final String MSJ_NO_SE_PERMITEN_ALERTAS_MAS_LEJANAS_QUE = "No se permiten alertas >= a %f kms";

    private static final float KILOMETROS_MAXIMOS_PERMITIDOS = 3;

    private Tipo tipo;
    private float distancia;

    public Alerta(Tipo tipo, float distancia) {
        if (distancia >= KILOMETROS_MAXIMOS_PERMITIDOS) {
            throw new AlertaInvalidaException(MSJ_NO_SE_PERMITEN_ALERTAS_MAS_LEJANAS_QUE.formatted(KILOMETROS_MAXIMOS_PERMITIDOS));
        }

        this.tipo = tipo;
        this.distancia = distancia;
    }

    public boolean coincideDistancia(Perfil unPerfil, Perfil otroPerfil) {
        return unPerfil.distanciaA(otroPerfil) <= distancia;
    }

    public boolean coincideTipo(Perfil perfil) {
        return tipo.seCumplePara(perfil);
    }
}

package cl.tenpo.utils.encrypt.parcial.grillas;

public interface Ubicacion {
    double getLatitud();
    double getLongitud();
    double distanciaA(Ubicacion otra);
}

package dominio.grillas;

public interface Ubicacion {
    double getLatitud();
    double getLongitud();
    double distanciaA(Ubicacion otra);
}

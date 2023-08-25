package dominio.fotos;

import dominio.fotos.externo.VerifyGPT;

public class CreadorFotosGPT implements CreadorFotos {
    private VerifyGPT verifyGPT;

    @Override
    public Foto crearFoto(String url) {
        return new Foto(url, determinarEstado(url));
    }

    private EstadoFoto determinarEstado(String url) {
        var porcentaje = verifyGPT.rateContentSafery(url);

        if (porcentaje > 0.7)
            return EstadoFoto.ACEPTADA;
        if (porcentaje < 0.3)
            return EstadoFoto.RECHAZADA;

        return EstadoFoto.PENDIENTE;
    }
}
